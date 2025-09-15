public class Empleado {
    protected String nombreEmpleado;
    protected int idEmpleado;
    protected String emailEmpleado;
    protected int valoracion;

    //constructor
    public Empleado(String nombreEmpleado, int idEmpleado, String emailEmpleado, int valoracion) {
        this.nombreEmpleado = nombreEmpleado;
        this.idEmpleado = idEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.valoracion = valoracion;
    }

    //getters/setters
    public String getNombreEmpleado() {return nombreEmpleado;}
    public int getIdEmpleado() {return idEmpleado;}
    public String getEmailEmpleado() {return emailEmpleado;}
    public int getValoracion() {return valoracion;}

    public void setNombreEmpleado(String nombreEmpleado) {this.nombreEmpleado = nombreEmpleado;}
    public void setIdEmpleado(int idEmpleado) {this.idEmpleado = idEmpleado;}
    public void setEmailEmpleado(String emailEmpleado) {this.emailEmpleado = emailEmpleado;}
    public void setValoracion(int valoracion) {this.valoracion = valoracion;}

    @Override
    public String toString() {
        return "Empleado{" + "nombreEmpleado=" + nombreEmpleado + ", idEmpleado=" + idEmpleado + ", emailEmpleado=" + emailEmpleado + '}';
    }
}
