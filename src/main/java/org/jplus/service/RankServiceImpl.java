package org.jplus.service;

import org.jplus.mapper.RankMapper;
import org.jplus.pojo.RankDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joker Ye
 * @date 2020/8/18
 */
@Service
public class RankServiceImpl implements RankService {

    @Autowired
    private RankMapper rankMapper;

    @Override
    public void insertRank(RankDO rankDO) {
        rankMapper.insertRank(rankDO);
    }

    @Override
    public RankDO selectRankByType(Integer uid, String type) {
        return rankMapper.selectRankByType(uid, type);
    }
}
