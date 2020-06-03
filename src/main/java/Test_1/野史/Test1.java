package Test_1.野史;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/1 19:34
 */
public class Test1 {

    public static void main(String[] args) {
        test2();
    }

    public static void test3() {
        //求字符串长度
        Object execute = AviatorEvaluator.execute("string.length('hello')");
        System.out.println(execute.toString());
        Long result = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(result);

        String yourname = "aviator";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("yourname", yourname);
        String result2 = (String) AviatorEvaluator.execute(" 'hello ' + yourname ", env);
        System.out.println(result2);
    }

    public static void test2() {
        String expression = "a-(b-c)>100";
        // 编译表达式
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        // 执行表达式
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);  // false
    }


}
