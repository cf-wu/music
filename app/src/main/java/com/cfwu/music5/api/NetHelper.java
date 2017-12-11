package com.cfwu.music5.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cfwu on 17-12-11.
 */
public class NetHelper {
    public static Map<String,String> getMusicApiBasicParams(String method){
        Map params=new HashMap();
        params.put("format","json");
        params.put("calback","");
        params.put("from","webapp_music");
        params.put("method",method);
        return params;
    }
}
