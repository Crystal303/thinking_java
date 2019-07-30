package chap17.hashcode;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 预测天气
 *
 * @author crystal303
 */
public class SpringDetector {
    // Uses a Groundhog or class derived from Groundhog

    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map =
                new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        System.out.println("map = " + map);
    }
}
