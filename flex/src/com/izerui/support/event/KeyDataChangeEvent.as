/**
 * Created by serv on 2015/3/4.
 */
package com.izerui.support.event {
import com.izerui.vo.Key;

import flash.events.Event;

public class KeyDataChangeEvent extends Event{

    public static var keyDataChangeEvent:String = "keyDataChangeEvent";

    public var key:Key;

    public function KeyDataChangeEvent(key:Key) {
        super(keyDataChangeEvent, true, true);
        this.key = key;
    }
}
}
