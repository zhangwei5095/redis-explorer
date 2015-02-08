/**
 * Created by serv on 2015/2/8.
 */
package com.izerui.support.event {
import com.izerui.vo.RedisServerConfig;

import flash.events.Event;

public class DbItemSelectEvent extends Event{

    public static var dbItemSelectEvent:String = "dbItemSelectEvent";

    public var selItem:RedisServerConfig;

    public function DbItemSelectEvent(selItem:RedisServerConfig) {
        super(dbItemSelectEvent, true, true);
        this.selItem = selItem;
    }

}
}
