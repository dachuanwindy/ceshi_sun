package inspur.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class PersonServiceImp extends UnicastRemoteObject implements PersonService {

    public PersonServiceImp() throws RemoteException {
        super();
    }

    @Override
    public List<PersonEntity> Getlist() throws RemoteException {
        System.out.println("Get Person Start!");
        List<PersonEntity> personList = new LinkedList<PersonEntity>();

        PersonEntity person1 = new PersonEntity();
        person1.setAge(25);
        person1.setId("222");
        person1.setName("Leslie");
        personList.add(person1);

        PersonEntity person2 = new PersonEntity();
        person2.setAge(25);
        person2.setId("333");
        person2.setName("Rose");
        personList.add(person2);

        return personList;
    }
}
