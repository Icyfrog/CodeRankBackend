package ist.hw2.Repository;

import ist.hw2.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    Question getById(Integer id);

    Iterable<Question> findAllByDomain(String domain);

}
