package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.RankDO;
import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper {

    void insertRank(RankDO rankDO);

    RankDO selectRankByType(@Param("uid") Integer uid, @Param("type") String type);
}
