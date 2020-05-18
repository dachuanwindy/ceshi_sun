package inspur.Thread_study;

public class multiThread extends Thread {

    private String name;

    public multiThread(String name) {

        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(name + "正在运行" + i);
        }
    }

}
