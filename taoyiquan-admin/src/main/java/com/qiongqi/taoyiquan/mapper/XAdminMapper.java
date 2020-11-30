package com.qiongqi.taoyiquan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiongqi.taoyiquan.model.dto.XAdminDTO;
import com.qiongqi.taoyiquan.model.entity.XAdminEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * Description: 【  数据库操作Mapper 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:28
 */
@Mapper
public interface XAdminMapper extends BaseMapper<XAdminEntity> {

    // ==================== 查询 ====================


    @Select("select * from X_ADMIN where account = #{account}")
    XAdminDTO getbyAccount(@Param("account") String account);

    @Update("update X_ADMIN set lastLoginTime = #{loginTime} where account = #{account}")
    boolean updateLoginTime(@Param("account") String account,@Param("loginTime") Date loginTime);

    // ==================== 增、改、删 ===================


    // ==================== 其他 ====================

}
