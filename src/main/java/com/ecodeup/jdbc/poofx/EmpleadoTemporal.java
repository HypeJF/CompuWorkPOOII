package com.ecodeup.jdbc.poofx;

public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String nombreEmpleado, int idEmpleado, String emailEmpleado, int valoracion) {
        super(nombreEmpleado,idEmpleado,emailEmpleado, valoracion, true);
    }

}

