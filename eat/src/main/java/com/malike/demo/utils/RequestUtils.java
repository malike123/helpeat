package com.malike.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RequestUtils {

    //发送请求
    public static CloseableHttpResponse Request(String url, String method, UrlEncodedFormEntity entityParam,CloseableHttpClient httpClients ) throws IOException {

        URL url1 = new URL(url);
        if (method.equals("post")) {
            HttpPost httpPost = new HttpPost(String.valueOf(url1));
            if (entityParam != null) {
                httpPost.setEntity(entityParam);

            }
            CloseableHttpResponse closeableHttpResponse = httpClients.execute(httpPost);
            return closeableHttpResponse;
        } else if(method.equals("get")){
            HttpGet httpGet = new HttpGet(String.valueOf(url1));
            CloseableHttpResponse closeableHttpResponse = httpClients.execute(httpGet);
            return closeableHttpResponse;
        }
        return null;
    }

    //设置参数
    public static UrlEncodedFormEntity getParams(Map<String,String> map ) throws UnsupportedEncodingException {
        List<NameValuePair> list2 = new LinkedList<NameValuePair>();


        for (Map.Entry<String,String> entry: map.entrySet()){
            BasicNameValuePair basicNameValuePair = new BasicNameValuePair(entry.getKey(),entry.getValue());
            list2.add(basicNameValuePair);
        }
        return new UrlEncodedFormEntity(list2, "UTF-8");
    }

    //转换实体类
    public static <T> T toObject(String res, Class<T> clazz) {
        T object = (T) JSONObject.parseObject(res, clazz);
        return object;
    }

    //转换集合
    public  static <T> List<T> toArrayList(String res , Class<T> clazz){
        List<T> list = JSONArray.parseArray(res , clazz);
        return list;
    }

}
