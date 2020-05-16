package ist.hw2.Controller;

import com.alibaba.fastjson.JSONObject;
import ist.hw2.DTO.Paper;
import ist.hw2.Entity.Question;
import ist.hw2.Entity.TestPaper;
import ist.hw2.Service.QuestionService;
import ist.hw2.Service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
        question.setQuality(10);
        question.setDomain(data.getString("domain"));
        question.setDifficulty(data.getInteger("difficulty"));
        question.setName(data.getString("name"));
        question.setQuestion_content(data.getString("question_content"));
        questionService.save(question);
    }

    @ResponseBody
    @PostMapping(path="/addTestPaper")
    public Paper addTestPaper(@RequestBody JSONObject data) {
        return testPaperService.getOneNewTestPaper(data);
    }

    @ResponseBody
    @GetMapping(path = "/g")
    public JSONObject test() {
        return testPaperService.getRequest("1588777292295");
    }

    @ResponseBody
    @GetMapping(path = "/p")
    public void testP() {
        testPaperService.putRequest("1588505975051","123456", (long) 8);
    }

    @ResponseBody
    @GetMapping(path = "/getOnePaper")
    public Paper getOnePaper(@RequestParam Integer paperID) {
        return testPaperService.getOnePaper(paperID);
    }


    @ResponseBody
    @PostMapping(path="/gradePaper")
    public void checkPaper(@RequestBody JSONObject data){
        testPaperService.gradePaper(data);
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

    // use for test
    @ResponseBody
    @GetMapping(path = "/test")
    public String test(@RequestBody JSONObject data) {
        String ss = data.getString("123");
        List<String > lists = (List<String>) data.get("123");
        System.out.println(lists);
        System.out.println(lists.size());
        System.out.println(lists.get(0));
        System.out.println(lists.get(1));
        return "get";}
}
