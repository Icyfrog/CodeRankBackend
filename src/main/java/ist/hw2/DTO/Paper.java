package ist.hw2.DTO;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ist.hw2.Entity.Question;

import java.util.List;

/*
paperId: this.$route.params.id,
                paperInfo:
                    {
                        "companyName": "微软亚洲研究院",
                        "paperId": 123,
                        "finishTime": 45,
                        "questionAmt": 5,
                        "type": "Java & Algorithm",
                        "deadline": "2020-5-10 8:00 p.m."
                    },
                time: 45 * 60 * 1000,
                questionList: [
                    {
                        questionId: 123,
                        questionName: "链表加法",
                        questionContent: "You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list." +
                            "You may assume the two numbers do not contain any leading zero, except the number 0 itself.\n",
                        questionSample:
                            "Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) <br>" +
                            "Output: 7 -> 0 -> 8 <br>" +
                            "Explanation: 342 + 465 = 807.",
                        answer: 'test',
                        comments: 'good',
                        score: 4,
                        reviewed: true
                    },
		…]

 */
public class Paper {
    private Integer paperID;
    private JSONObject paperInfo;
    private JSONArray questionList;
    private JSONArray questionInfoList;

    public JSONArray getQuestionInfo() {
        return questionInfoList;
    }

    public void setQuestionInfo(JSONArray questionInfo) {
        this.questionInfoList = questionInfo;
    }



    public JSONObject getPaperInfo() {
        return paperInfo;
    }

    public void setPaperInfo(JSONObject paperInfo) {
        this.paperInfo = paperInfo;
    }

    public JSONArray getQuestionList() {
        return questionList;
    }

    public Integer getPaperID() {
        return paperID;
    }

    public void setPaperID(Integer paperID) {
        this.paperID = paperID;
    }

    public void setQuestionList(JSONArray questionList) {
        this.questionList = questionList;
    }


}
