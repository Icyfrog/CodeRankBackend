##### Mind the database setting in file *application.properties*

Get all questions:
- localhost:8080/demo/getQuestions
- @GetMapping
- return List of Questions (JSONArray)
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

Get all papers:
- localhost:8080/demo/getTestPapers
- @GetMapping
- return List of TestPapers (JSONArray)
-       output:
        [
          {
            "create_time": "2020-05-14 23:56:03",
            "tittle": null,
            "answer_content_id": 28,
            "time": null,
            "deadline": null,
            "status": null,
            "testPaperID": 28
          },
          {
            "create_time": null,
            "tittle": null,
            "answer_content_id": 29,
            "time": null,
            "deadline": null,
            "status": null,
            "testPaperID": 29
          }]
---

Add one test paper
- localhost:8080/demo/addTestPaper
- @PostMapping
-     Request body:
        {
            "tlttle":"test",
            "deadline":"deadline test",
            "time":12,
            "domains": ["vm","sql"],
            "description": "VM the paper description"
        }

-     Output--JSONObject:
        {
          "paperID": 50,
          "paperInfo": {
            "create_time": "2020-05-15 17:36:06",
            "answer_content_id": 50,
            "testPaperID": 50,
            "time": 12,
            "deadline": "deadline test",
            "status": 0
          },
          "questionList": [
            {
              "difficulty": 5,
              "domain": "vm",
              "name": "中文可以吗",
              "approximate_time": 10,
              "question_content": "for test",
              "id": 27,
              "quality": 10
            },
            {
              "difficulty": 1,
              "domain": "sql",
              "name": "",
              "approximate_time": 1,
              "id": 1,
              "quality": 123
            }
          ],
          "questionInfo": null
        }
---
Grade on paper
- localhost:8080/demo/gradePaper
- @PostMapping
-       input:
            {
                "paperID": 50,
                "questions":[{"questionID":27, "score":100, "comment":"test for grade", "grade":10 },
                           {"questionID":1, "score":100, "comment":"test for grade", "grade":10 }]
            }
---
Answer one test paper(Not implemented yet)
- localhost:8080/demo/answerPaper
- @PostMapping
-     Request body:
        {
          "id": 177,      // the id for paper
          "content": "177 content test"       // content of the interviewee's answer sheet
        }
- no return 
-----
Get one test paper's answer content(Not implemented yet)
- localhost:8080/demo/getAnswerSheet?asID={Integer}   
- asID: ID for the test paper
- @GetMapping
- return: String for content.