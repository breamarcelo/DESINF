package com.javafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class App extends Application {
    // Implementación del método start() de la interfaz Application
    @Override
    public void start(Stage stage) throws IOException {
        // Creación de la ventana y panel principal con estilos
        Stage window = stage;
        window.setTitle("Actividad 1.2 - JavaFX");
        FlowPane root = new FlowPane();
        root.setPrefSize(200, 200);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: lightblue;");
        root.setVgap(10);
        
        // Creación de etiquetas y campos de entrada de texto
        Label nombreLabel = new Label("Nombre: ");
        root.getChildren().add(nombreLabel);
        TextField nombreTextField = new TextField("Luis Marcelo");
        root.getChildren().add(nombreTextField);
        
        Label apellidosLabel = new Label("Apellidos: ");    
        root.getChildren().add(apellidosLabel);
        TextField apellidosTextField = new TextField("Brea Pérez");
        root.getChildren().add(apellidosTextField);

        // Creación de botón y llamada al Listener
        Button boton = new Button("ENVIAR");
        boton.setPrefWidth(150);
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                // Se crea el Modal mostrando la información del formulario
                Dialog dialog = new Dialog<String>();
                dialog.setTitle("Saludo");
                dialog.setContentText("Hola " + nombreTextField.getText() + " " + apellidosTextField.getText());
                dialog.getDialogPane().getButtonTypes().add(new ButtonType("Cerrar", ButtonBar.ButtonData.OK_DONE));
                dialog.show();
            }
            
        });
        root.getChildren().add(boton);

        // Se añade la escena a la ventana
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}