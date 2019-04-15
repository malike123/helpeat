/**
  * Copyright 2019 bejson.com 
  */
package com.malike.demo.model.shop;
import java.util.List;

/**
 * Auto-generated: 2019-04-12 16:13:14
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Piecewise_agent_fee {

    private String description;
    private double extra_fee;
    private boolean is_extra;
    private String no_subsidy_fee;
    private List<Rules> rules;
    private String tips;
    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setExtra_fee(double extra_fee) {
         this.extra_fee = extra_fee;
     }
     public double getExtra_fee() {
         return extra_fee;
     }

    public void setIs_extra(boolean is_extra) {
         this.is_extra = is_extra;
     }
     public boolean getIs_extra() {
         return is_extra;
     }

    public void setNo_subsidy_fee(String no_subsidy_fee) {
         this.no_subsidy_fee = no_subsidy_fee;
     }
     public String getNo_subsidy_fee() {
         return no_subsidy_fee;
     }

    public void setRules(List<Rules> rules) {
         this.rules = rules;
     }
     public List<Rules> getRules() {
         return rules;
     }

    public void setTips(String tips) {
         this.tips = tips;
     }
     public String getTips() {
         return tips;
     }

}