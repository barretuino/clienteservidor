package br.com.barretuino.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.barretuino.model.Pessoa;

/**
 * Classe utilizada para fazer realizar as operações de banco de dados sobre a entity Pessoa.
 */
public class PessoaDAO {
	EntityManagerFactory factory = null;
	EntityManager entityManager = null;
	
	/**
	 * Método utilizado para obter o entity manager.
	 * @return
	 */
	private EntityManager getEntityManager() {
		try {
			//Obtém o factory a partir da unidade de persistência.
			factory = Persistence.createEntityManagerFactory("JPABarretuino");
			//Cria um entity manager.
			entityManager = factory.createEntityManager();
		}catch(Exception e) {
			System.out.println("Erro -->" + e);
		}
		return entityManager;
	}
	
	private void fecharFactory(){
		//Fecha o factory para liberar os recursos utilizado.
		factory.close();
	}

	/**
	 * Método utilizado para salvar ou atualizar as informações de uma pessoa.
	 * @param pessoa
	 * @return
	 * @throws java.lang.Exception
	 */
	public Pessoa salvar(Pessoa pessoa) throws Exception {
		EntityManager entityManager = getEntityManager();
		try {			
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			System.out.println("Salvando a pessoa.");
			// Verifica se a pessoa ainda não está salva no banco de dados.
			if(pessoa.getId() == null) {
				//Salva os dados da pessoa.
				entityManager.persist(pessoa);
			} else {
				//Atualiza os dados da pessoa.
				pessoa = entityManager.merge(pessoa);
			}
			// Finaliza a transação.
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch(Exception e){
			System.out.println("Erro -->" + e);
		}finally{
			fecharFactory();
		}
		return pessoa;
	}

	/**
	 * Método que apaga a pessoa do banco de dados.
	 * @param id
	 */
	public void excluir(Long id) {
		EntityManager entityManager = getEntityManager();
		try {
			// Inicia uma transação com o banco de dados.
			entityManager.getTransaction().begin();
			// Consulta a pessoa na base de dados através do seu ID.
			Pessoa pessoa = entityManager.find(Pessoa.class, id);
			System.out.println("Excluindo os dados de: " + pessoa.getNome());
			// Remove a pessoa da base de dados.
			entityManager.remove(pessoa);
			// Finaliza a transação.
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch(Exception e) {
			System.out.println("Erro -->" + e);
		}finally{
			fecharFactory();
		}
	}

	/**
	 * Consulta o pessoa pelo ID.
	 * @param id
	 * @return o objeto Pessoa.
	 */
	public Pessoa consultarPorId(Long id) {
		EntityManager entityManager = getEntityManager();
		Pessoa pessoa = null;
		try {
			//Consulta uma pessoa pelo seu ID.
			pessoa = entityManager.find(Pessoa.class, id);
			entityManager.close();
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			fecharFactory();
		}
		return pessoa;
	}
}