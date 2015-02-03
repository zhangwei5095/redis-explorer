import com.izerui.redis.Application;
import com.izerui.redis.entity.RedisConfig;
import com.izerui.redis.repository.RedisConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by serv on 2015/2/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JpaTest {

    @Autowired
    RedisConfigRepository redisConfigRepository;

    @Test
    public void findAll(){
        List<RedisConfig> all = redisConfigRepository.findAll();
        Assert.notNull(all);
    }

}
