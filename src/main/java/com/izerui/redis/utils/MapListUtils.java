package com.izerui.redis.utils;

import com.izerui.redis.RedisException;

import java.util.*;

/**
 * Created by serv on 2015/2/11.
 */
public class MapListUtils {

    public static List<Map> map2KvLists(Map map,String keyName,String valueName){
        Set<String> strings = map.keySet();
        String[] keys = strings.toArray(new String[strings.size()]);
        Arrays.sort(keys);

        List<Map> mapList = new ArrayList<Map>();
        for (String key : keys){
            Map obj = new HashMap();
            obj.put(keyName, key);
            obj.put(valueName,map.get(key));
            mapList.add(obj);
        }
        return mapList;
    }

    public static Map kvList2Map(List<Map> list,String keyName,String valueName){
        Map resultMap = new HashMap();
        for(Map map:list){
            if(!map.containsKey(keyName)||!map.containsKey(valueName)){
                throw new RedisException("list对象不包含 "+keyName+" 或者 "+valueName+" 属性");
            }
            resultMap.put(map.get(keyName),map.get(valueName));
        }
        return resultMap;
    }
    public static Map<String,Double> zSetList2Map(List<Map> list,String keyName,String valueName){
        Map resultMap = new HashMap();
        for(Map map:list){
            if(!map.containsKey(keyName)||!map.containsKey(valueName)){
                throw new RedisException("list对象不包含 "+keyName+" 或者 "+valueName+" 属性");
            }
            resultMap.put(map.get(keyName),Double.valueOf(map.get(valueName).toString()));
        }
        return resultMap;
    }
}
