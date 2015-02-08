package com.izerui.vo {
import com.adobe.cairngorm.vo.IValueObject;

import mx.collections.ArrayCollection;

[Bindable]
[RemoteClass(alias="com.izerui.redis.entity.RedisServerConfig")]
public class RedisServerConfig implements IValueObject {
    public var id:String;
    public var displayName:String;
    public var host:String;
    public var password:String;
    public var port:int;
    public var createTime:Date;
    public var updateTime:Date;

    //extends
    public var dbIndex:int;
    public var children:ArrayCollection;
}
}