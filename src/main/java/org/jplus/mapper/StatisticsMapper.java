package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.UserDO;
import org.jplus.translate.LastRecordingDTO;
import org.jplus.pojo.AnswerDO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsMapper {

    List<UserDO> getCountSort(@Param("type") String type);

    List<UserDO> getCorrectRateSort(@Param("type") String type);

    Integer getUserCountSortBySchool(@Param("uid") Integer id, @Param("school")String school, @Param("type") String type);

    Integer getUserCorrectSortBySchool(@Param("uid") Integer id, @Param("school")String school, @Param("type") String type);

    LastRecordingDTO getLastRecordingById(@Param("uid") Integer uid);

    Integer getLastPaperId(@Param("uid") Integer uid);

    List<Integer> getTopicsByPaperId(@Param("pid")  Integer pid);

    AnswerDO getAnswer(@Param("id") Integer id, @Param("tid") Integer tid);
}
