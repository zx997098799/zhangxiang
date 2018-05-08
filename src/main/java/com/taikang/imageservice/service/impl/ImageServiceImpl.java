package com.taikang.imageservice.service.impl;

import com.taikang.imageservice.mapper.ImageMapper;
import com.taikang.imageservice.pojo.ClinicInfoBo;
import com.taikang.imageservice.pojo.HuoquImageBo;
import com.taikang.imageservice.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public void insertImageSer(HuoquImageBo huoquImageBo) {
        imageMapper.insertImageSer(huoquImageBo);
    }

    @Override
    public List<ClinicInfoBo> selectClinicInfo() {
        List<ClinicInfoBo> list = imageMapper.selectClinicInfo();
        return list!=null && list.size()>0?list:null;
    }
}
