import java.util.ArrayList;
import java.util.Scanner;

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
    public void setIdDepartamento(int idDepartamento) {this.idDepartamento = idDepartamento;}
    public void setValoracionDpto(int valoracionDpto) {this.valoracionDpto = valoracionDpto;}

    //metodos



    public void agregarEmpleado(Scanner sc, GestionEmpresarial empresa) {
        System.out.println("Ingrese el nombre del empleado: ");
        String nombreEmpleado = sc.nextLine();

        int idEmpleado = 0;
        //verificar si id está repetido en otro departamento
        while(true){
            System.out.println("Ingrese el id del empleado: ");
            idEmpleado = sc.nextInt();
            sc.nextLine(); //limpia-buffer
            if (empresa.empleadoConId(idEmpleado)){
                System.out.println("El ID ya está registrado en la empresa");
            } else {
                break;
            }
        }


        System.out.println("Ingrese el email del empleado: ");
        String email = sc.nextLine();

        System.out.println("¿El empleado es temporal o permanente? (T/P)");
        String tipo = sc.nextLine();

        System.out.println("Ingrese la valoracion del empleado: (1-10)");
        int valoracion = sc.nextInt();
        if (valoracion < 1 || valoracion > 10) {
            System.out.println("El valoracion del empleado no es valido");
            return;
        }
        if(nombreEmpleado!=null && idEmpleado!=0 && email!=null && tipo!=null) {
            Empleado e;
            if(tipo.equalsIgnoreCase("T")) {
                e = new EmpleadoTemporal(nombreEmpleado, idEmpleado, email, valoracion);
            } else {
                e = new EmpleadoPermanente(nombreEmpleado, idEmpleado, email, valoracion);
            }
            empleados.add(e);
        }
        System.out.println("Empleado agregado al departamento "+ nombreDepartamento);
    }

    public void modificarEmpleado(Scanner sc, GestionEmpresarial empresa) {
        System.out.println("Ingrese el ID del empleado a modificar");
        int idEmpleado = sc.nextInt();
        sc.nextLine(); //limpia-buffer

        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado() == idEmpleado) {
                System.out.println("Ingrese el nuevo nombre del empleado: ");
                String nombreEmpleado = sc.nextLine();
                empleado.setNombreEmpleado(nombreEmpleado);
                System.out.println("Ingrese nuevo correo del empleado: ");
                String correo = sc.nextLine();
                empleado.setEmailEmpleado(correo);
                System.out.println("Ingrese nueva valoracion del empleado: ");
                int valoracion = sc.nextInt();
                sc.nextLine(); //limpia-buffer
                empleado.setValoracion(valoracion);
                System.out.println("¿Desea cambiar el empleado de Departamento? (S/N)");
                String cambiar = sc.nextLine();
                if (cambiar.equalsIgnoreCase("S")) {
                    int id = empleado.getIdEmpleado();
                    empresa.cambiarEmpleadoDepartamento(sc,id);

                }
                System.out.println("Empleado actualizado");
                return;
            }
        }
        System.out.println("Empleado con ID " + idEmpleado + " no existe");
    }

    public void eliminarEmpleado(Scanner sc) {
        System.out.println("Ingrese el ID del empleado a eliminar");
        int idEmpleado = Integer.parseInt(sc.nextLine());
        for (Empleado empleado : empleados) {
            if (empleado.getIdEmpleado() == idEmpleado) {
                empleados.remove(empleado);
                System.out.println("Empleado eliminado");
                return;
            }
        }
        System.out.println("Empleado con ID " + idEmpleado + " no existe");
    }


    public void mostrarEmpleados() {
        String temp = "No Asignado";
        System.out.println("Empleados en el departamento: " + nombreDepartamento + ": ");
        if(empleados.isEmpty()) {
            System.out.println("(sin empleados)");
        } else {
            for(Empleado empleado : empleados) {
                if (empleado instanceof EmpleadoTemporal) {
                    temp= "Temporal";
                } else if (empleado instanceof EmpleadoPermanente) {
                    temp= "Permanente";
                }
                System.out.println("-ID: "+empleado.getIdEmpleado() + " | Nombre: " + empleado.getNombreEmpleado()+" | Email:"+ empleado.getEmailEmpleado() + " | " + temp);
            }
        }
    }

    public Empleado buscarEmpleadoPorId(int id){
        for(Empleado empleado : empleados) {
            if(empleado.getIdEmpleado() == id) {
                return empleado;
            }
        }
        return null;
    }
}

