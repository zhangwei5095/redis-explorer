package com.izerui.redis.utils;

import com.izerui.redis.RedisException;

import java.util.*;

/**
 * Created by serv on 2015/2/11.
 */
public class MapListUtils {

    public static List<Map<String,String>> map2KvLists(Map<String, String> map){
        Set<String> strings = map.keySet();
        String[] keys = strings.toArray(new String[strings.size()]);
        Arrays.sort(keys);

        List<Map<String,String>> mapList = new ArrayList<Map<String, String>>();
        for (String key : keys){
            Map<String,String> obj = new HashMap<String, String>();
            obj.put("key", key);
            obj.put("value",map.get(key));
            mapList.add(obj);
        }
        return mapList;
    }

    public static Map<String,String> kvList2Map(List<Map<String,String>> list){
        Map<String,String> resultMap = new HashMap<String, String>();
        for(Map<String,String> map:list){
            if(!map.containsKey("key")||!map.containsKey("value")){
                throw new RedisException("list对象不包含 key 或者 value 属性");
            }
            resultMap.put(map.get("key"),map.get("value"));
        }
        return resultMap;
    }
}
