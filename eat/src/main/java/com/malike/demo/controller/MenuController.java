package com.malike.demo.controller;

import com.malike.demo.model.Result;
import com.malike.demo.utils.HttpClientUtils;
import org.springframework.stereotype.Controller;

/**
 * 菜单
 */
@Controller
public class MenuController {

    private static HttpClientUtils httpClientUtils = HttpClientUtils.getHttpClient();

    public Result getMenu(){
        Result result = new Result();
        return  result;
    }
}
