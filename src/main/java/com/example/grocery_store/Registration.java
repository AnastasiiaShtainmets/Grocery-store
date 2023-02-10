package com.example.grocery_store;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class Registration {

    @FXML
    private Button button1;

    @FXML
    private TextField login;

    @FXML
    private TextField pass;

    @FXML
    void initialize() {
        button1.setOnAction(click -> {
            System.out.println("Логин:" + login.getText());
            System.out.println("Пароль:" + pass.getText());
            button1.getScene().getWindow().hide();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\IdeaProjects\\Grocery store\\src\\main\\resources\\com\\example\\grocery_store\\login.txt"))) {
                writer.write(login.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Authorization.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Dell\\IdeaProjects\\Grocery store\\src\\main\\resources\\com\\example\\grocery_store\\pass.txt"))) {
                writer.write(pass.getText());
                writer.newLine();

                FXMLLoader loader = new FXMLLoader();
                // loader.setLocation(getClass().getResource("Authorization.fxml"));
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }

        });
    }

}