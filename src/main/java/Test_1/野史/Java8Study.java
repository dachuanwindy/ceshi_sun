package Test_1.野史;

import javafx.util.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 基本功能实现
 * @date 2020/8/22 16:57
 */
public class Java8Study {

    public static void main(String[] args) {


//        Pair<String, String> stringStringPair = new Pair<String, String>("2", "3");
//
//        stringStringPair.getKey();
//        System.out.println(stringStringPair.getKey());
//        stringStringPair.getValue();
//        System.out.println(stringStringPair.getValue());
//
//
//        Pair<List<String>, List<String>> listListPair = new Pair<List<String>, List<String>>(new ArrayList<>(), new ArrayList<>());
//
//
//        Triple<String, String, String> stringStringStringTriple = new Triple() {
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//
//            @Override
//            public Object getLeft() {
//                return null;
//            }
//
//            @Override
//            public Object getMiddle() {
//                return null;
//            }
//
//            @Override
//            public Object getRight() {
//                return null;
//            }
//        };
//
//
//        stringStringStringTriple.getLeft();


        test();
    }


    public static void test() {

        for (int i = 0; i < 10; i++) {
            System.out.println("continue 前");
            if(true){
                break;
            }
            System.out.println("======");
        }
    }


    public void lambdaTest() {

        Runnable runnable = () -> {
            System.out.println("");
        };


        ArrayList<Object> list = new ArrayList<>();

        checkArgument(Objects.equals("", ""));

        checkNotNull(new Object());

    }
}
