package com.ecodeup.jdbc.poofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/*
Esta es basicamente la clase Main, pero con la diferencia que desde aqui solo se ejecuta la
ventana principal, junto con el icono
 */
public class CompuWorkGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println(System.getProperty("javafx.runtime.version"));
        Parent root = FXMLLoader.load(getClass().getResource("/iniciarSesion.fxml"));
        primaryStage.setTitle("CompuWork");
        primaryStage.setScene(new Scene(root));
        Image icon = new Image(getClass().getResourceAsStream("/Images/iconoP.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.show();




    }

}