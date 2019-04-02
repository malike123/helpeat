package com.malike.demo.utils;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class HttpClientUtils  {

    private  static HttpClientUtils httpClient = new HttpClientUtils();
    private static CloseableHttpClient httpClients ;

   private HttpClientUtils(){

   }

   public static  HttpClientUtils getHttpClient(){
       return httpClient;
   }


    //初始化httpclient
    public  CloseableHttpClient getCloseableHttpClient(){
        httpClients = HttpClients.custom().setDefaultCookieStore(CookieUtils.getFristLoginCookie()).setDefaultHeaders(HeaderUtils.getHeader2()).build();
        return httpClients;
    }



}
