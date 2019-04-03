package com.malike.demo.model.shop;

//优惠卷类型
class Activitie {
    public Integer id;

    public String attribute;

    //满减满32减15，满45减19，满65减26，满90减31，满120减40
    public String description;

    public String icon_color;

    public String icon_name;

    public boolean is_exclusive_with_food_activity;

    //自营销复杂满减活动
    public String name;

    //满32减15，满45减19，满65减26，满90减31，满120减40
    public String tips;

    public Integer type;

}
