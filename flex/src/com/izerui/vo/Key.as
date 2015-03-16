package com.izerui.vo {
import com.adobe.cairngorm.vo.IValueObject;

[Bindable]
[RemoteClass(alias="com.izerui.redis.dto.Key")]
public class Key implements IValueObject {
    public var name:String;
    public var type:String;
    public var size:Number = 0;
	public var ttls:Number = -1;
	//key在gridlist中的索引
	public var rowIndex:int;

}
}