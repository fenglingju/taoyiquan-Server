package com.qiongqi.taoyiquan.controller;

import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.common.response.ResultCode;
import com.qiongqi.taoyiquan.common.utils.ConvertUtils;
import com.qiongqi.taoyiquan.model.dto.XAdminDTO;
import com.qiongqi.taoyiquan.model.entity.XAdminEntity;
import com.qiongqi.taoyiquan.model.vo.adminVO;
import com.qiongqi.taoyiquan.service.XAdminService;

import com.qiongqi.taoyiquan.service.XAdminServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

/**
 * Description: 【  后台Controller控制器 】
 *
 * @author : ※狗尾巴草
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-27 12:05:28
 * @version : 1.0.0
 */
@RestController
@RequestMapping("v1/admin/entity")
public class AdminXAdminController {

    @Autowired
    private XAdminService xAdminService;

    @GetMapping
    public String index(){
        return "admin-info";
    }


    @GetMapping("info/{id}")
    public ResponseData<adminVO> info(@PathVariable("id") Long id){
        XAdminEntity entity = xAdminService.getById(id);
        if(entity==null){
            return new ResponseData<>().fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }
        return new ResponseData<adminVO>().success(ConvertUtils.sourceToTarget(entity, adminVO.class));
    }


    // ==================== 查询 ====================

    /**
     * Description: 【 通过登录账户查询单一数据 】
     *
     * @author : ※狗尾巴草
     * @email : "m962464oo@gmail.com"
     * @date : 2020-11-27 12:05:28
     * @param account
     */
    @GetMapping("getByAccount")
    public ResponseData<XAdminDTO> getbyAccount(@RequestParam("account") String account){
        XAdminDTO data = xAdminService.getbyAccount(account);
        System.out.println(data.getAccount());
        return new ResponseData<XAdminDTO>().success(data);
//        throw new RuntimeException("服务器异常");
    }


    // ==================== 增、改、删 ====================


    @GetMapping("updateLoginTime")
    public ResponseData updateLoginTime(@RequestParam("account") String account, @RequestParam("loginTime") Date loginTime){
        xAdminService.updateLoginTime(account,loginTime);
        return new ResponseData().success();
    }

    // ==================== 其他 ====================



}
