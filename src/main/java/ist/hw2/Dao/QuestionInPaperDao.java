package ist.hw2.Dao;

import ist.hw2.Entity.Question;
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

    public void save(QuestionsInPaper e) {
        questionInPaperRepository.saveAndFlush(e);
    }

    public QuestionsInPaper getOneById(Integer id) {
        return questionInPaperRepository.getOne(id);
    }

    public void deleteOne (QuestionsInPaper q) {
        questionInPaperRepository.delete(q);
    }

    public QuestionsInPaper getOneByQuestionAndTestPaper(Question q, TestPaper t) {
        return questionInPaperRepository.findByQuestionAndTestPaper(q,t);
    }
}
