import com.izerui.redis.command.Command;
import com.izerui.redis.command.JedisExecutor;
import com.izerui.redis.entity.RedisServerConfig;
import org.junit.Before;
import redis.clients.jedis.Jedis;

/**
 * Created by serv on 2015/2/8.
 */
public abstract class AbstractRedisTest {

    private JedisExecutor executor;

    @Before
    public void before(){
        executor = new JedisExecutor(server());
    }

    public abstract RedisServerConfig server();

    public <T extends Command> T execute(T command){
        return executor.execute(command);
    }

}
