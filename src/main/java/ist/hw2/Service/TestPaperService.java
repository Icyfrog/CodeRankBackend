package ist.hw2.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.Dao.QuestionDao;
import ist.hw2.Dao.TestPaperDao;
import ist.hw2.Entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestPaperService {
    @Autowired
    TestPaperDao testPaperDao;

    @Autowired
    QuestionDao questionDao;

    /*
     * Input--demand:
     * {
     *      num:Integer,
     *      domains: a String separate by ','
     *
     * }
     *
     * Output--questionArray: a json array containing questions
     */
    public JSONArray getOneNewTestPaper(JSONObject demand) {
        JSONArray questionArray = new JSONArray();
        int questionNum = demand.getInteger("num");
        String domains = demand.getString("domains");
        String[] domainArray = domains.split(",");
        //Iterable<Question>
        return questionArray;
    }
}
