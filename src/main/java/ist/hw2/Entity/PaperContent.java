package ist.hw2.Entity;

import javax.persistence.Id;

public class PaperContent {
    @Id
    private Integer ID;

    private String content;

    public Integer getID() {
        return ID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
