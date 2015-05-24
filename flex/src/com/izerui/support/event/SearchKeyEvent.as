/**
 * Created by serv on 2015/2/8.
 */
package com.izerui.support.event {
import flash.events.Event;

import mx.collections.ArrayCollection;

public class SearchKeyEvent extends Event{
	
	public var filterData:ArrayCollection;
    public var searchKey:String;

    public static var searchKeyEvent:String = "searchKeyEvent";

    public function SearchKeyEvent() {
        super(searchKeyEvent, true, true);
    }
}
}
