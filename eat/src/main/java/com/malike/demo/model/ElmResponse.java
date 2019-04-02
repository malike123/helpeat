package com.malike.demo.model;

public class ElmResponse {
    public String message;
    public String name;
    public String validate_token;//验证码登陆密钥

    public String captcha_hash; //图形验证码
    public String captcha_image; //base64图片



    public String getValidate_token() {
        return validate_token;
    }

    public void setValidate_token(String validate_token) {
        this.validate_token = validate_token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
