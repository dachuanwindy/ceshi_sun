package inspur.BXD_JCSP.Bixiangdong_study.Exeption_study;

/**
 * java 异常总结： throwable  分为error 和 exception  其中error 是虚拟机级别的异常，不能通过运行的异常
 * <p>
 * exception 是可恢复异常，是可以处理的， 又分为检查异常 与  Runtimeexception (运行时异常)
 * <p>
 * -----运行异常能正常通过编译的，只是在运行的时候，会出现各种违背自然规律的异常。
 * 运行异常主要包括：空指针异常 ，算数异常，数组越界异常，类型转换异常，数组存储异常等等。
 * <p>
 * 检查异常主要包括：IO异常 与sql异常 ；检查异常主要在编译阶段进行处理： try  catch{} 拦截处理
 */
class Exeotion_ZDY extends Exception {

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    Exeotion_ZDY() {
        super();
    }

    Exeotion_ZDY(String msg, int value) {
        super(msg);
        this.value = value;
    }
}


class exptionDemo {
    int div(int a, int b) throws Exeotion_ZDY {
        if (b < 0) {
            throw new Exeotion_ZDY("输入值不能有负数", b);
        }
        return a / b;
    }
}

class Test {

    public static void main(String[] args) {
        exptionDemo exptionDemo = new exptionDemo();
        int result;
        try {
            result = exptionDemo.div(4, -2);
        } catch (Exeotion_ZDY exeotion_zdy) {
            exeotion_zdy.printStackTrace();
            exeotion_zdy.getMessage();
            System.out.println(exeotion_zdy.getValue());
        }
    }
}


class MyIoexception extends Exception {

  MyIoexception(){
      super();
  }



}