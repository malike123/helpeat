package com.malike.demo.utils;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie2;

import java.util.List;

public class CookieUtils {

    private  static  final  CookieStore cookieStore = new BasicCookieStore();

    public CookieUtils(){
        cookieStore.addCookie(new BasicClientCookie2("ubt_ssid","foyw8zc3i2cghhb1j3bbjqspxi7pqnna_2019-03-29"));
        cookieStore.addCookie(new BasicClientCookie2("_utrace","4fd822f829aa23ad5b25370f32a28f58_2019-03-29"));
        cookieStore.addCookie(new BasicClientCookie2("perf_ssid","o0jpmix76pt61lxp7yafmjd7ezorz4tt_2019-03-29"));
        cookieStore.addCookie(new BasicClientCookie2("cna","AJ0uFPJQOBYCAWXP4u71Cf4S"));
        cookieStore.addCookie(new BasicClientCookie2("UTUSER","5104310"));
        cookieStore.addCookie(new BasicClientCookie2("eleme__ele_me","0d1daa644bcf64297d5dce966dcdfbf3%3A75e0a6b461b822c8ee47062db910a27606e87457"));
        cookieStore.addCookie(new BasicClientCookie2("track_id","1553855270%7C1b150f4d999c9145252e79423c577a8217ef9769eec63349f6%7Ccea2e3ffc4696f6e6f31af9cffbcdc09"));
        cookieStore.addCookie(new BasicClientCookie2("isg","BCgohI204GhOr8zSYV9B6ZLm-Rb6-elcZlCFSOJZPKOWPcqnhmC063I7NZVoNEQz"));
    }

    public static CookieStore getFristLoginCookie(){
        return cookieStore;
    }

    public static void addCookie(List<Header> list){
        for (Header header: list) {
            cookieStore.addCookie(new BasicClientCookie2(header.getName(),header.getValue()));
        }
    }
}
