package com.malike.demo.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Url {

    //获取手机验证码
    public final static String Send_Code= "https://h5.ele.me/restapi/eus/login/mobile_send_code";


    //获取图形验证码
    public final static  String Image_Code="https://h5.ele.me/restapi/eus/v3/captchas";

    //登录
    public final static  String Login = "https://h5.ele.me/restapi/eus/login/login_by_mobile";

    //获取地址信息url  不带参数
    public  static  String Addesss = "https://www.ele.me/restapi/v2/pois";

    //获取店铺信息
    public  static  String Shop = "https://www.ele.me/restapi/shopping/restaurants";

    /**
     * 把数据用&链接起来
     * @param params
     * @return
     */
    public static String createLinkString(Map<String,String> params ){
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = (String) params.get(key);
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;

    }
}
