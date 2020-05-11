package ist.hw2.Dao;

import ist.hw2.Entity.PaperContent;
import ist.hw2.Entity.TestPaper;
import ist.hw2.Repository.PaperContentRepository;
import ist.hw2.Repository.TestPaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestPaperDao {

    @Autowired
    private TestPaperRepository testPaperRepository;

    @Autowired
    private PaperContentRepository paperContentRepository;

    public TestPaper getOneById(Integer id) {
        return testPaperRepository.getOne(id);
    }

    public List<TestPaper> getAll() {
        return testPaperRepository.findAll();
    }

    public void save(TestPaper testPaper) {
        testPaperRepository.saveAndFlush(testPaper);
    }

    public PaperContent getPaperContentById(Integer id) {
        return paperContentRepository.findByID(id);
    }

    public void savePaperContent(PaperContent paperContent) {
        paperContentRepository.save(paperContent);

    }
}
