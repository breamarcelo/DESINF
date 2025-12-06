package flatlafdemo;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LightJPanel extends JPanel{
    public LightJPanel(){
        setLayout(new GridLayout(4, 1));
        setBorder(new EmptyBorder(15,15,15,15));
        JPanel nombrePanel = new JPanel();
        nombrePanel.add(new JLabel("Nombre"));
        JTextField nombreTextField = new JTextField();
        nombrePanel.add(nombreTextField);
        add(nombrePanel);
        
        JPanel edadPanel = new JPanel();
        edadPanel.add(new JLabel("Edad"));
        JTextField edadTextField = new JTextField();
        edadPanel.add(edadTextField);
        add(edadPanel);
        
        JPanel botones1 = new JPanel();
        JButton limpiarBtn = new JButton("Limpiar");
        limpiarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTextField.setText("");
                edadTextField.setText("");
            }
            
        });
        botones1.add(limpiarBtn);

        JButton saludarBtn = new JButton("SALUDAR");
        saludarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hola " + nombreTextField.getText());
            }
            
        });
        botones1.add(saludarBtn);
        add(botones1);

        JPanel botones2 = new JPanel();
        JButton cerrarBtn = new JButton("CERRAR");
        cerrarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.getFrames()[0].dispose();
            }
            
        });
        botones2.add(cerrarBtn);

        add(botones2);

        
    }
}
