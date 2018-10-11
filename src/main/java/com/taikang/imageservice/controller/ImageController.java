package com.taikang.imageservice.controller;

import com.taikang.imageservice.common.utils.ResponseMessage;
import com.taikang.imageservice.pojo.ClinicInfoBo;
import com.taikang.imageservice.pojo.HuoquImageBo;
import com.taikang.imageservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.codec.binary.Hex;


/**
 * created by zhangxiang
 * time 2018-5-8
 * @param huoquInagebo
 */
@RestController
@RequestMapping("/cooperation/server/problem")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/get_emergency_graph_info",method = RequestMethod.POST)
    public ResponseMessage getInfo(@RequestBody HuoquImageBo huoquImageBo) throws NoSuchAlgorithmException {
        //1.保存获取到的图文信息
        huoquImageBo.setContent(huoquImageBo.getContent());
        System.out.println(huoquImageBo.toString());
        // 合作方 partner_key， 注意不是 partner
        String partner_key = "fCWkTRL3zGBxSicD";
        // UNIX TIMESTAMP 最小单位为秒
        String atime = huoquImageBo.getAtime()+"";
        // 第三方用户唯一标识，可以为字母与数字组合的字符串。
        String user_id = huoquImageBo.getUserId();

        //1.1获取sign
        String info = partner_key + atime + user_id;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] srcBytes = info.getBytes();
        md5.update(srcBytes);
        byte[] resultBytes = md5.digest();
        String resultString = new String(new Hex().encode(resultBytes));
         String sign= resultString.substring(8, 24);

        huoquImageBo.setSign(sign);
        imageService.insertImageSer(huoquImageBo);
        //TODO 2.根据content智能过滤获取科室信息
        System.out.println("3其改动，无需提交到master");
        System.out.println("2期改动，需合并");
        List<ClinicInfoBo> clinicInfoBoList=imageService.selectClinicInfo();
        return ResponseMessage.ok(clinicInfoBoList);
    }
    //还有另外一个方法
    //今天还没有写
}
