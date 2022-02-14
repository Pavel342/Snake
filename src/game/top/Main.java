package game.top;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame{
    public Main(){
     init();
    }
    private  void init(){
        add(new mehanika());
        setResizable(false);
        pack();
        setTitle("Анаконда");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new Main();
            ex.setVisible(true);
        });
    }
}
