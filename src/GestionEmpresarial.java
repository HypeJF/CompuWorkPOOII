import java.util.ArrayList;
import java.util.Scanner;

public class GestionEmpresarial {
    private String nombreEmpresa;
    private ArrayList<Departamento> departamentos;

    public GestionEmpresarial(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Scanner sc) {
        System.out.println("Ingrese el nombre del departamento: ");
        String nombreDepartamento = sc.nextLine();

        System.out.println("Ingrese el id del departamento: ");
        int idDepartamento = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese el valoracion del departamento: ");
        int valoracion = Integer.parseInt(sc.nextLine());

        if(nombreDepartamento!=null && idDepartamento!=0 && valoracion!=0) {
            Departamento d = new Departamento(nombreDepartamento, idDepartamento, valoracion);
            departamentos.add(d);
        } else {
            System.out.println("Error. Ingrese la informacion correcta");
            return;
        }

        System.out.println("Departamento creado exitosamente");
    }

    public void modificarDepartamento(Scanner sc) {
        System.out.println("Ingrese el ID del departamento a modificar: ");
        int id = sc.nextInt();
        sc.nextLine(); //limpia-buffer

        for(Departamento d : departamentos) {
            if(d.getIdDepartamento()== id){
                System.out.println("Ingrese el nuevo nombre del departamento: ");
                String nombreDepartamento = sc.nextLine();
                d.setNombreDepartamento(nombreDepartamento);
                System.out.println("Ingrese la nueva valoracion del departamento: ");
                int valoracion = Integer.parseInt(sc.nextLine());
                d.setValoracionDpto(valoracion);
                System.out.println("Departamento modificado exitosamente");
                return;
            }
        }

    }

    public void eliminarDepartamento(Scanner sc) {
        System.out.println("Ingrese el ID del departamento a eliminar: ");
        int id = sc.nextInt();

        boolean eliminado = departamentos.removeIf(departamento -> departamento.getIdDepartamento() == id);
        if(eliminado){
            System.out.println("Departamento eliminado exitosamente");
        } else {
            System.out.println("Departamento con ID " + id + " no encontrado");
        }
    }

    public void mostrarDepartamentos() {
        System.out.println("Departamentos en la empresa " + this.nombreEmpresa + ": ");
        for (Departamento departamento : this.departamentos) {
            System.out.println("- " + departamento.getIdDepartamento() + " | " + departamento.getNombreDepartamento());

        }
    }

    public Departamento buscarDepartamentoPorId(int id) {
        for (Departamento departamento : departamentos) {
            if (departamento.getIdDepartamento() == id) return departamento;
        }
        return null;
    }

    public void generarReporteEmpleado(Scanner sc) {
        System.out.println("Ingrese el ID del departamento: ");
        int idDpto = sc.nextInt();
        Departamento depto = buscarDepartamentoPorId(idDpto);

        if (depto == null) {
            System.out.println("Departamento no encontrado");
            return;
        }

        System.out.println("Ingrese el ID del empleado: ");
        int idEmp = sc.nextInt();
        Empleado empleado = depto.buscarEmpleadoPorId(idEmp);
        if (empleado == null) {
            System.out.println("Empleado no encontrado");
            return;
        }

        ReporteDesempeño reporte = new ReporteDesempeño(empleado, depto);
        reporte.generarReporteEmpleado();
    }

    public void generarReporteDepartamento(Scanner sc) {
        System.out.println("Ingrese el ID del departamento: ");
        int idDpto = sc.nextInt();
        Departamento depto = buscarDepartamentoPorId(idDpto);
        if (depto == null) {
            System.out.println("Departamento no encontrado");
            return;
        }

        ReporteDesempeño reporte = new ReporteDesempeño(depto);
        reporte.generarReporteDepartamento();
    }
}
