package ist.hw2.Controller;

import ist.hw2.Entity.Question;
import ist.hw2.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    @Autowired
    QuestionService questionService;

    @RequestMapping(value = "/que", method = RequestMethod.GET)
    public @ResponseBody
    Question demoGetOne() {

        System.out.println("get demo");
        return questionService.getOneById(1);
    }

    /*
    Request body:
    {
      "quality": 15.0,
      "domain": "web service"
    }
    */
    @ResponseBody
    @PostMapping(path="/add")
    public void addNewUser(@RequestBody Question n){
        questionService.save(n);
    }

}
