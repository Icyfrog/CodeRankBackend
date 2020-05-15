package ist.hw2.Dao;


import ist.hw2.Entity.Question;
import ist.hw2.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDao {


    @Autowired
    private QuestionRepository questionRepository;

    public Question getOneById(Integer id) {
        System.out.println("Dao: " + id);
        return questionRepository.getByQuestionID(id);
    }

    public Iterable<Question> getQuestionsByDomain(String domain) {
        return questionRepository.findAllByDomain(domain);
    }

    public void save(Question question) {
        questionRepository.saveAndFlush(question);
    }

    public void delete(Integer id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

}
