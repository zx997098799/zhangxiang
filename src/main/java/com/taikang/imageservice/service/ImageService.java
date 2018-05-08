package com.taikang.imageservice.service;

import com.taikang.imageservice.pojo.ClinicInfoBo;
import com.taikang.imageservice.pojo.HuoquImageBo;

import java.util.List;

public interface ImageService {
    void insertImageSer(HuoquImageBo huoquImageBo);

    List<ClinicInfoBo> selectClinicInfo();
}
