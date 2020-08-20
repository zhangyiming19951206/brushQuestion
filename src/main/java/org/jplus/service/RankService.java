package org.jplus.service;

import org.jplus.pojo.RankDO;

public interface RankService {
    void insertRank(RankDO rankDO);

    RankDO selectRankByType(Integer uid, String type);
}
