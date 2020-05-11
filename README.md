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

Add one test paper
- localhost:8080/demo/addTestPaper
- @PostMapping
-     Request body:
      {
        num:the number of questions,
        domains: a String separate by ',' || E.G. "sql,web,c++",
        description: the paper description 
      }
-     Output--JSONObject:
      {
         QuestionList: a JSONArray containing questions,
         paperId: Integer the paper id
      }
