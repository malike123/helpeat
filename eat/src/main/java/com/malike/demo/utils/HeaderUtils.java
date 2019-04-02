package com.malike.demo.utils;

import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeaderUtils {


    //设置header
    public static List<BasicHeader> getHeader(Map<String,String> map ) {
        List<BasicHeader> list = new ArrayList<BasicHeader>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }

            return list;
        }
        return list;
    }


    //设置header
    public static List<BasicHeader> getHeader2() {
        List<BasicHeader> list = new ArrayList<BasicHeader>();
        Map<String,String > map = new HashMap<String,String>();
        map.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        map.put("Referer","https://h5.ele.me/login/");
        map.put("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7");
        map.put("Origin","https://h5.ele.me");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(new BasicHeader(entry.getKey(), entry.getValue()));
            }

            return list;
        }
        return list;
    }
}
