import dsq.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by aa on 2019/7/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class TestApp {

    @Autowired
    ApplicationContext context;

    @Test
    public void print() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }

    }
}
