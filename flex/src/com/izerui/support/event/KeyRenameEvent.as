/**
 * Created by serv on 2015/2/8.
 */
package com.izerui.support.event {
import com.izerui.vo.Key;

import flash.events.Event;

public class KeyRenameEvent extends Event{
	
	public var key:Key;

    public static var renameKeyEvent:String = "renameKeyEvent";

    public function KeyRenameEvent() {
        super(renameKeyEvent, true, true);
    }
}
}
