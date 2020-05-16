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
Get on paper
- localhost:8080/demo/getOnePaper?paperID={int}
- @GetMapping
- input: int id for paper
-       output:
        {
          "paperID": 68,
          "paperInfo": {
            "finishTime": 12,
            "companyName": "test",
            "questionAmt": 2,
            "type": [
              "sql",
              "vm"
            ],
            "paperId": 68
          },
          "questionList": [
            {
              "score": 10,
              "answer_content": "1 content test",
              "question": {
                "difficulty": 1,
                "domain": "sql",
                "name": "",
                "approximate_time": 1,
                "id": 1,
                "quality": 879
              },
              "testPaper": {
                "create_time": "2020-05-15 22:54:09",
                "messageUser": "1588777292295",
                "answer_content_id": 68,
                "testPaperID": 68,
                "messageCompany": "1588505975051",
                "time": 12,
                "deadline": "deadline test",
                "tittle": "test",
                "status": 2
              },
              "comment": "test for grade101",
              "relation_id": 69
            },
            {
              "score": 10,
              "answer_content": "27 content test",
              "question": {
                "difficulty": 5,
                "domain": "vm",
                "name": "中文可以吗",
                "approximate_time": 10,
                "question_content": "for test",
                "id": 27,
                "quality": 766
              },
              "testPaper": {
                "create_time": "2020-05-15 22:54:09",
                "messageUser": "1588777292295",
                "answer_content_id": 68,
                "testPaperID": 68,
                "messageCompany": "1588505975051",
                "time": 12,
                "deadline": "deadline test",
                "tittle": "test",
                "status": 2
              },
              "comment": "test for grade101",
              "relation_id": 70
            }
          ],
          "questionInfo": null
        }
---
Grade one paper
- localhost:8080/demo/gradePaper
- @PostMapping
-       input:
            {
                "paperID": 50,
                "questions":[{"questionID":27, "score":100, "comment":"test for grade", "grade":10 },
                           {"questionID":1, "score":100, "comment":"test for grade", "grade":10 }]
            }
---
Answer one test paper
- localhost:8080/demo/answerPaper
- @PostMapping
-     Request body:
            {
                paperID: int,
                userMessageID:String,
                questions:[{questionID:int, content:String},
                           {questionID:int, content:String},
                           {questionID:int, content:String}]
            }
- no return 
-----
Get one test paper's answer content
- just use Get one paper{paperID}
