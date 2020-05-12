package shejimoshi.waiguan_moshi;

public class Computer {
    private  CPU cpu;

    private  Memory memory;

    private Disk disk;

    public Computer(){
        cpu =new CPU();
        memory=new Memory();
        disk=new Disk();
    }

    public void startup (){
        System.out.println("电脑启动了");
        cpu.startup();
        memory.starup();
        disk.startup();
        System.out.println("电脑正式启动了");
    }
    public void  shutdown(){
        System.out.println("电脑关闭了");
        cpu=new CPU();
        memory=new Memory();
        disk=new Disk();
        cpu.shutdown();
        disk.shutdown();
        memory.shutdown();
        System.out.println("电脑已经关闭了=====");
    }

}
