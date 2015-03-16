/**
 * Created by serv on 2015/2/8.
 */
package com.izerui.support.event {
import com.izerui.vo.Key;

import flash.events.Event;

public class KeyAddEvent extends Event{
	
	public var key:Key;

    public static var addKeyEvent:String = "addKeyEvent";

    public function KeyAddEvent() {
        super(addKeyEvent, true, true);
    }
}
}
