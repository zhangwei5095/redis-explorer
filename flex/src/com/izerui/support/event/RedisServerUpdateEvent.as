/**
 * Created by serv on 2015/2/8.
 */
package com.izerui.support.event {
import com.izerui.vo.RedisServerConfig;

import flash.events.Event;

public class RedisServerUpdateEvent extends Event{

    public static var redisServerUpdateEvent:String = "redisServerUpdateEvent";
    public var redisServer:RedisServerConfig;


    public function RedisServerUpdateEvent(redisServer:RedisServerConfig) {
        super(redisServerUpdateEvent, true, true);
        this.redisServer = redisServer;
    }
}
}
