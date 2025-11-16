

public class Principal {
    static Alumno[] listaAlumnos = new Alumno[5]; 
    public static void main(String[] args) throws Exception {
        MiJFrame miJFrame = new MiJFrame();
    }

    public static Alumno[] getListaAlumnos() {
        return listaAlumnos;
    }

    public static void setListaAlumnos(Alumno[] listaAlumnos) {
        Principal.listaAlumnos = listaAlumnos;
    }    
}
