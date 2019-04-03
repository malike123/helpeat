package com.malike.demo.model;

public class AddressModel {

    private String Address;
    private String city;

    //经纬度
    private String latitude;
    private String longitude;

    //城市hash值
    private String geohash;

    //地址名字
    private String name;

    private String count ;
    private String id ;
    private String request_id;

    private String short_address;
    private String city_id;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getShort_address() {
        return short_address;
    }

    public void setShort_address(String short_address) {
        this.short_address = short_address;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }


    public static AddressModel getDefaultAddress(){
        AddressModel addressModel = new AddressModel();
        addressModel.setName("保利·心语花园·上府7栋");
        addressModel.setAddress("四川省成都市武侯区保利心语花园上府二期7幢");
        addressModel.setCity("四川省成都市武侯区");
        addressModel.setCity_id("14");
        addressModel.setCount("2849");
        addressModel.setGeohash("wm3vz845m1qr");
        addressModel.setId("B0FFGB5ZKU");
        addressModel.setLatitude("30.542558");
        addressModel.setLongitude("104.043497");
        addressModel.setRequest_id("5635021051889166036");
        addressModel.setShort_address("保利心语花园上府二期7幢");

        return addressModel;
    }
}
