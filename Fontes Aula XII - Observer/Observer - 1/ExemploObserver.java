import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ExemploObserver {

    public static void main(String [] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new ExemploObserver().start();
            }
        });
    }

    private void start() {
	
        MainWindow m = new MainWindow();
        new DialogWindow(m);
    }
}

class MainWindow implements Observer {

    private JLabel label;
	
    //Implementação do método de atualização dos Observadores
    @Override 
    public void update(Observable o, Object data) {
	
        label.setText((String) data); 
    }
	
    MainWindow() {
	
        JFrame frame = new JFrame("Main Window");
        frame.getRootPane().setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20));		
        label = new JLabel("Click button in Dialog...");
        label.setFont(new Font("Dialog", Font.PLAIN, 20));	
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocation(200, 200);
        frame.setVisible(true);
    }
}

class DialogWindow {

    private int clicks;
	
    DialogWindow(MainWindow mainWindow) {
	
        //Criar Observable e adicionar Observer		
        final MessageObservable observable = new MessageObservable();
        observable.addObserver(mainWindow);
		
        JFrame dialog = new JFrame("Dialog");		
        JButton button = new JButton("Press me");
        button.setFont(new Font("Dialog", Font.PLAIN, 20));
		
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Botão clicado [" + ++clicks + "]";
                observable.changeData(data);
            }
        });
		
        dialog.add(button);
        dialog.setSize(250, 150);
        dialog.setLocation(600, 200);
        dialog.setVisible(true);
    }
}

class MessageObservable extends Observable {

    MessageObservable() {
        super();
    }
    void changeData(Object data) {
	
        setChanged(); //os dois métodos de classe Observable
        notifyObservers(data);
    }
}