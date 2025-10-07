package com.ecodeup.jdbc.poofx;

import java.util.ArrayList;
import java.util.Scanner;

//Clase Departamento

public class Departamento {
    private String nombreDepartamento;
    private int idDepartamento;
    private ArrayList<Empleado> empleados;
    private int valoracionDpto;


    public Departamento(String nombreDepartamento, int idDepartamento, int valoracionDpto) {
        this.nombreDepartamento = nombreDepartamento;
        this.idDepartamento = idDepartamento;
        this.empleados = new ArrayList<>();
        this.valoracionDpto = valoracionDpto;
    }

    //getters/setters
    public String getNombreDepartamento() {return nombreDepartamento;}
    public int getIdDepartamento() {return idDepartamento;}
    public int getValoracionDpto() {return valoracionDpto;}
    public ArrayList<Empleado> getEmpleados() {return empleados;}

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;}
    public void setValoracionDpto(int valoracionDpto) {this.valoracionDpto = valoracionDpto;}

}

