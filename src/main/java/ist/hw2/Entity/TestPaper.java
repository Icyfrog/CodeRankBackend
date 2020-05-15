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
    private String description;

    @Column
    private Integer answer_content_id;


    public void setId(Integer id) {
        this.TestPaperID = id;
    }

    public Integer getId() {
        return TestPaperID;
    }

    public Integer getAnswer_content_id() {
        return answer_content_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setAnswer_content_id(Integer answer_content_id) {
        this.answer_content_id = answer_content_id;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
