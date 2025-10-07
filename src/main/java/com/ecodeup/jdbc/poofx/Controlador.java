package com.ecodeup.jdbc.poofx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Controlador {

    //Esta es la clase Controlador, desde donde se manejan todos los accesos a los metodos en GestionEmpresarial



    //Accesos a ventanas
    @FXML
    public void Departamento(ActionEvent e) throws IOException {
        Parent dptoParent = FXMLLoader.load(getClass().getResource("/Departamento.fxml"));
        Scene dptoScene = new Scene(dptoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(dptoScene);
    }

    public void Empleado(ActionEvent e) throws IOException {
        Parent empleadoParent = FXMLLoader.load(getClass().getResource("/Empleado.fxml"));
        Scene empleadoScene = new Scene(empleadoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(empleadoScene);
    }

    public void Reportes(ActionEvent e) throws IOException {
        Parent reporteParent = FXMLLoader.load(getClass().getResource("/Reportes.fxml"));
        Scene reporteScene = new Scene(reporteParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(reporteScene);
    }

    //Accion para cerrar el programa y todas sus ventanas
    public void Salir(ActionEvent e) {
        Platform.exit();
        System.exit(0);
    }

    //Accion para retornar al menu principal
    public void Regresar(ActionEvent e) throws IOException {
        Parent regresarParent = FXMLLoader.load(getClass().getResource("/MainCompuWork.fxml"));
        Scene regresarScene = new Scene(regresarParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(regresarScene);
    }

    public void AgregarDepartamento(ActionEvent e) throws IOException {
        Parent agregarDepartamentoParent = FXMLLoader.load(getClass().getResource("/AgregarDepartamento.fxml"));
        Scene agregarDepartamentoScene = new Scene(agregarDepartamentoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(agregarDepartamentoScene);
    }

    public void ModificarDepartamento(ActionEvent e) throws IOException {
        Parent modificarDepartamentoParent = FXMLLoader.load(getClass().getResource("/ModificarDepartamento.fxml"));
        Scene modificarDepartamentoScene = new Scene(modificarDepartamentoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(modificarDepartamentoScene);
    }

    public void EliminarDepartamento(ActionEvent e) throws IOException {
        Parent eliminarDepartamentoParent = FXMLLoader.load(getClass().getResource("/EliminarDepartamento.fxml"));
        Scene eliminarDepartamentoScene = new Scene(eliminarDepartamentoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(eliminarDepartamentoScene);
    }

    public void ListaEmpleadosDepartamento(ActionEvent e) throws IOException {
        Parent listaParent = FXMLLoader.load(getClass().getResource("/ListaEmpleadosDeDepartamento.fxml"));
        Scene listaDepartamentoScene = new Scene(listaParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(listaDepartamentoScene);
    }

    public void AgregarEmpleado(ActionEvent e) throws IOException {
        Parent agregarEmpleadoParent = FXMLLoader.load(getClass().getResource("/AgregarEmpleado.fxml"));
        Scene agregarEmpleadoScene = new Scene(agregarEmpleadoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(agregarEmpleadoScene);
    }

    public void ModificarEmpleado(ActionEvent e) throws IOException {
        Parent modificarEmpleadoParent = FXMLLoader.load(getClass().getResource("/ModificarEmpleado.fxml"));
        Scene modificarEmpleadoScene = new Scene(modificarEmpleadoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(modificarEmpleadoScene);
    }

    public void EliminarEmpleado(ActionEvent e) throws IOException {
        Parent eliminarEmpleadoParent = FXMLLoader.load(getClass().getResource("/EliminarEmpleado.fxml"));
        Scene eliminarEmpleadoScene = new Scene(eliminarEmpleadoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(eliminarEmpleadoScene);
    }

    public void ReportesDepartamento(ActionEvent e) throws IOException {
        Parent reportesDepartamentoParent = FXMLLoader.load(getClass().getResource("/ReportesDepartamento.fxml"));
        Scene reportesDepartamentoScene = new Scene(reportesDepartamentoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(reportesDepartamentoScene);
    }

    public void ReportesEmpleado(ActionEvent e) throws IOException {
        Parent reportesEmpleadoParent = FXMLLoader.load(getClass().getResource("/ReportesEmpleado.fxml"));
        Scene reportesEmpleadoScene = new Scene(reportesEmpleadoParent);
        Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
        window.setScene(reportesEmpleadoScene);
    }



    //Metodos handle de vinculacion de campos de texto con metodos de lógica

    //Mostrar una ventana con una alerta
    private void mostrarAlerta(Alert.AlertType type, String titulo, String message ){
        Alert alert = new Alert(type);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    //AgregarDepartamento
        @FXML private TextField txtNombreDpto;
        @FXML private TextField txtIdDpto;
        @FXML private TextField txtValoracionDpto;

        private final GestionEmpresarial empresa = GestionEmpresarial.getInstance();

        @FXML
        public void handleAgregarDepartamento(ActionEvent e){
            try{
                String nombre = txtNombreDpto.getText();
                int id = Integer.parseInt(txtIdDpto.getText());
                int valoracion = Integer.parseInt(txtValoracionDpto.getText());

                if (nombre.trim().isEmpty() || id <= 0 || valoracion < 0 || valoracion > 10){
                    mostrarAlerta(Alert.AlertType.ERROR,"Error de Validación", "Asegurese de completar correctamente los campos");
                    return;
                }
                Departamento departamento = new Departamento(nombre, id, valoracion);

                boolean agregado = empresa.agregarDepartamento(departamento);

                if (agregado){
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "El departamento " + nombre + " ha sido agregado correctamente");
                    txtNombreDpto.clear();
                    txtIdDpto.clear();
                    txtValoracionDpto.clear();
                }else{
                    mostrarAlerta(Alert.AlertType.ERROR,"Error de Formato", "El departamento no pudo ser agregado. La ID: "+ id + " ya está ocupada");
                }

            }catch(NumberFormatException nfe){
                mostrarAlerta(Alert.AlertType.ERROR,"Error de Formato", "Verifique el ID y la Valoracion, deben ser enteros");

            }catch (Exception ex){
                mostrarAlerta(Alert.AlertType.ERROR, "Error General", "Ocurrió un error al guardar la información");
            }

        }
        //Iniciar sesion

        @FXML
        private TextField txtuserIniciar;
        @FXML
        private PasswordField txtpassIniciar;

    @FXML
        protected void handleLoginButtonAction(ActionEvent e) throws IOException {
            String username = txtuserIniciar.getText();
            String password = txtpassIniciar.getText();

        String VALID_PASS = "1234";
        String VALID_USER = "admin";
        if (username.equals(VALID_USER) && password.equals(VALID_PASS)) {
                Parent iniciarSesionParent = FXMLLoader.load(getClass().getResource("/MainCompuWork.fxml"));
                Scene iniciarSesion = new Scene(iniciarSesionParent);
                Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
                window.setScene(iniciarSesion);

            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Inicio de Sesión", "Usuario o contraseña incorrectos.");
            }

            txtpassIniciar.clear();
        }


        //Modificar Departamento
        @FXML private TextField txtIdModDpto;
        @FXML private TextField txtNombreModDpto;
        @FXML private TextField txtValoracionModDpto;

        public void handleModificarDepartamento(ActionEvent e){
            try{
                int id = Integer.parseInt(txtIdModDpto.getText());
                String nombre = txtNombreModDpto.getText();
                int valoracion = Integer.parseInt(txtValoracionModDpto.getText());

                if (nombre.trim().isEmpty() || id <= 0 || valoracion < 0 || valoracion > 10){
                    mostrarAlerta(Alert.AlertType.ERROR,"Error de Validación", "Asegurese de completar correctamente los campos");
                    return;
                }
                boolean modificado = empresa.modificarDepartamento(id, nombre, valoracion);

                if (modificado){
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito",
                            "El departamento ID " + id + " ha sido modificado.");
                    txtNombreModDpto.clear();
                    txtIdModDpto.clear();
                    txtValoracionModDpto.clear();
                } else {
                    mostrarAlerta(Alert.AlertType.WARNING, "Advertencia",
                            "Departamento con ID " + id + " no encontrado.");
                }
            }catch(NumberFormatException nfe){
                mostrarAlerta(Alert.AlertType.ERROR,"Error de Formato", "Verifique el ID y la Valoracion, deben ser enteros");

            }catch (Exception ex){
                mostrarAlerta(Alert.AlertType.ERROR, "Error General", "Ocurrió un error al guardar la información");
            }
        }

        //Eliminar Departamento
        @FXML private TextField txtIdEliminarDpto;
        public void handleEliminarDepartamento(ActionEvent e){
            int id = Integer.parseInt(txtIdEliminarDpto.getText());
            if (id <= 0){
                mostrarAlerta(Alert.AlertType.ERROR,"Error de Validación", "Asegurese de completar correctamente los campos");
                return;
            }
            Alert confirmacion =  new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmacion");
            confirmacion.setHeaderText("Va a eliminar un departamento");
            confirmacion.setContentText("¿Está seguro? Esta acción no se puede deshacer");

            Optional<ButtonType> result = confirmacion.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                try {
                    boolean eliminado = empresa.eliminarDepartamento(id);
                    if (eliminado) {
                        mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito",
                                "El departamento ID " + id + " ha sido eliminado.");
                        txtIdEliminarDpto.clear();
                    } else {
                        mostrarAlerta(Alert.AlertType.WARNING, "Advertencia",
                                "Departamento con ID " + id + " no encontrado.");
                    }
                } catch (NumberFormatException nfe) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato", "Verifique el ID y la Valoracion, deben ser enteros");

                } catch (Exception ex) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error General", "Ocurrió un error al guardar la información");
                }
            }
        }

    //Listar Departamentos
        @FXML TextField txtIdListar;
        public void handleVerLista(ActionEvent e){
            try{
                String lista = empresa.mostrarDepartamentos();
                if (lista.trim().isEmpty()) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Lista Vacía", "No hay departamentos registrados.");
                } else {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Lista de Departamentos", lista);
                }
            }catch (Exception ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Error al obtener la lista: " + ex.getMessage());
            }
        }

        //Listar Empleados por Departamento
        public void handleListarEmpleados(ActionEvent e){
            try {
                String idText = txtIdListar.getText();
                if (idText.trim().isEmpty()) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error de Entrada",
                            "Por favor, ingrese la ID del departamento.");
                    return;
                }
                int id = Integer.parseInt(idText);

                Departamento dpto = empresa.buscarDepartamentoPorId(id);

                if (dpto == null) {
                    mostrarAlerta(Alert.AlertType.WARNING, "Advertencia",
                            "Departamento con ID " + id + " no encontrado.");
                    return;
                }
                String listaEmpleados = empresa.listarEmpleadosporDepartamento(id);
                if (listaEmpleados.trim().isEmpty()) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Lista Vacía",
                            "El departamento " + dpto.getNombreDepartamento() + " no tiene empleados registrados.");
                } else {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Empleados de " + dpto.getNombreDepartamento(), listaEmpleados);
                }
                txtIdListar.clear();
            }catch (NumberFormatException nex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
                        "La ID debe ser un número entero.");
            } catch (Exception ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ocurrió un error al listar: " + ex.getMessage());
            }

        }

        //Agregar Empleados
        @FXML TextField txtIdDptoAgregarEmpleado;
        @FXML TextField txtNombreEmpleadoAgregar;
        @FXML TextField txtIdEmpleadoAgregar;
        @FXML TextField txtEmailEmpleadoAgregar;
        @FXML TextField txtValoracionEmpleadoAgregar;
        @FXML TextField txtTemporalidad;

        public void handleAgregarEmpleado(ActionEvent e){
            try{
                int idDpto = Integer.parseInt(txtIdDptoAgregarEmpleado.getText());
                String nombre = txtNombreEmpleadoAgregar.getText();
                int idEmpleado = Integer.parseInt(txtIdEmpleadoAgregar.getText());
                String email = txtEmailEmpleadoAgregar.getText();
                int valoracion = Integer.parseInt(txtValoracionEmpleadoAgregar.getText());
                String temporalidad = txtTemporalidad.getText();
                boolean temporal = false;

                if (nombre.trim().isEmpty() || email.trim().isEmpty() || idDpto < 0 || idEmpleado <=0 || valoracion < 0 || valoracion > 10 || temporalidad.trim().isEmpty()) {
                    mostrarAlerta(Alert.AlertType.ERROR,"Error de Validación", "Asegurese de completar correctamente los campos");
                    return;
                }

                if(temporalidad.equalsIgnoreCase("Si")){
                    temporal = true;
                }

                boolean agregado = empresa.agregarEmpleadoGE(nombre, idEmpleado, idDpto, email, valoracion, temporal);

                if(agregado){
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito",
                            "El empleado **" + nombre + "** fue agregado al departamento ID **" + idDpto + "**.");
                    txtIdDptoAgregarEmpleado.clear();
                    txtNombreEmpleadoAgregar.clear();
                    txtIdEmpleadoAgregar.clear();
                    txtEmailEmpleadoAgregar.clear();
                    txtValoracionEmpleadoAgregar.clear();
                }else {
                    mostrarAlerta(Alert.AlertType.WARNING, "Advertencia",
                            "No se pudo agregar el empleado. La ID del departamento **" + idDpto + "** no existe. o la ID del empleado está repetida.");
                }
            }catch (NumberFormatException nex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
                        "La ID del Empleado y del Departamento deben ser números enteros válidos.");
            } catch (Exception ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error General",
                        "Ocurrió un error inesperado al guardar: " + ex.getMessage());
            }
        }

        //Modificar Empleado
        @FXML TextField textIdDptoModificarEmpleado;
        @FXML TextField textIdEmpleadoModificar;
        @FXML TextField textNuevoNombreEmpleado;
        @FXML TextField textNuevoEmailModificar;
        @FXML TextField textNuevaValoracionModificar;

        public void handleModificarEmpleado(ActionEvent e){
            String idEmpleadoText = textIdEmpleadoModificar.getText().trim();
            if (idEmpleadoText.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "La ID del empleado es obligatoria.");
                return;
            }
            try{
                //int idEmpleado = Integer.parseInt(idEmpleadoText);
                String idDptoString = textIdDptoModificarEmpleado.getText().trim();
                String nuevoNombreEmpleado = textNuevoNombreEmpleado.getText().trim();
                String nuevoEmailEmpleado = textNuevoEmailModificar.getText().trim();
                String nuevaValoracionEmpleadoString = textNuevaValoracionModificar.getText().trim();

                String modificacion = empresa.modificarEmpleadoGE(
                nuevoNombreEmpleado, idEmpleadoText, idDptoString, nuevoEmailEmpleado, nuevaValoracionEmpleadoString);

                mostrarAlerta(Alert.AlertType.INFORMATION, "Modificación Exitosa", modificacion);
                textNuevoNombreEmpleado.clear();
                textNuevoEmailModificar.clear();
                textNuevaValoracionModificar.clear();
                textIdDptoModificarEmpleado.clear();
                textIdEmpleadoModificar.clear();

            }catch (NumberFormatException nex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
                        "Verifique si el ID del Empleado es correcto.");
            } catch (Exception ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error General",
                        "Ocurrió un error inesperado al guardar: " + ex.getMessage());
            }
        }

        //Eliminar Empleado
        @FXML TextField textEliminarEmpleado;

        public void handleEliminarEmpleado(ActionEvent e){
            String idEmpleado = textEliminarEmpleado.getText().trim();
            if (idEmpleado.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No ingresó la ID del Empleado.");
                return;
            }
            Alert confirmacion =  new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmacion");
            confirmacion.setHeaderText("Va a eliminar un Empleado");
            confirmacion.setContentText("¿Está seguro? Esta acción no se puede deshacer");

            Optional<ButtonType> result = confirmacion.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                try{
                    String empleadoEliminado = empresa.eliminarEmpleado(idEmpleado);
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Modificación Exitosa", empleadoEliminado);
                    textEliminarEmpleado.clear();
                }catch (NumberFormatException nex) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
                            "Verifique si el ID del Empleado es correcto.");
                } catch (Exception ex) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error General",
                            "Ocurrió un error inesperado al guardar: " + ex.getMessage());
                }
            }

        }

        //Reportes Departamento
        @FXML TextField textReporteDepartamento;

        public void handleReporteDepartamento(ActionEvent e){
            String idDepartamento = textReporteDepartamento.getText().trim();
            if (idDepartamento.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No ingresó la ID del Departamento.");
                return;
            }
            try{
                int idDepartamentoInt = Integer.parseInt(idDepartamento);

                String reporte = empresa.generarReporteDepartamento(idDepartamentoInt);
                if (reporte.startsWith("Error")){
                     mostrarAlerta(Alert.AlertType.ERROR, "Error al Generar Reporte", reporte);
                } else {
                     mostrarReporte(reporte);
                }
            }catch (NumberFormatException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
                        "La ID del departamento debe ser un número entero.");
             }
        }

        //Reporte Empleado
        @FXML TextField txtIdReporteEmpleado;

        public void handleReporteEmpleado(ActionEvent e){
            String idEmpleado = txtIdReporteEmpleado.getText().trim();
            if (idEmpleado.isEmpty()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No ingresó correctamente la ID del empleado");
                return;
            }
            try{
                int idEmpleadoInt = Integer.parseInt(idEmpleado);
                String reporte = empresa.generarReporteEmpleado(idEmpleadoInt);
                if(reporte.startsWith("Error")){
                    mostrarAlerta(Alert.AlertType.ERROR, "Error al Generar Reporte", reporte);
                } else {
                mostrarReporte(reporte);
                }
            }catch (NumberFormatException ex) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Formato",
                        "La ID del departamento debe ser un número entero.");
            }
        }


        //Ventana que muestra el Reporte
        public void mostrarReporte(String reporte){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Reporte Departamental");
            alerta.setHeaderText(null);
            TextArea textArea = new TextArea(reporte);
            textArea.setEditable(false);
            textArea.setWrapText(true);
            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            alerta.getDialogPane().setContent(textArea);
            alerta.showAndWait();
        }
}

