package ist.hw2.Repository;

import ist.hw2.Entity.PaperContent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaperContentRepository extends MongoRepository<PaperContent, Integer> {
    public PaperContent findByID(Integer id);
}
