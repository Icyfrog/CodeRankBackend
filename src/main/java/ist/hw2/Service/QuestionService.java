package ist.hw2.Service;

import ist.hw2.Dao.QuestionDao;
import ist.hw2.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import java.util.*;

class IdQualityPair {
    public Integer id;
    public Float quality;
    public IdQualityPair(Integer id, Float quality) {
        this.id = id;
        this.quality = quality;
    }
}

class SortByQuality implements Comparator<Question> {
    @Override
    public int compare(Question q1, Question q2) {
        if (q1.getQuality() > q2.getQuality()) {
            return -1;
        }
        return 1;
    }
}
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


    public List<Question> getAllRankQuestionsId(String domain) {
        Iterable<Question> questionsByDomain = getAllByDomainTest(domain);
        List<IdQualityPair> idQualityList = new ArrayList<>();
        //Iterator<Question> questionIterator = questionsByDomain.iterator();
        List<Question> questionList = Lists.newArrayList(questionsByDomain);
                //IteratorUtils.toList(questionIterator)
        for(Question question:questionsByDomain) {
            IdQualityPair tmpIdQualityPair =
                    new IdQualityPair(question.getId(),question.getQuality());
            idQualityList.add(tmpIdQualityPair);
            //idQualityPairs.add(tmpIdQualityPair);
        }
        Collections.sort(questionList, new SortByQuality());
        return questionList;
    }
/*
    public Question getOneRankQuestion (String domain, Integer ranking) {
        Iterable<Question> questionsByDomain = getAllByDomainTest(domain);
        questionsByDomain.
    }


 */
}
