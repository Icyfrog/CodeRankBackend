package ist.hw2.Service;

import ist.hw2.Dao.QuestionDao;
import ist.hw2.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;

    public Iterable<Question> getAllByDomainTest(String domain) {
        return questionDao.getQuestionsByDomain(domain);
    }

    public Question getOneById(Integer id) {
        System.out.println("Service" + id);
        return questionDao.getOneById(id);
    }

    public void save(Question question) {
        questionDao.save(question);
    }
}
