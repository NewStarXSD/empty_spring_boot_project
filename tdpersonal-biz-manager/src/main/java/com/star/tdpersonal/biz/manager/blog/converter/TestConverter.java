package com.star.tdpersonal.biz.manager.blog.converter;

import com.star.tdpersonal.biz.manager.blog.dto.TestDTO;
import com.star.tdpersonal.common.dal.mysql.test.entity.TestDO;

/**
 * @program: tdpersonal
 * @description: 测试传输类与实体类转换器
 * @author: xinsida
 * @create: 2021-06-15 22:16
 **/
public class TestConverter {

    public static TestDTO convertDO2DTO(TestDO testDO) {
        if (null == testDO) {
            return null;
        }
        TestDTO testDTO = new TestDTO();
        testDTO.setGmtCreate(testDO.getGmtCreate());
        testDTO.setTitle(testDO.getTitle());
        testDTO.setContent(testDO.getContent());
        testDTO.setGmtModified(testDO.getGmtModified());
        testDTO.setId(testDO.getId());
        return testDTO;
    }

    public static TestDO convertDTO2DO(TestDTO testDTO) {
        if (null == testDTO) {
            return null;
        }
        TestDO testDO = new TestDO();
        testDO.setContent(testDTO.getContent());
        testDO.setTitle(testDTO.getTitle());
        testDO.setGmtCreate(testDTO.getGmtCreate());
        testDO.setGmtModified(testDTO.getGmtModified());
        testDO.setId(testDTO.getId());
        return testDO;
    }

}
