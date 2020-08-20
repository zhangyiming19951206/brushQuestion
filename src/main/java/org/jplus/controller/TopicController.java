package org.jplus.controller;

import org.jplus.constant.Constants;
import org.jplus.exception.ResultBody;
import org.jplus.pojo.AnswerDO;
import org.jplus.pojo.PaperDO;
import org.jplus.pojo.RankDO;
import org.jplus.service.RankService;
import org.jplus.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Controller
@RequestMapping("/v1/questions")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private RankService rankService;

    // 随机在题库中生成考卷
    @PostMapping("/paper/insert/{id}")
    @ResponseBody
    public ResultBody insertTestPaper(@PathVariable("id") Integer id) {
        // 得到试题的题号
        List<Integer> testPaper = topicService.generatePaper();
        StringBuilder sb = new StringBuilder();
        if (testPaper != null && testPaper.size() > 0) {
            sb.append(testPaper.get(0));
            for (int i = 1; i < testPaper.size(); i++) {
                sb.append(",");
                sb.append(testPaper.get(i));
            }
        }
        PaperDO paper = new PaperDO();
        paper.setUid(id);
        paper.setTopic_numbers(sb.toString());
        paper.setIs_deleted(Constants.NOT_DELETED);
        Timestamp time = new Timestamp(System.currentTimeMillis());
        paper.setGmt_create(time);
        paper.setGmt_modified(time);
        // 将试卷写入试卷库
        topicService.insertTestPaper(paper);
        return ResultBody.success(testPaper);
    }

    // 用户提交整张考卷，自动对比答案
    /**
     * TODO:这部分代码有些混乱，需要重构
     * */
    @PostMapping("/paper/commit/{uid}/{id}")
    @ResponseBody
    @Transactional
    public ResultBody postPaper(@PathVariable("uid") Integer uid, @PathVariable("id") Integer id, String[] user_answer) {
        AnswerDO answerDO = new AnswerDO();
        RankDO rankDO = new RankDO();
        // 根据试卷 id 从 paper 表中查询出试卷包含的题目，然后对比答案
        List<Integer> res = new ArrayList<>();
        String paper = topicService.getPaper(id);
        String[] arr = paper.split(",");
        for (int i = 0; i < arr.length; i++) {
            String type = topicService.getTopicType(Integer.parseInt(arr[i]));
            String answer = topicService.getTopicAnswer(Integer.parseInt(arr[i]));
            Timestamp time = new Timestamp(System.currentTimeMillis());
            RankDO rankInfo = rankService.selectRankByType(uid, type);
            rankDO.setUserid(uid);
            rankDO.setType(type);
            // 用户个人信息可从 session 等处获取，不用去数据库查
            rankDO.setSchool(Constants.DEFAULT_SCHOOL);
            rankDO.setIs_deleted(Constants.NOT_DELETED);
            rankDO.setGmt_create(time);
            rankDO.setGmt_modified(time);
            if (rankInfo == null) {
                rankDO.setCount(1);
            } else {
                rankDO.setCount(rankInfo.getCount() + 1);
            }
            if (user_answer[i].equals(answer)) {
                // 该题回答正确
                res.add(Constants.ANSWER_RIGHT);
                answerDO.setRight_or_wrong(Constants.ANSWER_RIGHT);
                if (rankInfo == null) {
                    rankDO.setCorrect(Constants.FIRST_INSERT_COUNT);
                } else {
                    rankDO.setCorrect(rankInfo.getCorrect() + 1);
                }
            } else {
                // 回答错误
                if (rankInfo == null) {
                    rankDO.setCorrect(0);
                } else {
                    rankDO.setCorrect(rankInfo.getCorrect());
                }
                res.add(Constants.ANSWER_WRONG);
                answerDO.setRight_or_wrong(Constants.ANSWER_WRONG);
            }

            answerDO.setId(uid);
            answerDO.setTid(Integer.parseInt(arr[i]));
            answerDO.setUser_answer(user_answer[i]);
            answerDO.setType(type);
            answerDO.setIs_deleted(Constants.NOT_DELETED);
            answerDO.setGmt_create(time);
            answerDO.setGmt_modified(time);

            postPaper(answerDO, rankDO);
        }
        return ResultBody.success(res);
    }

    // 注意控制事务的粒度
    @Transactional
    public void postPaper(AnswerDO answerDO, RankDO rankDO) {
        topicService.insertAnswer(answerDO);
        rankService.insertRank(rankDO);
    }

    // 用户提交任意多道题的答案
    @PostMapping("/multi")
    @ResponseBody
    public List<Integer> postTopics(Integer[] tids, String[] user_answer) {
        // 根据题目 tid 从 topic 表中查询出题目的答案, 然后比对答案
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < tids.length; i++) {
            String answer = topicService.getTopicAnswer(tids[i]);
            if (user_answer[i].equals(answer)) {
                // 该题回答正确
                res.add(Constants.ANSWER_RIGHT);
            } else {
                // 回答错误
                res.add(Constants.ANSWER_WRONG);
            }
        }
        return res;
    }
}
