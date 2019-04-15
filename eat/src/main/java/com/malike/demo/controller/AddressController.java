package com.malike.demo.controller;


import com.alibaba.fastjson.JSON;
import com.malike.demo.model.Result;
import com.malike.demo.model.address.AddressModel;
import com.malike.demo.service.AddressService;
import com.malike.demo.utils.HttpClientUtils;
import com.malike.demo.utils.JedisUtil;
import com.malike.demo.utils.RequestUtils;
import com.malike.demo.utils.Url;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    private static HttpClientUtils httpClientUtils = HttpClientUtils.getHttpClient();

    /**
     * 获取地址
     *
     * @param keyword   地址关键字
     * @return
     */
    @RequestMapping("/getAddress")
    @ResponseBody
    public Result<List<AddressModel>> getAddress(String keyword) throws IOException {
        Result<List<AddressModel>> result =  new Result<List<AddressModel>>();
        //创建
        CloseableHttpClient httpClient = httpClientUtils.getCloseableHttpClient();

        Map<String,String> map = new HashMap<String,String>();
        map.put("extras[]","count");
        map.put("geohash","wm6jbj1skd7d");
        map.put("keyword",keyword);
        map.put("limit","20");
        map.put("type","nearby");

        String Url = com.malike.demo.utils.Url.Addesss+"?"+ com.malike.demo.utils.Url.createLinkString(map);

        CloseableHttpResponse response = RequestUtils.Request(Url,"get",null,httpClient);
        List<AddressModel> list = RequestUtils.toArrayList(EntityUtils.toString(response.getEntity(),"utf-8"),AddressModel.class);
        JedisUtil.hset("address","11", JSON.toJSONString(list));

        result.setData(list);
        result.setStatus(true);
        return result;
    }

    /**
     * 选择地址
     * @param id
     * @return
     */
    @RequestMapping("/checkAddress")
    @ResponseBody
    public Result<AddressModel> checkAddress( String id){
        Result result = new Result();

        String addressStr = JedisUtil.hget("address","11");
        AddressModel addressModel = null;
        if (addressStr!=null && addressStr!=""){
            List<AddressModel> list = RequestUtils.toArrayList(addressStr,AddressModel.class);
            for (AddressModel addressModel1: list) {
                if(addressModel1.getId().equals(id)){
                    JedisUtil.setObjectValue("useraddress",addressModel1,60*60*60*24*60);
                    addressModel = addressModel1;
                }
            }
            result.setStatus(true);
            result.setData(addressModel);
            return result;
        }
        result.setStatus(false);
        return result;

    }




}
