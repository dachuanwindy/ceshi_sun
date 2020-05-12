package shejimoshi.waiguan_moshi;

//外观模式 facecade
public class CPU {

    public void startup() {
        System.out.println("CPU 启动了");
    }

    public void shutdown() {
        System.out.println("CPU 关闭了");
    }
}

class Memory {

    public void starup() {
        System.out.println("memory 启动了");
    }

    public void shutdown() {
        System.out.println("memory 关闭了");
    }


}

class Disk {


    public void startup() {
        System.out.println("Disk 启动了");
    }

    public void shutdown() {
        System.out.println("disk 关闭了");
    }
}