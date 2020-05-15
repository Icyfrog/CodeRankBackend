package ist.hw2.Dao;

import ist.hw2.Entity.QuestionsInPaper;
import ist.hw2.Entity.TestPaper;
import ist.hw2.Repository.QuestionInPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionInPaperDao {
    @Autowired
    QuestionInPaperRepository questionInPaperRepository;
    public List<QuestionsInPaper> getAllByPaper(TestPaper testPaper) {
        return this.questionInPaperRepository.findAllByTestPaper(testPaper);
    }
}
