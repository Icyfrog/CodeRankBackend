package ist.hw2.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.Dao.QuestionDao;
import ist.hw2.Dao.TestPaperDao;
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
     *
     * }
     *
     */
    public JSONArray getOneNewTestPaper(JSONObject demand) {
        JSONArray questionArray = new JSONArray();
        int questionNum = demand.getInteger("num");


        return questionArray;
    }
}
