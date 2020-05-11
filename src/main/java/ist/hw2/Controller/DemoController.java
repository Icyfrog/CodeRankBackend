package ist.hw2.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.Entity.Question;
import ist.hw2.Entity.TestPaper;
import ist.hw2.Service.QuestionService;
import ist.hw2.Service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    @Autowired
    QuestionService questionService;

    @Autowired
    TestPaperService testPaperService;

    @ResponseBody
    @GetMapping(path="/getQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAll();
    }

    @ResponseBody
    @GetMapping(path="/getTestPapers")
    public List<TestPaper> getAllPapers() {
        return testPaperService.getAll();
    }

    /*
     * use for test, no use for final version
     */
    @ResponseBody
    @GetMapping(path="/getList")
    public List<Question> getAllRankQuestionsId(@RequestParam String domain) {
        return questionService.getAllRankQuestionsId(domain);
    }

    /*
    Request body:
    {
      "domain": "web service",
      "question_content": "for test",
      "approximate_time":10
    }
    */
    @ResponseBody
    @PostMapping(path="/addQuestion")
    public void addNewUser(@RequestBody JSONObject data){
        Question question = new Question();
        question.setApproximate_time(data.getInteger("approximate_time"));
        question.setQuality((float) 10);
        question.setDomain(data.getString("domain"));
        question.setDifficulty(data.getInteger("difficulty"));
        question.setName(data.getString("name"));
        question.setQuestion_content(data.getString("question_content"));
        questionService.save(question);
    }

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
    @ResponseBody
    @PostMapping(path="/addTestPaper")
    public JSONObject addTestPaper(@RequestBody JSONObject data) {
        return testPaperService.getOneNewTestPaper(data);
    }


    /*
    Request body:
    {
	"id": 177,      // the id for paper
	"content": "177 content test"       // content of the interviewee's answer sheet
    }
    */
    @ResponseBody
    @PostMapping(path="/answerPaper")
    public void answerPaper(@RequestBody JSONObject data) {
        testPaperService.answerPaper(data);
    }

    @ResponseBody
    @GetMapping(path = "/getAnswerSheet")
    public String getAnswerSheet(@RequestParam Integer asID) {
        return testPaperService.get_paper_content(asID);
    }
}
