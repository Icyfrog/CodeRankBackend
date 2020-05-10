package ist.hw2.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.Dao.QuestionDao;
import ist.hw2.Dao.TestPaperDao;
import ist.hw2.Entity.Question;
import ist.hw2.Entity.TestPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestPaperService {
    @Autowired
    TestPaperDao testPaperDao;

    @Autowired
    QuestionDao questionDao;

    @Autowired
    QuestionService questionService;

    /*
     * Input--demand:
     * {
     *      num:the number of questions,
     *      domains: a String separate by ',' || E.G. "sql,web,c++",
     *      description: the paper description
     *
     * }
     *
     * Output--JSONObject:
     *      paperId: Integer the paper id
     *      QuestionList: a JSONArray containing questions
     */
    public JSONObject getOneNewTestPaper(JSONObject demand) {

        TestPaper testPaper = new TestPaper();
        testPaper.setDescription(demand.getString("description"));
        testPaperDao.save(testPaper);

        Integer testPaperId = testPaper.getId();

        String domains = demand.getString("domains");
        String[] domainArray = domains.split(",");
        List<Question> qList = new ArrayList<>();
        for(String domain:domainArray) {
            System.out.println(domain);
            Question oneHighQuestion = questionService.getOneHighQualityQuestion(domain);
            qList.add(oneHighQuestion);
        }

        // output: the QuestionList
        JSONArray questionList = JSONArray.parseArray(JSON.toJSONString(qList));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("paperId", testPaperId);
        jsonObject.put("QuestionList", questionList);
        return jsonObject;

    }
/*
    public JSONArray getOneTestPaper(Integer testPaperId) {
        JSONArray questionArray = new JSONArray();
        List<Question> questionList =
    }
*/
}
