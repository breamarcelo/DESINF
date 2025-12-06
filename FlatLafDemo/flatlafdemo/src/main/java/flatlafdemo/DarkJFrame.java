package flatlafdemo;

import javax.swing.JFrame;

public class DarkJFrame extends JFrame {
    public DarkJFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new DarkJPanel());
        setBounds(800, 150, 600, 500);
        setVisible(true);
    }
}
