package ist.hw2.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class TestPaper {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer TestPaperID;

    @Column
    private String create_time;

    @Column
    private String tittle;

    @Column
    private Integer answer_content_id;

    @Column
    private Integer time;

    @Column
    private String deadline;

    @Column
    private Integer status;

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getTestPaperID() {
        return TestPaperID;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getTittle() {
        return tittle;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Integer getAnswer_content_id() {
        return answer_content_id;
    }

    public String getCreate_time() {
        return create_time;
    }


    public void setAnswer_content_id(Integer answer_content_id) {
        this.answer_content_id = answer_content_id;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setTestPaperID(Integer testPaperID) {
        TestPaperID = testPaperID;
    }
}
