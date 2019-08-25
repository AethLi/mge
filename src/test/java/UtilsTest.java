import cn.aethli.mge.MgeStarter;
import org.junit.Test;

/**
 * @device: Hades
 * @author: Termite
 * @date: 2019-08-13 18:03
 **/
public class UtilsTest {
    @Test
    public void jsonUtilsTest() {
        try {
            MgeStarter.start(this.getClass().getResource("config.yml").getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
