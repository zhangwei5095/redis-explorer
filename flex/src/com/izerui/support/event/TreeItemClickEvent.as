package com.izerui.support.event
{
	import flash.events.Event;
	
	public class TreeItemClickEvent extends Event
	{

		public function TreeItemClickEvent(type:String)
		{
			super(type, true, true);
		}
	}
}