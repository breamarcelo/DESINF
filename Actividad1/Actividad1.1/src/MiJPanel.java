import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiJPanel extends JPanel{
    JTextField campoNombre = new JTextField();
    JTextField campoApellidos = new JTextField();
    JTextField campoEmail = new JTextField();
    JTextField campoEdad = new JTextField();
    JTextField campoTelefono = new JTextField();
    JLabel mensajeError = new JLabel("No se pueden alamacenar más alumnos.");
    JLabel masJovenLabel = new JLabel("Alumno más joven: ");
     public MiJPanel(){
        setLayout(new GridLayout(13,1));
        add(new JLabel("Nombre:"));
        add(campoNombre);
        add(new JLabel("Apellidos:"));
        add(campoApellidos);
        add(new JLabel("Email:"));
        add(campoEmail);
        add(new JLabel("Edad:"));
        add(campoEdad);
        add(new JLabel("Teléfono:"));
        add(campoTelefono);
        add(masJovenLabel);
        mensajeError.setVisible(false);
        mensajeError.setForeground(Color.RED);
        add(mensajeError);
        JButton btnAniadir = new JButton("Añadir");
        btnAniadir.addActionListener(new Principal());
        add(btnAniadir);
        
    }
}
