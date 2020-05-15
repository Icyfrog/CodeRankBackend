package ist.hw2.Repository;

import ist.hw2.Entity.QuestionsInPaper;
import ist.hw2.Entity.TestPaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface QuestionInPaperRepository extends JpaRepository<QuestionsInPaper, Integer> {

    List<QuestionsInPaper> findAllByTestPaper(TestPaper testPaper);
}
