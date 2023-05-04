import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
/**
 * Exemplo de JFrame com Expression Lambda
 * @author Prof. Paulo Barreto
 * @date 21/05/2015
 */
public class ExpressionLambda extends JFrame {
 
    private JButton btTradicional = new JButton("Clique Aqui!");
    private JButton btLambda = new JButton("Expression Lambda");
 
    public ExpressionLambda() {
        super("Listener Expression Lambda");
 
        setLayout(new FlowLayout());
        
        btTradicional.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Exemplo Tradicional de Listener");
            }
        });
 
        btLambda.addActionListener(e -> System.out.println("Exemplo Lambda"));
 
        btLambda.addActionListener(e -> {
            System.out.println("Chamada com Bloco de Código Lambda");
            System.out.println("Funciona!");
        });
 
        setSize(300, 100);
        
        add(btTradicional);
        add(btLambda);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExpressionLambda().setVisible(true);
            }
        });
    }
}