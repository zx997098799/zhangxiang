package com.taikang.imageservice.mapper;

import com.taikang.imageservice.pojo.ClinicInfoBo;
import com.taikang.imageservice.pojo.HuoquImageBo;

import java.util.List;

public interface ImageMapper {
    void insertImageSer(HuoquImageBo huoquImageBo);

    List<ClinicInfoBo> selectClinicInfo();
}
