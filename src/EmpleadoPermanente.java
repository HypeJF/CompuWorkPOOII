public class EmpleadoPermanente extends Empleado {

    public EmpleadoPermanente(String nombreEmpleado, int idEmpleado, String emailEmpleado, int valoracion) {
        super(nombreEmpleado,idEmpleado,emailEmpleado, valoracion);
    }

    @Override
    public String toString() {
        return "EmpleadoPermanente{" + "nombreEmpleado=" + nombreEmpleado + ", idEmpleado=" + idEmpleado + ", emailEmpleado=" + emailEmpleado + '}';
    }
}


