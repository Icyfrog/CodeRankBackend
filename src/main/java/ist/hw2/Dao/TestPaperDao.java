package ist.hw2.Dao;

import ist.hw2.Entity.TestPaper;
import ist.hw2.Repository.TestPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestPaperDao {

    @Autowired
    private TestPaperRepository testPaperRepository;

    public TestPaper getOneById(Integer id) {
        return testPaperRepository.getOne(id);
    }

    public void save(TestPaper testPaper) {
        testPaperRepository.saveAndFlush(testPaper);
    }
}
