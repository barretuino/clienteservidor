import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class svlPesquisar extends HttpServlet {
  private Cliente cliente;
  private ClienteDAO DAO;
  private String mensagem;  
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, IOException {

	cliente = new Cliente();
    // pega par�metros do request
		try {
		DAO = new ClienteDAO();
		cliente = DAO.pesquisar(Double.parseDouble(request.getParameter("cpf")));
		mensagem = "<font color=blue>Cliente Encontrado</font>";		
	} catch (SQLException erro) {	
		mensagem = "<font color=red>Houve um erro " + 	erro + "</font>";
	}

	//acerta tipo MIME para a resposta
	response.setContentType("text/html");

	PrintWriter out = response.getWriter();	
	out.println("<a href=javascript:window.history.go(-1)>Voltar</a>");
	out.println("<HTML>");
	out.println("<BODY>");	

	if (cliente.getCpf()!=0){
		out.println("<P>" + mensagem + "</P>");
		out.println("<P>CPF: " + request.getParameter("cpf") + "   Nome: " + cliente.getNome() + "   Sexo: " + (cliente.getSexo().equals("M")? "Masculino":"Feminino") + " </P>");
		out.println("<P>Endere�o: </P>");
		out.println("<P>Rua: " + cliente.getEndRua() + "   N�mero: " + cliente.getEndNum() + "   Complemento: " + cliente.getEndComplemento() + " </P>");
		out.println("<P>Bairro: " + cliente.getEndBairro() + "   Cidade: " + cliente.getEndCidade() + "   UF: " + cliente.getEndUF() + " </P>");		
	}else{
		out.println("<P><font color=red>Cliente N�o Encontrado</font></P>");
	}
	out.println("<P>Curso de Extens�o Avan�ado em Java - Paulo Barreto</P>");	
	out.println("</BODY>");
	out.println("</HTML>");
	out.close();
  }
}
