package flatlafdemo;

import javax.swing.JFrame;

public class MiJFrame extends JFrame{
    public MiJFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new MiJPanel());
        setSize(600, 500);
        setVisible(true);
    }
}
