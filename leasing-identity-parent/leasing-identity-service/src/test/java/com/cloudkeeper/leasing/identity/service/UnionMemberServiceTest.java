package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.UnionMember;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 类属性配置 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UnionMemberServiceTest {

    /** 类属性配置 service */
    @Autowired
    private UnionMemberService unionMemberService;

    @Test
    public void saveTest() {
        UnionMember unionMember = new UnionMember();
        unionMember = unionMemberService.save(unionMember);
        assertNotNull(unionMember.getId());
    }

}