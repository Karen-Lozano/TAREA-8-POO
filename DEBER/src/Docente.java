public class Docente extends Persona {

    private String asignatura;

    public Docente(String cedula, String nombre, int edad, String asignatura) {
        super(cedula, nombre, edad);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    // Sobrescritura
    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nAsignatura: " + asignatura +
                "\nTipo: Docente";
    }
}