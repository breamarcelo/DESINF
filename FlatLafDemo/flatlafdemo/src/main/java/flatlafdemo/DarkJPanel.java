package flatlafdemo;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DarkJPanel extends JPanel {
    public DarkJPanel(){
        setLayout(new GridLayout(5, 1));
        setBorder(new EmptyBorder(15,15,15,15));
        JPanel nombrePanel = new JPanel();
        nombrePanel.add(new JLabel("Nombre"));
        JTextField nombreTextField = new JTextField();
        nombrePanel.add(nombreTextField);
        add(nombrePanel);
        
        JPanel edadPanel = new JPanel();
        JSlider edadJSlider = new JSlider(0, 100, 50);
        edadPanel.add(edadJSlider);
        JLabel edadJLabel = new JLabel(Integer.toString(edadJSlider.getValue()));
        edadJSlider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                edadJLabel.setText("Edad: " + edadJSlider.getValue());
            }
            
        });
        edadPanel.add(edadJLabel);
        add(edadPanel);
        
        JPanel mostrarDatosPanel = new JPanel();
        JLabel mostrarDatosJLabel = new JLabel("");
        mostrarDatosPanel.add(mostrarDatosJLabel);
        add(mostrarDatosPanel);
        
        JPanel botones1 = new JPanel();
        JButton limpiarBtn = new JButton("Limpiar");
        limpiarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTextField.setText("");
                edadJSlider.setValue(50);
                mostrarDatosJLabel.setText("");
            }
            
        });
        botones1.add(limpiarBtn);
        
        JButton saludarBtn = new JButton("SALUDAR");
        saludarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatosJLabel.setText("Hola " + nombreTextField.getText() + " tienes " + edadJSlider.getValue() + " años.");
            }
            
        });
        botones1.add(saludarBtn);
        add(botones1);

        JPanel botones2 = new JPanel();
        JButton cerrarBtn = new JButton("CERRAR");
        cerrarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.getFrames()[1].dispose();
            }
            
        });
        botones2.add(cerrarBtn);

        add(botones2);

        
    }
}
