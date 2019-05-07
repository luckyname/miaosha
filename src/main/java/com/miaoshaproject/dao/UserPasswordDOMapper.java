package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserPasswordDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserPasswordDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sat Apr 27 17:56:23 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sat Apr 27 17:56:23 CST 2019
     */
    int insert(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sat Apr 27 17:56:23 CST 2019
     */
    int insertSelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sat Apr 27 17:56:23 CST 2019
     */
    UserPasswordDO selectByPrimaryKey(Integer id);

    /**
     * 通过用户id 获取用户密码
     * @param userid
     * @return
     */
    UserPasswordDO selectByUserId(Integer userid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sat Apr 27 17:56:23 CST 2019
     */
    int updateByPrimaryKeySelective(UserPasswordDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Sat Apr 27 17:56:23 CST 2019
     */
    int updateByPrimaryKey(UserPasswordDO record);
}