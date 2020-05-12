package inspur.BXD_JCSP.Bixiangdong_study.Mode_duotai;


interface PCI {
    void open();

    void close();
}

public class Zhuban {
    public void run() {
        System.out.println("主板运行起来了----");
    }

    public void zhubanPCI(PCI pci) {
        if (pci != null) {
            pci.open();
            pci.close();
        }
    }
}

class Wangka implements PCI {
    @Override
    public void open() {
        System.out.println("电脑能上网了");
    }

    @Override
    public void close() {
        System.out.println("电脑能上网了");
    }
}

class soundCard implements PCI {
    @Override
    public void open() {
        System.out.println("声卡能正常使用了");
    }

    @Override
    public void close() {
        System.out.println("声卡断电了----");
    }


    private void shengka_kuozhan() {

        System.out.println("声卡功能扩展---");
    }
}

class Test {
    public static void main(String[] args) {

        System.out.println("主板测试====");
        Zhuban zhuban = new Zhuban();
        zhuban.run();
        zhuban.zhubanPCI(new Wangka());
        zhuban.zhubanPCI(new soundCard());

        System.out.println(zhuban.getClass());
    }

}