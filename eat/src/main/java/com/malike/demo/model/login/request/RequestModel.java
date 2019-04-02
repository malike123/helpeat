package com.malike.demo.model.login.request;

//发送验证码实体类
public class RequestModel {
    private String captcha_hash;
    private String captcha_value;
    private String mobile;
    private String scf;

    public String getCaptcha_hash() {
        return captcha_hash;
    }

    public void setCaptcha_hash(String captcha_hash) {
        this.captcha_hash = captcha_hash;
    }

    public String getCaptcha_value() {
        return captcha_value;
    }

    public void setCaptcha_value(String captcha_value) {
        this.captcha_value = captcha_value;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getScf() {
        return scf;
    }

    public void setScf(String scf) {
        this.scf = scf;
    }
}
