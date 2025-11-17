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
    boolean[] campoValidado = new boolean[5];
    boolean formularioValidado;
    JTextField campoNombre = new JTextField();
    JTextField campoApellidos = new JTextField();
    JTextField campoEmail = new JTextField();
    JTextField campoEdad = new JTextField();
    JTextField campoTelefono = new JTextField();
    JLabel mensajeErrorNombre = new JLabel();
    JLabel mensajeErrorApellidos = new JLabel();
    JLabel mensajeErrorEdad = new JLabel();
    JLabel mensajeErrorEmail = new JLabel();
    JLabel mensajeErrorTelefono = new JLabel();
    JLabel mensajeErrorLleno = new JLabel();
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
        formulario.setLayout(new GridLayout(18, 1));
        formulario.add(mensajeErrorNombre);
        mensajeErrorNombre.setForeground(Color.RED);
        mensajeErrorNombre.setVisible(false);
        formulario.add(new JLabel("Nombre:"));
        formulario.add(campoNombre);
        formulario.add(mensajeErrorApellidos);
        mensajeErrorApellidos.setForeground(Color.RED);
        mensajeErrorApellidos.setVisible(false);
        formulario.add(new JLabel("Apellidos:"));
        formulario.add(campoApellidos);
        formulario.add(mensajeErrorEmail);
        mensajeErrorEmail.setForeground(Color.RED);
        mensajeErrorEmail.setVisible(false);
        formulario.add(new JLabel("Email:"));
        formulario.add(campoEmail);
        formulario.add(mensajeErrorEdad);
        mensajeErrorEdad.setForeground(Color.RED);
        mensajeErrorEdad.setVisible(false);
        formulario.add(new JLabel("Edad:"));
        formulario.add(campoEdad);
        formulario.add(mensajeErrorTelefono);
        mensajeErrorTelefono.setForeground(Color.RED);
        mensajeErrorTelefono.setVisible(false);
        formulario.add(new JLabel("Teléfono:"));
        formulario.add(campoTelefono);
        formulario.add(masJovenLabel);
        mensajeErrorLleno.setForeground(Color.RED);
        mensajeErrorLleno.setVisible(false);
        formulario.add(mensajeErrorLleno);
        JButton btnAniadir = new JButton("Añadir");
        btnAniadir.setForeground(Color.WHITE);
        btnAniadir.setBorder(null);
        btnAniadir.setOpaque(true);
        btnAniadir.setBackground(new Color(37,43,87));
        btnAniadir.addActionListener(new Validar());
        formulario.add(btnAniadir);
    }

    public void validarCampo(JTextField campo, JLabel etiqueta, int indice) {
        this.campoValidado[indice] = false;
        if(campo.getText().isBlank()){
            etiqueta.setText("Este campo es obligatorio");
            etiqueta.setVisible(true);
        } else if(etiqueta == mensajeErrorEdad && !campo.getText().matches("\\d+")){
            etiqueta.setText("Introduce un valor numérico");
            etiqueta.setVisible(true);
        } else if(etiqueta == mensajeErrorTelefono && !campo.getText().matches("\\d+")){
            etiqueta.setText("Introduce un valor numérico");
            etiqueta.setVisible(true);
        } else if(etiqueta == mensajeErrorEmail && !campo.getText().matches("^[A-Za-z0-9.-_]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}")){
            etiqueta.setText("El formato del email no es válido");
            etiqueta.setVisible(true);
        } else {
            etiqueta.setVisible(false);
            this.campoValidado[indice] = true;
        }
    }
    
    public class Validar implements ActionListener {
        Alumno[] listaAlumnos = new Principal().getListaAlumnos();
        
        @Override
        public void actionPerformed(ActionEvent e) {
            validarCampo(campoNombre, mensajeErrorNombre, 0);
            validarCampo(campoApellidos, mensajeErrorApellidos, 1);
            validarCampo(campoEmail, mensajeErrorEmail, 2);
            validarCampo(campoEdad, mensajeErrorEdad, 3);
            validarCampo(campoTelefono, mensajeErrorTelefono, 4);
            formularioValidado = true;
            for(boolean v : campoValidado){
                if(!v) {
                    formularioValidado = false;
                }
            }

            if(formularioValidado){
                if(listaAlumnos[listaAlumnos.length-1] == null){
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
                    mensajeErrorLleno.setText("No se pueden alamacenar más alumnos.");
                    mensajeErrorLleno.setVisible(true);
                }
            }
        }

        public void encontrarMasJoven() {
            int edadMasJoven = listaAlumnos[0].getEdad();
            int indiceMasJoven = 0;
            for(int i=0; i<listaAlumnos.length; i++){
                if(listaAlumnos[i] != null){
                    for(int j=i+1; j<listaAlumnos.length; j++){
                        if(listaAlumnos[j] != null) {
                            if(listaAlumnos[j].getEdad() < edadMasJoven){
                                edadMasJoven = listaAlumnos[j].getEdad();
                                indiceMasJoven = j;
                            }
                        } 
                    }
                } 
            }
            masJovenLabel.setText("Alumno más joven: " + listaAlumnos[indiceMasJoven].getNombre() + " " + listaAlumnos[indiceMasJoven].getApellidos());
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

    public JLabel getMasJovenLabel() {
        return masJovenLabel;
    }

    public void setMasJovenLabel(JLabel masJovenLabel) {
        this.masJovenLabel = masJovenLabel;
    }
}
