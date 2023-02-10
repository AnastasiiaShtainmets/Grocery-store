package com.example.grocery_store;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Authorization {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private TextField login;

    @FXML
    private TextField pass;
    @FXML
    void initialize() {
        button1.setOnAction(click -> { //проверка логина и пароля пользователя
                    button1.setText("Добро пожаловать");
                    System.out.println("Логин:" + login.getText());
                    System.out.println("Пароль:" + pass.getText());
                    button1.getScene().getWindow().hide();
                    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dell\\IdeaProjects\\Grocery store\\src\\main\\resources\\com\\example\\grocery_store\\pass.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.equals(pass.getText().trim())) {
                                try {
                                    FXMLLoader loader = new FXMLLoader();
                                    loader.setLocation(getClass().getResource("Description.fxml"));
                                    loader.load();
                                    Parent root = loader.getRoot();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(root));
                                    stage.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Верный пароль");
                            } else {
                                try {
                                    FXMLLoader loader = new FXMLLoader();
                                    loader.setLocation(getClass().getResource("Error.fxml"));
                                    loader.load();
                                    Parent root = loader.getRoot();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(root));
                                    stage.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Данные введены некорректно");
                            }
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Dell\\IdeaProjects\\Grocery store\\src\\main\\resources\\com\\example\\grocery_store\\login.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.equals(login.getText().trim())) {
                                try {
                                    FXMLLoader loader = new FXMLLoader();
                                    loader.load();
                                    Parent root = loader.getRoot();
                                    Stage stage = new Stage();
                                    stage.setScene(new Scene(root));
                                    stage.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Данные введены некорректно");
                                }
                                System.out.println("Верный логин");
                            }
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            button2.setOnAction(click -> {
                button2.getScene().getWindow().hide();
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Registration.fxml"));
                    loader.load();
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
