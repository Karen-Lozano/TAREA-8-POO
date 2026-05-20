public class Estudiante extends Persona {

    private String carrera;

    public Estudiante(String cedula, String nombre, int edad, String carrera) {
        super(cedula, nombre, edad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // Sobrescritura
    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() +
                "\nCarrera: " + carrera +
                "\nTipo: Estudiante";
    }
}