package flatlafdemo;

import javax.swing.JFrame;

public class LightJFrame extends JFrame{
    public LightJFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new LightJPanel());
        setBounds(100, 150, 600, 500);
        setVisible(true);
    }
}
