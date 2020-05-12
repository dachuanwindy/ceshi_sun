package inspur.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
//服务端创建过程，首先引用接口并且实例化， 注册接口，

public class ServerTest {
    public static void main(String[] args) {
        try {
            PersonService personService = new PersonServiceImp();
//            LocateRegistry.createRegistry(6600);
            //注册通讯端口
            LocateRegistry.createRegistry(6600);
            //注册通讯路径
            Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
            System.out.println("Service Start!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}