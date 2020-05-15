package ist.hw2.Entity;

import javax.persistence.*;

@Entity
public class QuestionsInPaper {
    @Id
    @GeneratedValue
    public Long relation_id;

    @ManyToOne
    @JoinColumn(name = "TestPaperID",foreignKey = @ForeignKey(name = "TestPaperID",value = ConstraintMode.CONSTRAINT))
    public TestPaper testPaper;

    @ManyToOne
    @JoinColumn(name = "questionID",foreignKey = @ForeignKey(name = "questionID",value = ConstraintMode.CONSTRAINT))
    public Question question;
}


