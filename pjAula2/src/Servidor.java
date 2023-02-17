import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
	public static void main(String args[]) {
		try {
			String nomeServico = "MeuServico";
			int porta = 12345;

			Servico servico = new ImplementacaoServico();
			Servico servicoDistribuido = 
					(Servico) UnicastRemoteObject
						.exportObject(servico, 0);

			Registry registry = LocateRegistry.createRegistry(porta);
			registry.bind(nomeServico, servicoDistribuido);
			System.out.printf("Servico disponivel: %s%n", nomeServico);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}