package ist.hw2.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.DTO.Paper;
import ist.hw2.Dao.QuestionDao;
import ist.hw2.Dao.QuestionInPaperDao;
import ist.hw2.Dao.TestPaperDao;
import ist.hw2.Entity.PaperContent;
import ist.hw2.Entity.Question;
import ist.hw2.Entity.QuestionsInPaper;
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
    QuestionInPaperDao questionInPaperDao;

    @Autowired
    QuestionService questionService;

    /*
     * Input--demand:
     * {
            "tittle": "微软亚洲研究院",
            "time": 45,
            "amount": 5,
            "type": "Java & Algorithm",
            "deadline": "2020-5-10 8:00 p.m."
     *      num:the number of questions,
     *      domains: ["vm", "sql"]
     *      description: the paper description
     *
     * }
     *
     * Output--JSONObject:
     *      paperId: Integer the paper id
     *      QuestionList: a JSONArray containing questions
     */
    public Paper getOneNewTestPaper(JSONObject demand) {

        Paper paper = new Paper();
        TestPaper testPaper = new TestPaper();
        testPaper.setTittle(demand.getString("tittle"));
        testPaper.setDeadline(demand.getString("deadline"));
        testPaper.setStatus(0);
        testPaper.setTime(demand.getInteger("time"));


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

        Integer paperID = testPaper.getTestPaperID();
        testPaper.setAnswer_content_id(paperID);
        testPaperDao.save(testPaper);

        // get question list
        List<String > domains = (List<String>) demand.get("domains");
        List<Question> qList = new ArrayList<>();


        for(String domain:domains) {
            QuestionsInPaper questionsInPaper = new QuestionsInPaper();
            questionsInPaper.setTestPaper(testPaper);
            System.out.println(domain);
            Question oneHighQuestion = questionService.getOneHighQualityQuestion(domain);
            qList.add(oneHighQuestion);
            questionsInPaper.setQuestion(oneHighQuestion);
            questionInPaperDao.save(questionsInPaper);
        }

        JSONArray questionList = JSONArray.parseArray(JSON.toJSONString(qList));
        paper.setPaperID(paperID);
        String jsonStr = JSONObject.toJSONString(testPaper);
        paper.setPaperInfo(JSONObject.parseObject(jsonStr));
        paper.setQuestionList(questionList);

        return paper;

    }

    public Paper getOnePaper(Integer paperID) {

        TestPaper testPaper = testPaperDao.getOneById(paperID);
        String jsonStr = JSONObject.toJSONString(testPaper);


        List<QuestionsInPaper> list = questionInPaperDao.getAllByPaper(testPaper);

        List<Question> qList = new ArrayList<>();
        List<QuestionsInPaper> qInfoList = new ArrayList<>();

        for(QuestionsInPaper q:list) {
            Question question = q.question;
            qList.add(question);
            qInfoList.add(q);
        }
        //JSONArray questionList = JSONArray.parseArray(JSON.toJSONString(qList));
        JSONArray questionInfoList = JSONArray.parseArray(JSON.toJSONString(qInfoList));

        Paper paper = new Paper();
        paper.setPaperID(paperID);
        paper.setPaperInfo(JSONObject.parseObject(jsonStr));
        paper.setQuestionList(questionInfoList);
        return paper;

    }

    /*
    {
        paperID: int,
        questions:[{questionID:int, score:int, comment:String, grade:int },
                   {questionID:int, score:int, comment:String, grade:int },
                   {questionID:int, score:int, comment:String, grade:int }]
    }
     */
    public void gradePaper(JSONObject data) {
        Integer paperID = data.getInteger("paperID");
        TestPaper testPaper = testPaperDao.getOneById(paperID);
        List<QuestionsInPaper> questionsInPapers = questionInPaperDao.getAllByPaper(testPaper);
        JSONArray questions = data.getJSONArray("questions");
        for(int i=0; i<questions.size(); i++) {
            JSONObject question = questions.getJSONObject(i);
            Question q = questionDao.getOneById(question.getInteger("questionID"));
            QuestionsInPaper questionsInPaper = questionInPaperDao.getOneByQuestionAndTestPaper(q,testPaper);
            questionsInPaper.setComment(question.getString("comment"));
            questionsInPaper.setScore(question.getInteger("score"));
            Integer q_quality = q.getQuality();
            q.setQuality(q_quality + question.getInteger("grade"));
            questionDao.save(q);
        }

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

    public List<TestPaper> getAll() {
        return testPaperDao.getAll();
    }
}
