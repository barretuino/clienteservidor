package br.com.barretuino.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.barretuino.dao.PessoaDAO;
import br.com.barretuino.model.Pessoa;

/**
 * Classe utilizada para testar os métodos do PessoaDAO.
 */
public class PessoaDAOTeste {
	public static void main(String[] args) throws Exception {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Paulo Barreto");
		Calendar data = new GregorianCalendar();
		data.set(Calendar.YEAR, 1982);
		data.set(Calendar.MONTH, 7);
		data.set(Calendar.DAY_OF_MONTH, 8);
		pessoa.setDataNascimento(data.getTime());
		pessoa.setEmail("barretuino@gmail.com");

		PessoaDAO dao = new PessoaDAO();
		System.out.println("Salvando a pessoa: " + pessoa.getNome());
		pessoa = dao.salvar(pessoa);

		pessoa.setNome("Paulo César Barreto");
		pessoa = dao.salvar(pessoa);
		System.out.println("Alterando a pessoa: " + pessoa.getNome());

		Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());
		System.out.println("Consultando: " + pessoa2.getNome());

//		System.out.println("Removendo a pessoa: " + pessoa.getId());
//		dao.excluir(pessoa.getId());
	}
}