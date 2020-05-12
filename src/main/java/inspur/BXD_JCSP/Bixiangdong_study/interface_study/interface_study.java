package inspur.BXD_JCSP.Bixiangdong_study.interface_study;

public interface interface_study {
    void smoking();
}

abstract class Student {
    String name;
    String age;

    abstract void study();

    void sleep() {

        System.out.println("每个学员的共性 ---睡觉");
    }

}


interface lookingmovie {
    public String lookingmovie();
}

class Test {

    public static void main(String[] args) {

        System.out.println("测试程序");

        zhangsan zhangsan = new zhangsan();
        zhangsan.study();
    }
}

class zhangsan extends Student implements lookingmovie {

    @Override
    void study() {

        System.out.println("good study");
    }

    @Override
    public String lookingmovie() {
        System.out.println("喜欢看电影----");
        return null;
    }
}