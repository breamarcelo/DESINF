import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("REGISTRO ALUMNOS");
        titulo.setForeground(Color.white);
        titulo.setFont(new Font(null, Font.BOLD, 20));
        this.setBackground(new Color(12, 78, 86));        
        this.add(titulo, BorderLayout.NORTH);
        JPanel formulario = new JPanel();
        this.add(formulario, BorderLayout.CENTER);
        formulario.setLayout(new GridLayout(13, 1));
        //setLayout(new GridLayout(13,1));
        formulario.add(new JLabel("Nombre:"));
        formulario.add(campoNombre);
        formulario.add(new JLabel("Apellidos:"));
        formulario.add(campoApellidos);
        formulario.add(new JLabel("Email:"));
        formulario.add(campoEmail);
        formulario.add(new JLabel("Edad:"));
        formulario.add(campoEdad);
        formulario.add(new JLabel("Teléfono:"));
        formulario.add(campoTelefono);
        formulario.add(masJovenLabel);
        mensajeError.setVisible(false);
        mensajeError.setForeground(Color.RED);
        formulario.add(mensajeError);
        JButton btnAniadir = new JButton("Añadir");
        btnAniadir.setForeground(Color.WHITE);
        btnAniadir.setBorder(null);
        btnAniadir.setOpaque(true);
        btnAniadir.setBackground(new Color(37,43,87));
        btnAniadir.addActionListener(new Principal());
        formulario.add(btnAniadir);
        
    }
}
