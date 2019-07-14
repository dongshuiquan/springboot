import com.dsq.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by aa on 2019/7/8.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class StarterTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void loadTest() {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
