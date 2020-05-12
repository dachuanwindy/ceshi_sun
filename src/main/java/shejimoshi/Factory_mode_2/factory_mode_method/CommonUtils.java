package shejimoshi.Factory_mode_2.factory_mode_method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunfch
 * @create 2018-11-03 11:35
 * @desc 静态工厂方法，直接返回自己想要的
 **/
public class CommonUtils {

    public static <T, V> Map<T, V> Hashmap() {
        return new HashMap<>();
    }

    public static List  arrylist() {
        return new ArrayList ();
    }
}
