package com.malike.demo.controller;


import com.malike.demo.model.ElmResponse;
import com.malike.demo.model.Result;
import com.malike.demo.model.login.Url;
import com.malike.demo.utils.HttpClientUtils;
import com.malike.demo.utils.RequestUtils;
import org.apache.http.HttpRequest;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private static HttpClientUtils httpClientUtils = HttpClientUtils.getHttpClient();

    @RequestMapping(value = "/getCode" )
    public Result getCode( String phoneNumber) throws IOException {
        Result result = new Result();
        //创建
        CloseableHttpClient httpClient = httpClientUtils.getCloseableHttpClient();
        //设置参数
        Map<String,String> map = new HashMap<String,String>();
        map.put("captcha_hash","");
        map.put("captcha_value","");
        map.put("mobile",phoneNumber);
        map.put("scf","ms");

        UrlEncodedFormEntity entity = RequestUtils.getParams(map);
        CloseableHttpResponse response = RequestUtils.Request(Url.Login,"post",entity,httpClient);
        ElmResponse elmResponse = RequestUtils.toObject(EntityUtils.toString(response.getEntity(), "UTF-8"),ElmResponse.class);

        //获取图形验证码
//        if(elmResponse.getName().equals("NEED_CAPTCHA")||elmResponse.getMessage().equals("账户存在风险,需要图形验证码")){
//
//        }
        result.setData(elmResponse);

        return result;
    }

    @RequestMapping(value = "/getImageCode")
    public Result getImageCode(String phoneNumber, HttpServletRequest request) throws IOException {
        Result result = new Result();
        //创建
        CloseableHttpClient httpClient = httpClientUtils.getCloseableHttpClient();
        //设置参数
        Map<String,String> map = new HashMap<String,String>();
        map.put("captcha_str",phoneNumber);

        UrlEncodedFormEntity entity = RequestUtils.getParams(map);
        CloseableHttpResponse response = RequestUtils.Request(Url.Send_Code,"post",entity,httpClient);
        ElmResponse elmResponse = RequestUtils.toObject(EntityUtils.toString(response.getEntity(), "UTF-8"),ElmResponse.class);
        String path=request.getSession().getServletContext().getRealPath("upload/");
        GenerateImage(path,new Date().getTime());


        result.setData(elmResponse);

        return result;
    }

    @RequestMapping(value = "/login" )
    public Result login( String phoneNumber,String validate_token,String validate_code) throws IOException {
        Result result = new Result();
        //创建
        CloseableHttpClient httpClient = httpClientUtils.getCloseableHttpClient();
        //设置参数
        Map<String,String> map = new HashMap<String,String>();
        map.put("validate_token",validate_token);
        map.put("validate_code",validate_code);
        map.put("mobile",phoneNumber);
        map.put("scf","ms");

        UrlEncodedFormEntity entity = RequestUtils.getParams(map);
        CloseableHttpResponse response = RequestUtils.Request(Url.Send_Code,"post",entity,httpClient);
        ElmResponse elmResponse = RequestUtils.toObject(EntityUtils.toString(response.getEntity(), "UTF-8"),ElmResponse.class);

        //获取图形验证码
//        if(elmResponse.getName().equals("NEED_CAPTCHA")||elmResponse.getMessage().equals("账户存在风险,需要图形验证码")){
//
//        }
        result.setData(elmResponse);

        return result;
    }

    //存入验证码图片
    private static void GenerateImage(String imgStr,long time) throws IOException {
        if (imgStr == null)
            return ;
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(imgStr);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        OutputStream out = new FileOutputStream(imgStr+time+".jpeg");
        out.write(b);
        out.flush();
        out.close();
    }


}
