public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String nombreEmpleado, int idEmpleado, String emailEmpleado, int valoracion) {
        super(nombreEmpleado,idEmpleado,emailEmpleado, valoracion);
    }

    @Override
    public String toString() {
        return "EmpleadoTemporal{" + "nombreEmpleado=" + nombreEmpleado + ", idEmpleado=" + idEmpleado + ", emailEmpleado=" + emailEmpleado + '}';
    }
}

