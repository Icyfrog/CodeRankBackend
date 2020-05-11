##### Mind the database setting in file *application.properties*

Get all questions:
- localhost:8080/demo/getQuestions
- @GetMapping
- return List<Question>(JSONArray)
---
Add one question:
- localhost:8080/demo/addQuestion
- @PostMapping
-     Request body:
      {
        "domain": "web service",
        "question_content": "for test",
        "approximate_time":10
      }
- no return
---

Get all questions:
- localhost:8080/demo/getTestPapers
- @GetMapping
- return List<Testpaper>(JSONArray)
---
Add one test paper
- localhost:8080/demo/addTestPaper
- @PostMapping
-     Request body:
      {
        "name": "test name",
        "difficulty": 5,
        "num": the number of questions,
        "domains": a String separate by ',' || E.G. "sql,web,c++",
        "description": the paper description 
      }
-     Output--JSONObject:
      {
         QuestionList: a JSONArray containing questions,
         paperId: Integer the paper id
      }
---
Answer one test paper
- localhost:8080/demo/answerPaper
- @PostMapping
-     Request body:
        {
          "id": 177,      // the id for paper
          "content": "177 content test"       // content of the interviewee's answer sheet
        }
- no return 
-----
Get one test paper's answer content
- localhost:8080/demo/getAnswerSheet?asID={Integer}   
- asID: ID for the test paper
- @GetMapping
- return: String for content.