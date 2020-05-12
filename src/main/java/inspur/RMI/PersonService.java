package inspur.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PersonService extends Remote {
    public List<PersonEntity> Getlist() throws RemoteException;
}
