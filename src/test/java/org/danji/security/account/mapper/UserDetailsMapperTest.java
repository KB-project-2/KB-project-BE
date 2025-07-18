package org.danji.security.account.mapper;

import lombok.extern.log4j.Log4j2;
import org.danji.auth.account.domain.AuthVO;
import org.danji.auth.account.domain.MemberVO;
import org.danji.auth.account.mapper.UserDetailsMapper;
import org.danji.global.config.RootConfig;
import org.danji.global.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class UserDetailsMapperTest {

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Test
    void get() {
        MemberVO memberVO = userDetailsMapper.get("admin");
        log.info(memberVO);
        //List<AuthVO) 궁금..??
        List<AuthVO> authList = memberVO.getAuthList();
        log.info(authList.size()); //3개
        System.out.println("==============================");
        for (AuthVO authVO : authList) {
            log.info(authVO);
        }
    }
}