package pjAula7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de Conexão com o Banco de Dados
 * @author Prof. Paulo Barreto
 * @date 30/03/2023
 */

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/curso","root","admin");
		}catch(ClassNotFoundException erro){
			throw new SQLException(erro.getMessage());
		}
	}
	public static void main(String[] args) {
		try {
			Connection conn = ConnectionFactory.getConnection();
			if(conn != null) {
				System.out.println("Conexão realizada com sucesso!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
