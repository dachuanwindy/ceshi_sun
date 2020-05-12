package inspur.BXD_JCSP.Meiju_study;

import java.util.HashMap;
import java.util.Map;

public class Meiju_study {

    public static void main(String[] args) {

        Color red = Color.Red;

        Map<String, String> MAPSS = new HashMap<>();


        getSecurityModuleData();
    }

    private static void getSecurityModuleData() {
        System.out.println("alreadyObtainedDataSecurityModuleData");
    }

}

enum Color {
    Red, Green, Blank
}