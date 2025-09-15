public class ReporteDesempeño {
    private Empleado empleado;
    private Departamento departamento;


    public ReporteDesempeño(Empleado empleado, Departamento departamento) {
        this.empleado = empleado;
        this.departamento = departamento;
    }

    //polimorfismo
    public ReporteDesempeño(Departamento departamento) {
        this.departamento = departamento;
    }

    public void generarReporteEmpleado() {
        if (empleado != null) {
            System.out.println("Reporte de desempeño para Empleado");
            System.out.println("Nombre del empleado: " + empleado.getNombreEmpleado());
            System.out.println("Id de empleado: " + empleado.getIdEmpleado());
            System.out.println("Email del empleado: " + empleado.getEmailEmpleado());
            System.out.println("Departamento: " + departamento.getNombreDepartamento());
            System.out.println("Valoracion del empleado (1-10): " + empleado.getValoracion());
        }

    }

    public void generarReporteDepartamento() {
        if (departamento != null) {
            System.out.println("Reporte de desempeño para Departamento");
            System.out.println("Nombre del departamento: " + departamento.getNombreDepartamento());
            System.out.println("Id de departamento: " + departamento.getIdDepartamento());
            System.out.println("Valoracion del departamento (1-10): " + departamento.getValoracionDpto());
        }
    }
}
