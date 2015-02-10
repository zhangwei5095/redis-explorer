package com.izerui.vo {
import com.adobe.cairngorm.vo.IValueObject;

[Bindable]
[RemoteClass(alias="com.izerui.redis.dto.Key")]
public class Key implements IValueObject {
    public var name:String;
    public var type:String;
    public var size:Number;
	
	[Bindable]
	public function get typeName():String
	{
		switch(type)
		{
			case "hash":
			{
				return "哈希表";	
			}
			case "string":
			{
				return "字符串";	
			}
			case "list":
			{
				return "列表";	
			}
			case "set":
			{
				return "集合";	
			}
			case "zset":
			{
				return "有序集合";	
			}
		}
		return null;
	}

}
}