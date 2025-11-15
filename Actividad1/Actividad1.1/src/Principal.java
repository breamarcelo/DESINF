
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal implements ActionListener {
    static Alumno[] listaAlumnos = new Alumno[5];    
    static MiJFrame miJFrame = new MiJFrame();
    public static void main(String[] args) throws Exception {}

    @Override
    public void actionPerformed(ActionEvent e) {
        // validación
        if(listaAlumnos[listaAlumnos.length-1] == null){
            int i = 0;
            while(listaAlumnos[i] != null){
                i++;
            }
            String nombre = miJFrame.miJPanel.campoNombre.getText();
            String apellidos = miJFrame.miJPanel.campoApellidos.getText();
            String email = miJFrame.miJPanel.campoEmail.getText();
            int edad = Integer.parseInt(miJFrame.miJPanel.campoEdad.getText());
            String telefono = miJFrame.miJPanel.campoTelefono.getText();
            Alumno nuevoAlumno = new Alumno(nombre, apellidos, email, edad, telefono);
            listaAlumnos[i] = nuevoAlumno;
            miJFrame.miJPanel.campoNombre.setText("");
            miJFrame.miJPanel.campoApellidos.setText("");
            miJFrame.miJPanel.campoEmail.setText("");
            miJFrame.miJPanel.campoEdad.setText("");
            miJFrame.miJPanel.campoTelefono.setText("");
            
            encontrarMasJoven();
        } else {
            miJFrame.miJPanel.mensajeError.setText("No se pueden alamacenar más alumnos.");
            miJFrame.miJPanel.mensajeError.setVisible(true);
        }
    }
    
    public void encontrarMasJoven() {
        for(int i=0; i<listaAlumnos.length; i++){
            if(listaAlumnos[i] != null){
                for(int j=i+1; j<listaAlumnos.length; j++){
                    if(listaAlumnos[j] != null) {
                        if(listaAlumnos[j].getEdad() > listaAlumnos[i].getEdad()){
                            miJFrame.miJPanel.masJovenLabel.setText("Alumno más joven: " + listaAlumnos[i].getNombre() + " " + listaAlumnos[i].getApellidos());
                        } else if(listaAlumnos[j].getEdad() < listaAlumnos[i].getEdad()){
                            miJFrame.miJPanel.masJovenLabel.setText("Alumno más joven: " + listaAlumnos[j].getNombre() + " " + listaAlumnos[j].getApellidos());
                        }
                    } 
                }
            }
        }
    }
}
