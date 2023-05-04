package pjEstudos;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmBoxLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JTable tabAlunos;
	JButton btPesquisar, btSair;
	private	JScrollPane scrollPane;
	String nomesColunas[] = { "Coluna A", "Coluna B", "Coluna C" };
	String valores[][] =
		{
				{ "12", "234", "67" },
				{ "-123", "43", "853" },
				{ "93", "89.2", "109" },
				{ "279", "9033", "3092" }
		};


	public frmBoxLayout() {
		setTitle("Exemplo BoxLayout");
		setSize(600,600);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));

		tabAlunos = new JTable( valores, nomesColunas );		
		scrollPane = new JScrollPane(tabAlunos);
		
		btPesquisar = new JButton("Pesquisa");
		btSair = new JButton("Sair");

		add(scrollPane);
		add(btPesquisar);
		add(btSair);

		setVisible(true);
	}

	public static void main(String[] args) {
		frmBoxLayout frmBoxLayout = new frmBoxLayout();
		frmBoxLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
