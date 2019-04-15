package com.malike.demo.controller;

import com.malike.demo.model.Result;
import com.malike.demo.model.address.AddressModel;
import com.malike.demo.model.response.ElmResponse;
import com.malike.demo.model.shop.Shop;
import com.malike.demo.utils.HttpClientUtils;
import com.malike.demo.utils.JedisUtil;
import com.malike.demo.utils.RequestUtils;
import com.malike.demo.utils.Url;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShopController {

    private static HttpClientUtils httpClientUtils = HttpClientUtils.getHttpClient();


    @RequestMapping("/getShop")
    public Result getShop() throws IOException {
        Result result = new Result();
        CloseableHttpClient closeableHttpClient = httpClientUtils.getCloseableHttpClient();
        Map<String,String> map = new HashMap<String,String>();
        AddressModel addressModel = (AddressModel) JedisUtil.getObjectValue("useraddress");

        map.put("extras[]","activities");
        map.put("geohash","wm3vxy9m3dm3");
        map.put("latitude",addressModel.getLatitude());
        map.put("limit","30");
        map.put("longitude",addressModel.getLongitude());
        map.put("offset","0");
        map.put("restaurant_category_ids[]","-100");
        map.put("sign",new Date().getTime()+"");
        map.put("terminal","web");

        String url = Url.Shop+"?"+ Url.createLinkString(map);
        CloseableHttpResponse entity = RequestUtils.Request(url,"get",null,closeableHttpClient);
        if (entity.getStatusLine().getStatusCode()!=200){
            ElmResponse elmResponse = RequestUtils.toObject(EntityUtils.toString(entity.getEntity(),"utf-8"),ElmResponse.class);
            result.setData(elmResponse);
            result.setStatus(false);
            return  result;
        }
        List<Shop> list = RequestUtils.toArrayList(EntityUtils.toString(entity.getEntity(),"utf-8"),Shop.class);
        result.setData(list);
        result.setStatus(true);
        return result;
    }
}
