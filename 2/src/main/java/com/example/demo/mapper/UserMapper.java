package com.example.demo.mapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 处理用户数据的持久层接口
 */
public interface UserMapper {
  
  /**
   * 插入用户数据
   * @param user 用户数据
   * @return 受影响的行数
   */
  Integer insert(User user);
  boolean addUser(User user);
  Integer updatePassword( String phone,  String password);
  User findByUserPassword(String password);
  
  /**
   * 根据用户名查询用户数据
   * @param username 用户名
   * @return 匹配的用户数据，如果没有匹配的数据，则返回null
   */
  User findByUsername(String username);
  User findByUserphone(String phone);

}
