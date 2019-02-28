package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.PartyMember;
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
public class PartyMemberServiceTest {

    /** 类属性配置 service */
    @Autowired
    private PartyMemberService partyMemberService;

    @Test
    public void saveTest() {
        PartyMember partyMember = new PartyMember();
        partyMember = partyMemberService.save(partyMember);
        assertNotNull(partyMember.getId());
    }

}