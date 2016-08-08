package cc.yihy.service;

import cc.yihy.dao.UserMapper;
import cc.yihy.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by z9475 on 2016/8/7.
 */
@Service("UserService")
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    @Resource
    private UserMapper userMapper;

    public User UserLogin(String userName) {
        User user = selectByUsernameAndType(userName, 0);
        System.out.println(user);
        log.debug(user.getUsername()+"---"+user.getPassword());
        return user;
    }

    public User AdminLogin(String userName) {
        User user = selectByUsernameAndType(userName, 1);
       System.out.println(user);
        log.debug(user.getUsername()+"---"+user.getPassword());

        return user;
    }

    private User selectByUsernameAndType(String username, Integer type) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(UserMapper.USERNAME,username);
        map.put(UserMapper.TYPE,type);
        return userMapper.selectByUsernameAndType(map);
    }
}
