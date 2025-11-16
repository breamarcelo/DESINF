import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiJPanel extends JPanel{
    boolean validado;
    JTextField campoNombre = new JTextField();
    JTextField campoApellidos = new JTextField();
    JTextField campoEmail = new JTextField();
    JTextField campoEdad = new JTextField();
    JTextField campoTelefono = new JTextField();
    JLabel mensajeErrorEdad = new JLabel();
    JLabel mensajeError = new JLabel();
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
        formulario.setLayout(new GridLayout(14, 1));
        formulario.add(new JLabel("Nombre:"));
        formulario.add(campoNombre);
        formulario.add(new JLabel("Apellidos:"));
        formulario.add(campoApellidos);
        formulario.add(new JLabel("Email:"));
        formulario.add(campoEmail);
        formulario.add(mensajeErrorEdad);
        mensajeErrorEdad.setForeground(Color.RED);
        mensajeErrorEdad.setVisible(false);
        formulario.add(new JLabel("Edad:"));
        formulario.add(campoEdad);
        formulario.add(new JLabel("Teléfono:"));
        formulario.add(campoTelefono);
        formulario.add(masJovenLabel);
        mensajeError.setForeground(Color.RED);
        mensajeError.setVisible(false);
        formulario.add(mensajeError);
        JButton btnAniadir = new JButton("Añadir");
        btnAniadir.setForeground(Color.WHITE);
        btnAniadir.setBorder(null);
        btnAniadir.setOpaque(true);
        btnAniadir.setBackground(new Color(37,43,87));
        btnAniadir.addActionListener(new Validar());
        formulario.add(btnAniadir);
    }

    public void validarCampo(JTextField campo) {
        if(campo.getText().isBlank()){
            this.validado = false;
        } else {
            this.validado = true;
        }
        System.out.println(validado);
    }

    public class Validar implements ActionListener {
        Alumno[] listaAlumnos = new Principal().getListaAlumnos();

        @Override
        public void actionPerformed(ActionEvent e) {
            validarCampo(campoNombre);
            validarCampo(campoApellidos);
            validarCampo(campoEmail);
            validarCampo(campoEdad);
            validarCampo(campoTelefono);

            if(!validado){
                System.out.println("debe rrellenar todo");
            } else if(listaAlumnos[listaAlumnos.length-1] == null){
                int i = 0;
                while(listaAlumnos[i] != null){
                    i++;
                }
                String nombre = campoNombre.getText();
                String apellidos = campoApellidos.getText();
                String email = campoEmail.getText();
                int edad = Integer.parseInt(campoEdad.getText());
                String telefono = campoTelefono.getText();
                Alumno nuevoAlumno = new Alumno(nombre, apellidos, email, edad, telefono);
                listaAlumnos[i] = nuevoAlumno;
                campoNombre.setText("");
                campoApellidos.setText("");
                campoEmail.setText("");
                campoEdad.setText("");
                campoTelefono.setText("");
                
                encontrarMasJoven();
            } else {
                mensajeError.setText("No se pueden alamacenar más alumnos.");
                mensajeError.setVisible(true);
            }
            
            for(Alumno a : listaAlumnos){
                if(a != null){
                    System.out.println(a.toString());
                }
            }
        }

        public void encontrarMasJoven() {
            for(int i=0; i<listaAlumnos.length; i++){
                if(listaAlumnos[i] != null){
                    for(int j=i+1; j<listaAlumnos.length; j++){
                        if(listaAlumnos[j] != null) {
                            if(listaAlumnos[j].getEdad() > listaAlumnos[i].getEdad()){
                                masJovenLabel.setText("Alumno más joven: " + listaAlumnos[i].getNombre() + " " + listaAlumnos[i].getApellidos());
                            } else if(listaAlumnos[j].getEdad() < listaAlumnos[i].getEdad()){
                                masJovenLabel.setText("Alumno más joven: " + listaAlumnos[j].getNombre() + " " + listaAlumnos[j].getApellidos());
                            }
                        } 
                    }
                }
            }
        }
    }

    
    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public void setCampoNombre(JTextField campoNombre) {
        this.campoNombre = campoNombre;
    }

    public JTextField getCampoApellidos() {
        return campoApellidos;
    }

    public void setCampoApellidos(JTextField campoApellidos) {
        this.campoApellidos = campoApellidos;
    }

    public JTextField getCampoEmail() {
        return campoEmail;
    }

    public void setCampoEmail(JTextField campoEmail) {
        this.campoEmail = campoEmail;
    }

    public JTextField getCampoEdad() {
        return campoEdad;
    }

    public void setCampoEdad(JTextField campoEdad) {
        this.campoEdad = campoEdad;
    }

    public JTextField getCampoTelefono() {
        return campoTelefono;
    }

    public void setCampoTelefono(JTextField campoTelefono) {
        this.campoTelefono = campoTelefono;
    }

    public JLabel getMensajeErrorEdad() {
        return mensajeErrorEdad;
    }

    public void setMensajeErrorEdad(JLabel mensajeErrorEdad) {
        this.mensajeErrorEdad = mensajeErrorEdad;
    }

    public JLabel getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(JLabel mensajeError) {
        this.mensajeError = mensajeError;
    }

    public JLabel getMasJovenLabel() {
        return masJovenLabel;
    }

    public void setMasJovenLabel(JLabel masJovenLabel) {
        this.masJovenLabel = masJovenLabel;
    }
}
