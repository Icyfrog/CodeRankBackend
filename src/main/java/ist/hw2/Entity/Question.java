package ist.hw2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
//@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer questionID;

    // we use mysql to save the question_content and reference_answer temporarily
    @Column
    private String question_content;

    @Column
    private String name;

    @Column
    private String reference_answer;

    @Column
    private Integer quality;

    @Column
    private String domain;

    @Column
    private Integer difficulty;

    @Column
    private Integer approximate_time;       // unit of time: minute

    // Don't forget set/get function
    public Integer getId() {
        return questionID;
    }

    public void setId(Integer id) {
        this.questionID = id;
    }

    public Integer getQuality() {
        return quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


    public Integer getApproximate_time() {
        return approximate_time;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public String getReference_answer() {
        return reference_answer;
    }

    public void setApproximate_time(Integer approximate_time) {
        this.approximate_time = approximate_time;
    }


    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public void setReference_answer(String reference_answer) {
        this.reference_answer = reference_answer;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }
}
