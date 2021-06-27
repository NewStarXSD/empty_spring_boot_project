package com.star.tdpersonal.common.dal.mysql.test.mapper.single;

import com.star.tdpersonal.common.dal.mysql.test.entity.TestDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: tdpersonal
 * @Description: 测试Mapper
 * @author: xinsida
 * @create: 2021-06-15 18:12
 **/
@Mapper
public interface TestMapper {

    /**
     * 测试新增
     *
     * @param testDO
     * @return
     */
    int insert(TestDO testDO);

}
