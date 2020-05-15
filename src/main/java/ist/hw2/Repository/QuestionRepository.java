package ist.hw2.Repository;

import ist.hw2.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question getByQuestionID(Integer id);

    Iterable<Question> findAllByDomain(String domain);


}
