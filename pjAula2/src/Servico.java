import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servico extends Remote {

	void addListener(ServicoListener listener) throws RemoteException;

	void setX(double valor) throws RemoteException;

	void setY(double valor) throws RemoteException;
}