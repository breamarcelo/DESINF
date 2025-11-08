import javax.swing.JFrame;

public class MiJFrame extends JFrame{
    MiJPanel miJPanel = new MiJPanel();
    public MiJFrame(){
        setVisible(true);
        setBounds(400, 300, 400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miJPanel);
    }
}
