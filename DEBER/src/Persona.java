public class Persona {

    protected String cedula;
    protected String nombre;
    protected int edad;

    // Constructor
    public Persona(String cedula, String nombre, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Metodo para mostrar datos
    public String mostrarDatos() {
        return "Cedula: " + cedula +
                "\nNombre: " + nombre +
                "\nEdad: " + edad;
    }
}