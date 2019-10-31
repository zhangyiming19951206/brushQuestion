package org.jplus.mapper;

import org.jplus.pojo.basisInfo.*;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
public interface jbxxMapper {
    Jbxx getJbxxInfo();

    List<Yxbm> getYxbmInfo();

    List<Zwbm> getZwbmInfo();

    List<Zcbm> getZcbmInfo();

    List<Gwlxbm> getGwlxbmInfo();
}
