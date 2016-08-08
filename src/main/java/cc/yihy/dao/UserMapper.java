package cc.yihy.dao;

import cc.yihy.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    final static  String USERNAME="userName";
    final static  String TYPE="type";

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    User selectByUsernameAndType(Map<String,Object> map );
}