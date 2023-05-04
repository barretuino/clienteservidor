package br.com.barretuino.test;

import java.util.List;

import br.com.barretuino.dao.ClienteDAO;
import br.com.barretuino.model.Cliente;

public class ClienteDAOTeste {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setId(5);
		cliente.setCpf("201.652.554-81");
		cliente.setNome("Paulo C. Barreto");
		cliente.setRg("12.764.421-X");
	
		ClienteDAO dao = ClienteDAO.getInstance();
		
		//Inserção
		dao.persist(cliente);
		
		//Pesquisa full table
		System.out.println("Pesquisa full table");
		List<Cliente> listaClientes = dao.findAll();
		listaClientes.forEach(e -> {
			System.out.println(e.getId() 	+ "\t" 
		                     + e.getNome() 	+ "\t"
		                     + e.getCpf() 	+ "\t"
		                     + e.getRg());
		});
		
		//Pesquisa pontual
		System.out.println("Pesquida única entidade");
		cliente = dao.getById(1);
		System.out.println(cliente.getId() 	+ "\t" 
			                + cliente.getNome() 	+ "\t"
			                + cliente.getCpf() 	+ "\t"
			                + cliente.getRg());
	}
}
