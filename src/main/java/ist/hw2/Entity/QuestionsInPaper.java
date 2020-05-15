package ist.hw2.Entity;

import javax.persistence.*;

@Entity
public class QuestionsInPaper {
    @Id
    @GeneratedValue
    public Long relation_id;

    @Column
    private Integer score;

    @Column
    private String answer_content;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "TestPaperID",foreignKey = @ForeignKey(name = "TestPaperID",value = ConstraintMode.CONSTRAINT))
    public TestPaper testPaper;

    @ManyToOne
    @JoinColumn(name = "questionID",foreignKey = @ForeignKey(name = "questionID",value = ConstraintMode.CONSTRAINT))
    public Question question;

    public Long getRelation_id() {
        return relation_id;
    }

    public Question getQuestion() {
        return question;
    }

    public TestPaper getTestPaper() {
        return testPaper;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setRelation_id(Long relation_id) {
        this.relation_id = relation_id;
    }

    public void setTestPaper(TestPaper testPaper) {
        this.testPaper = testPaper;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}


