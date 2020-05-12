package inspur.BXD_JCSP.Bixiangdong_shipin;

public class Outer {
    int number = 2;

    class inner {
        void function() {
            System.out.println("内部函数-->>>>>" + number);
        }
    }
}

class Testmain {
    public static void main(String[] args) {
        System.out.println("内部类访问机制===");
        Outer.inner inener = new Outer().new inner();
        inener.function();



    }
}