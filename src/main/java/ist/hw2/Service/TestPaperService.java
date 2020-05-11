package ist.hw2.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.Dao.QuestionDao;
import ist.hw2.Dao.TestPaperDao;
import ist.hw2.Entity.PaperContent;
import ist.hw2.Entity.Question;
import ist.hw2.Entity.TestPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        /*
        获取时间戳
        */
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String time = sdf.format(date.getTime());
        testPaper.setCreate_time(time);
        System.out.println(time);

        testPaperDao.save(testPaper);

        Integer testPaperId = testPaper.getId();
        testPaper.setAnswer_content_id(testPaperId);
        testPaperDao.save(testPaper);


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

    public void answerPaper(JSONObject data) {
        Integer id = data.getInteger("id");
        PaperContent paperContent = new PaperContent();
        paperContent.setID(id);
        paperContent.setContent(data.getString("content"));
        testPaperDao.savePaperContent(paperContent);
    }

    public String get_paper_content(Integer id) {
        PaperContent paperContent = testPaperDao.getPaperContentById(id);
        return paperContent.getContent();
    }
}
