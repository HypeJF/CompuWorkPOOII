package com.ecodeup.jdbc.poofx;

public class Empleado {
    protected String nombreEmpleado;
    protected int idEmpleado;
    protected String emailEmpleado;
    protected int valoracion;
    protected boolean temporal;

    //constructor
    public Empleado(String nombreEmpleado, int idEmpleado, String emailEmpleado, int valoracion, boolean temporal) {
        this.nombreEmpleado = nombreEmpleado;
        this.idEmpleado = idEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.valoracion = valoracion;
        this.temporal = false;
    }

    //getters/setters
    public String getNombreEmpleado() {return nombreEmpleado;}
    public int getIdEmpleado() {return idEmpleado;}
    public String getEmailEmpleado() {return emailEmpleado;}
    public int getValoracion() {return valoracion;}

    public void setNombreEmpleado(String nombreEmpleado) {this.nombreEmpleado = nombreEmpleado;}
    public void setEmailEmpleado(String emailEmpleado) {this.emailEmpleado = emailEmpleado;}
    public void setValoracion(int valoracion) {this.valoracion = valoracion;}
}
