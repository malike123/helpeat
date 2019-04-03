package com.malike.demo.controller;

import com.malike.demo.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 菜单
 */
@Controller
public class MenuController {

    @RequestMapping("/getmenu")
    public Result getMenu(){
        Result result = new Result();




        return result;
    }

}
