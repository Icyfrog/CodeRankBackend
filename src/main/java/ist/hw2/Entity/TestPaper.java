package ist.hw2.Entity;


import javax.persistence.*;

@Entity
public class TestPaper {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column
    private String create_time;

    @Column
    private String description;

    @Column
    private String answer_content;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public String getAnswer_content() {
        return answer_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
