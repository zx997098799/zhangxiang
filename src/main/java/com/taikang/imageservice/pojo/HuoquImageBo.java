package com.taikang.imageservice.pojo;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HuoquImageBo implements Bo {

    private String userId;
    private String parter;
    private  String content;
    private String sign;
    private Long atime;

//    //获取sign
//    private  String Sign;

    //文本内容
    private String text;
    //图片内容
    private String ptext;
    private String purl;
    //音频内容
    private  String rtext;
    private String rurl;
    //患者信息
    private String age;
    private String sex;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParter() {
        return parter;
    }

    public void setParter(String parter) {
        this.parter = parter;
    }

    public String getContent() {
        ArrayList content_list = new ArrayList();
        // 添加文本内容
        if (getText()!=null && !"".equals(getText())){
            Map c_text = new HashMap();
            c_text.put("type", "text");
            c_text.put("text", getText());
            content_list.add(c_text);
        }

        // 添加图片内容
        if ((getPtext()!=null &&!"".equals(getPtext()) )||(getPurl()!=null && !"".equals(getPurl()))){
            Map c_image = new HashMap();
            c_image.put("type", "image");
            c_image.put("file", getPtext()+","+getPurl());
            content_list.add(c_image);
        }

        // 添加音频内容
        if ((getRtext()!=null &&!"".equals(getRtext()) )||(getRurl()!=null && !"".equals(getRurl()))){
            Map c_audio = new HashMap();
            c_audio.put("type", "audio");
            c_audio.put("file", rtext+","+rurl);
            content_list.add(c_audio);
        }

        // 添加患者信息
        if ((getAge()!=null &&!"".equals(getAge()) )||(getSex()!=null && !"".equals(getSex()))) {
            Map c_patient_meta = new HashMap();
            c_patient_meta.put("type", "patient_meta");
            c_patient_meta.put("age", getAge());
            c_patient_meta.put("sex", getSex());
            content_list.add(c_patient_meta);
        }

        // 输出结果
        JSONArray content_json = JSONArray.fromObject(content_list);
        String content = content_json.toString();
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getAtime() {
        return atime;
    }

    public void setAtime(Long atime) {
        this.atime = atime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPtext() {
        return ptext;
    }

    public void setPtext(String ptext) {
        this.ptext = ptext;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getRtext() {
        return rtext;
    }

    public void setRtext(String rtext) {
        this.rtext = rtext;
    }

    public String getRurl() {
        return rurl;
    }

    public void setRurl(String rurl) {
        this.rurl = rurl;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "HuoquImageBo{" +
                "userId='" + userId + '\'' +
                ", parter='" + parter + '\'' +
                ", content='" + content + '\'' +
                ", sign='" + sign + '\'' +
                ", atime=" + atime +
                ", text='" + text + '\'' +
                ", ptext='" + ptext + '\'' +
                ", purl='" + purl + '\'' +
                ", rtext='" + rtext + '\'' +
                ", rurl='" + rurl + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
