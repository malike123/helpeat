package com.malike.demo.model;

import java.util.List;

public class CotegorysModel {
    public Integer id;
    public int count;
    public List<Integer> ids;
    private int level;
    private String name;

    private List<CotegoryModel> sub_categories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CotegoryModel> getSub_categories() {
        return sub_categories;
    }

    public void setSub_categories(List<CotegoryModel> sub_categories) {
        this.sub_categories = sub_categories;
    }
}
