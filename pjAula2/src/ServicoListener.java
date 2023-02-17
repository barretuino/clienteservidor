import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que define o padrão do Servico de Comunicação
 * @author Prof. Paulo Barreto
 * @date 16/02/2023
 */

public interface ServicoListener extends Remote {
	void calculoEfetuado(double resultado) throws RemoteException;
}