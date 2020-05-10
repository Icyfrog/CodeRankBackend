package ist.hw2.Repository;

import ist.hw2.Entity.TestPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestPaperRepository extends JpaRepository<TestPaper, Integer> {
}
