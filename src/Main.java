import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Departamento de prueba
        GestionEmpresarial empresa = new GestionEmpresarial("CompuWork");
        Scanner sc = new Scanner(System.in);
        int option = 1;
        do{
            System.out.println("---Programa de Gestión Empresarial---");
            System.out.println("Seleccione una opción disponible: ");
            System.out.println("1.Empleados");
            System.out.println("2.Departamentos");
            System.out.println("3.Reportes");
            System.out.println("4.Salir");
            option = sc.nextInt();
            sc.nextLine(); //limpia-buffer
            switch(option) {
                case 1:
                    System.out.println("---Empleados---");
                    System.out.println("Escoge una opcion: ");
                    System.out.println("1.Agregar Empleado");
                    System.out.println("2.Modificar Empleado");
                    System.out.println("3.Eliminar Empleado");
                    int opcionEmpleado = sc.nextInt();
                    switch(opcionEmpleado) {
                        case 1:
                            System.out.println("Agregar Empleado");
                            System.out.println("Ingrese ID del departamento: ");
                            int idDepartamento = sc.nextInt();
                            sc.nextLine(); //limpia-buffer
                            Departamento depto = empresa.buscarDepartamentoPorId(idDepartamento);
                            if(depto != null) {
                                depto.agregarEmpleado(sc, empresa);
                            } else {
                                System.out.println("Departamento no encontrado");
                            }
                            break;
                        case 2:
                            System.out.println("Modificar Empleado por ID");
                            System.out.println("Ingrese ID del departamento: ");
                            int idDepartamento2 = sc.nextInt();
                            sc.nextLine(); //limpia-buffer
                            Departamento depto2 = empresa.buscarDepartamentoPorId(idDepartamento2);
                            if(depto2 != null) {
                                depto2.modificarEmpleado(sc, empresa);
                            } else {
                                System.out.println("Departamento no encontrado");
                            }
                            break;
                        case 3:
                            System.out.println("Eliminar Empleado por ID");
                            System.out.println("Ingrese ID del departamento: ");
                            int idDepartamento3 = sc.nextInt();
                            sc.nextLine(); //limpia-buffer
                            Departamento depto3 = empresa.buscarDepartamentoPorId(idDepartamento3);
                            if(depto3 != null) {
                                depto3.eliminarEmpleado(sc);
                            } else {
                                System.out.println("Departamento no encontrado");
                            }
                            break;
                            default:
                                System.out.println("Opcion no valida");
                    }
                    break;
                case 2:
                    System.out.println("---Departamentos---");
                    System.out.println("Escoge una opcion: ");
                    System.out.println("1.Agregar Departamento");
                    System.out.println("2.Modificar Departamento");
                    System.out.println("3.Eliminar Departamento");
                    System.out.println("4.Ver Empleados del Departamento");
                    int opcionDepartamento = sc.nextInt();
                    sc.nextLine(); //limpia-buffer
                    switch(opcionDepartamento) {
                        case 1:
                            System.out.println("Agregar Departamento");
                            empresa.agregarDepartamento(sc);
                            break;
                        case 2:
                            System.out.println("Modificar Departamento");
                            empresa.modificarDepartamento(sc);
                            break;
                        case 3:
                            System.out.println("Eliminar Departamento");
                            empresa.eliminarDepartamento(sc);
                            break;
                        case 4:
                            System.out.println("Ver Empleados del Departamento");
                            System.out.println("Ingrese ID del departamento: ");
                            int idDepartamento = sc.nextInt();
                            sc.nextLine(); //limpia-buffer
                            Departamento depto = empresa.buscarDepartamentoPorId(idDepartamento);
                            if(depto != null) {
                                depto.mostrarEmpleados();
                            } else {
                                System.out.println("Departamento no encontrado");
                            }
                            break;
                            default:
                                System.out.println("Opcion no valida");
                    }
                    break;
                case 3:
                    System.out.println("---Reportes---");
                    System.out.println("Escoge una opcion: ");
                    System.out.println("1.Generar Reporte de Empleado");
                    System.out.println("2.Generar Reporte de Departamento");
                    int opcionReporte = sc.nextInt();
                    switch (opcionReporte){
                        case 1:
                            System.out.println("Generar Reporte de Empleado");
                            empresa.generarReporteEmpleado(sc);
                            break;
                        case 2:
                            System.out.println("Generar Reporte de Departamento");
                            empresa.generarReporteDepartamento(sc);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option!=0);
    }
}