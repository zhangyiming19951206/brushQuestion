package org.jplus.controller;

import org.jplus.exception.CommonEnum;
import org.jplus.exception.ResultBody;
import org.jplus.pojo.AnswerDO;
import org.jplus.pojo.UserDO;
import org.jplus.service.StatisticsService;
import org.jplus.translate.QueryVO;
import org.jplus.utils.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joker Ye
 * @date 2020/8/13
 */
@Controller
@RequestMapping("/v1/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    // 每种类型题目的刷题量排行榜 TOP 10
    @GetMapping("/count/sort/get")
    @ResponseBody
    public ResultBody getCountSort(@RequestBody QueryVO queryVO) {
        String type = queryVO.getType();
        if (!Validation.validateQuestionType(type)) {
            return ResultBody.error(CommonEnum.INVALID_PARAMETER);
        }
        List<UserDO> res = statisticsService.getCountSort(type);
        return ResultBody.success(res);
    }

    // 每种类型题目正确率排行榜 TOP 10
    @GetMapping("/correct/sort/get")
    @ResponseBody
    public ResultBody getCorrectRateSort(@RequestBody QueryVO queryVO) {
        String type = queryVO.getType();
        if (!Validation.validateQuestionType(type)) {
            return ResultBody.error(CommonEnum.INVALID_PARAMETER);
        }
        List<UserDO> res = statisticsService.getCorrectRateSort(type);
        return ResultBody.success(res);
    }

    // 每种类型题目的刷题量在本校中的排名
    @RequestMapping("/school/count/sort/get/{id}")
    @ResponseBody
    public ResultBody getUserCountSortBySchool(@PathVariable("id") Integer id, @RequestBody QueryVO queryVO) {
        if (!Validation.validateQuestionType(queryVO.getType())) {
            return ResultBody.error(CommonEnum.INVALID_PARAMETER);
        }
        Integer result = statisticsService.getUserCountSortBySchool(id, queryVO.getSchool(), queryVO.getType());
        return ResultBody.success(result);
    }

    // 每种类型题目的正确率在本校中的排名
    @RequestMapping("/school/correct/sort/get/{id}")
    @ResponseBody
    public ResultBody getUserCorrectSortBySchool(@PathVariable("id") Integer id, @RequestBody QueryVO queryVO) {
        if (!Validation.validateQuestionType(queryVO.getType())) {
            return ResultBody.error(CommonEnum.INVALID_PARAMETER);
        }
        Integer result = statisticsService.getUserCorrectSortBySchool(id, queryVO.getSchool(), queryVO.getType());
        return ResultBody.success(result);
    }

    @GetMapping("/last/get/{id}")
    @ResponseBody
    public ResultBody getLastBrushQuestions(@PathVariable("id") Integer id) {
        // 首先通过 id 去 paper 表中获取最后一次的答题试卷
        Integer pid = statisticsService.getLastPaperId(id);
        List<AnswerDO> res = new ArrayList<>();
        // 根据 pid 得到其对应的题目
        List<Integer> tids = statisticsService.getTopicsByPaperId(pid);
        // 根据题目 id、uid 和 type得到用户的答题信息
        for (int i = 0; i < tids.size(); i++) {
            AnswerDO answerDO = statisticsService.getAnswer(id, tids.get(i));
            res.add(answerDO);
        }
       return ResultBody.success(res);
    }
}
