package pjAula4;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** 
 * Exemplo de Chamada HTTP
 * @author Prof. Paulo Barreto
 * @date 16/03/2023
 */

public class TesteHTTP {
	public static void main(String[] args) 
			throws IOException, InterruptedException {
		//Declaração da url de consulta
		var url = "http://viacep.com.br/ws/13450197/xml";
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(url))
					.GET()
					.build();
			HttpClient httpClient = HttpClient.newHttpClient();
			var response = httpClient.send(request, 
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		}catch(URISyntaxException e) {
			System.err.println("Erro ao realizar a execução. " + e);
		}
	}
}