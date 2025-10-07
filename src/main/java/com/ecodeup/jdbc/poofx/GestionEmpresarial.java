package com.ecodeup.jdbc.poofx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestionEmpresarial {
    private static GestionEmpresarial instance;
    private String nombreEmpresa;
    private ArrayList<Departamento> departamentos;

    public GestionEmpresarial(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.departamentos = new ArrayList<>();
        //departamentos.add(new Departamento("Gerencia", 0, 10));
    }

    public static GestionEmpresarial getInstance() {
        if (instance == null) {
            instance = new GestionEmpresarial("CompuWork");
        } return instance;

    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public boolean agregarDepartamento(Departamento departamento) {
        int idDpto = departamento.getIdDepartamento();
        Departamento DptoExistente = buscarDepartamentoPorId(idDpto);
        if (DptoExistente != null) {
            return false;
        } else {
            departamentos.add(departamento);
        }
        System.out.println("Departamento " + departamento.getNombreDepartamento() + " agregado exitosamente");
        return true;
    }

    public boolean modificarDepartamento(int id, String nuevoNnombre, int nuevaValoracion) {
        Departamento dpto = buscarDepartamentoPorId(id);
        if(dpto != null) {
            dpto.setNombreDepartamento(nuevoNnombre);
            dpto.setValoracionDpto(nuevaValoracion);
            System.out.println("Departamento" + dpto.getNombreDepartamento() + " modificado exitosamente");
            return true;
        } else {
            return false;
        }

    }

    public boolean eliminarDepartamento(int id) {
        boolean eliminado = departamentos.removeIf(dpto -> dpto.getIdDepartamento() == id);
        System.out.println("Departamento eliminado");
        return eliminado;
    }

    public String mostrarDepartamentos() {
        if (departamentos.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Departamento dpto : departamentos) {
            sb.append("ID: " + dpto.getIdDepartamento())
                    .append(" | Nombre: " + dpto.getNombreDepartamento())
                    .append(" | Valoracion: " + dpto.getValoracionDpto())
                    .append("\n");
        }
        return sb.toString();
    }

    public String listarEmpleadosporDepartamento(int idDepartamento) {
        Departamento dpto = buscarDepartamentoPorId(idDepartamento);
        if (dpto != null && dpto.getEmpleados() != null) {

            return dpto.getEmpleados().stream()
                    .map(empleado -> "ID: " + empleado.getIdEmpleado() + " - Nombre: " + empleado.getNombreEmpleado() + " - Email: " + empleado.getEmailEmpleado())
                    .collect(Collectors.joining("\n"));
        }
        return "";
    }

    public Departamento buscarDepartamentoPorId(int id) {
        for (Departamento departamento : departamentos) {
            if (departamento.getIdDepartamento() == id) return departamento;
        }
        return null;
    }

    public boolean agregarEmpleadoGE(String nombreEmpleado, int idEmpleado, int idDpto, String email, int valoracion, boolean temporal) {
        Departamento departamento = buscarDepartamentoPorId(idDpto);
        Empleado existente = buscarEmpleadoPorId(idEmpleado);
        if(existente != null){
            return false;
        }
        if (departamento != null) {
            if (temporal) {
                Empleado nuevoEmpleado = new EmpleadoTemporal(nombreEmpleado, idEmpleado, email, valoracion);
                departamento.getEmpleados().add(nuevoEmpleado);
            } else {
                Empleado nuevoEmpleado = new EmpleadoPermanente(nombreEmpleado, idEmpleado, email, valoracion);
                departamento.getEmpleados().add(nuevoEmpleado);
            }
            System.out.println("Empleado agregado exitosamente");
            return true;
        }else{
            return false;
        }
    }

    public String modificarEmpleadoGE(String nombreEmpleado, String idEmpleado, String idDptoString, String email, String valoracion) {
        int idEmpleadoInt = Integer.parseInt(idEmpleado);
        Empleado empleado = buscarEmpleadoPorId(idEmpleadoInt);
        if (empleado == null) {
            return "Error. Empleado con ID: " + idEmpleado + " no existe";
        }

        if(!nombreEmpleado.isEmpty()){
            empleado.setNombreEmpleado(nombreEmpleado);
            System.out.println("Nombre de empleado modificado");
        }
        if(!email.isEmpty()){
            empleado.setEmailEmpleado(email);
            System.out.println("Email de empleado modificado");
        }
        if (!valoracion.isEmpty()) {
            try{
                int nuevaValoracion = Integer.parseInt(valoracion);
                if(nuevaValoracion >= 0 && nuevaValoracion <= 10){
                    empleado.setValoracion(nuevaValoracion);
                    System.out.println("Valoracion de empleado modificado");
                } else {
                    return "Error. Valoracion invalida";
                }
            }catch(NumberFormatException e){
                return "Error. Valoracion invalida. Debe ser un numero entero";
            }
        }
        /*esta parte tocó limpiarla, casi que no encuentro que este String tenia espacios en
        blanco, perdí basicamente una hora tratando de resolver una jodida excepción
        */
        idDptoString = idDptoString.trim();
        if (!idDptoString.isEmpty()){
            try{
                int idDpto = Integer.parseInt(idDptoString);
                boolean cambioDpto = cambiarEmpleadoDepartamento(empleado, idDpto);
                if(cambioDpto) {
                    return "Empleado con ID: " + idEmpleado + " desplazado al Departamento: "+ idDpto +" exitosamente";
                }

            }catch (NumberFormatException e) {
                return "Error. La ID del departamento debe ser un número entero.";
            }
        }
        return "Empleado modificado exitosamente";
    }

    public String eliminarEmpleado(String idEmpleado) {
        int idEmpleadoInt = Integer.parseInt(idEmpleado);
        Empleado empleado = buscarEmpleadoPorId(idEmpleadoInt);
        if (empleado == null) {
            return "Error. Empleado con ID: " + idEmpleado + " no existe";
        }
        try{
            boolean eliminado = false;
            for (Departamento departamento : departamentos) {
                if (departamento.getEmpleados() != null) {
                    eliminado = departamento.getEmpleados().removeIf(e->e.getIdEmpleado() == idEmpleadoInt);
                    if (eliminado) {
                        return "Empleado eliminado exitosamente";
                    }
                }
            }
        }catch (NullPointerException e){
            return "Error. Empleado con ID: " + idEmpleado + " no existe";
        }
        return "Empleado no encontrado";
    }

    public String generarReporteEmpleado(int idEmp) {
        Empleado empleado = buscarEmpleadoPorId(idEmp);
        Departamento departamentoEmpleado = buscarDepartamentoDeEmpleado(idEmp);
        if (empleado == null) {
            System.out.println("Empleado no encontrado");
            return "Error. Empleado con ID: " + idEmp + " no encontrado";
        }
        if (departamentoEmpleado == null) {
            return "Error. El departamento del empleado no existe.";
        }
        String temporal = "Si";
        if (empleado instanceof EmpleadoPermanente) {
            temporal = "No. Empleado Permanente";
        }
        String reporte = String.format(
                "Reporte de Empleado: %s. ID: %d.\n"+
                "Departamento: %s\n"+
                "Valoración: %d.\n"+
                "Temporal: %s.\n"+
                "El empleado hace parte de la empresa CompuWork",
                empleado.getNombreEmpleado(),
                empleado.getIdEmpleado(),
                departamentoEmpleado.getNombreDepartamento(),
                empleado.getValoracion(),
                temporal);
        System.out.println("Reporte generado exitosamente");
        return reporte;
    }

    public String generarReporteDepartamento(int idDpto) {
        Departamento depto = buscarDepartamentoPorId(idDpto);
        if (depto == null) {
            return "Error. Departamento con ID: " + idDpto + " no encontrado";
        }
        String lista = listarEmpleadosporDepartamento(idDpto);

        //Reporte de Departamento. (no sabia como usar esto)
        String reporte = String.format(
                "Reporte de Departamento: %s. ID: %d.\n"+
                "Valoración: %d.\n"+
                "Los empleados del Departamento son:\n%s",
                depto.getNombreDepartamento(),
                depto.getIdDepartamento(),
                depto.getValoracionDpto(),
                lista.isEmpty() ? " (No hay empelados) ": lista);
        System.out.println("Reporte generado exitosamente");
        return reporte;
    }


    public Empleado buscarEmpleadoPorId(int idEmpleado) {
        for (Departamento d : departamentos) {
            for (Empleado e : d.getEmpleados()) {
                if (e.getIdEmpleado() == idEmpleado) {
                    return e;
                }
            }
        } return null;
    }

    public boolean cambiarEmpleadoDepartamento(Empleado empleado, int idDepartamento) {
        Departamento destino = buscarDepartamentoPorId(idDepartamento);
        if (destino == null) {
            System.out.println("Departamento no encontrado");
            return false;
        }
        boolean removidoOrigen = false;
        for (Departamento d : departamentos) {
            if (d.getEmpleados() != null) {
                boolean removido = d.getEmpleados().removeIf(e->e.getIdEmpleado()== e.getIdEmpleado());
                if (removido) {
                    removidoOrigen = true;
                    break;
                }
            }
        }
        if (removidoOrigen) {
            destino.getEmpleados().add(empleado);
            System.out.println("Empleado desplazado exitosamente a: " + destino.getNombreDepartamento());
            return true;
        }else
            return false;
    }

    public Departamento buscarDepartamentoDeEmpleado(int idEmpleado){
        for (Departamento d : departamentos) {
            List<Empleado> empleados = d.getEmpleados();
            if(empleados != null) {
                boolean encontrado = empleados.stream().anyMatch(e->e.getIdEmpleado() == idEmpleado);
                if (encontrado) {
                    System.out.println("Empleado encontrado en el Departamento: " + d.getNombreDepartamento());
                    return d;
                }
            }
        }
        return null;
    }
}
