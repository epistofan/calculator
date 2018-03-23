package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.*;


public class Main extends Application {


    double newX;
    double newY;
boolean isopen=false;
    double xOffset = 0.0;
    double yOffset = 0.0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("calculator v 1");
        primaryStage.setScene(new Scene(root, 600, 410));
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.show();
        System.out.println("started");

        //MAKE WINDOW DRAG

        root.setOnMousePressed(e -> {
            System.out.println("test");



        primaryStage.getX();
        primaryStage.getY();
        e.getScreenX();
        e.getScreenY();
            xOffset=e.getScreenX()-primaryStage.getX();
            System.out.println(xOffset);
            yOffset=e.getScreenY()- primaryStage.getY();

        }

            );

        root.setOnMouseDragged(ev -> {

                System.out.println(primaryStage.getY());
            System.out.println(primaryStage.getX());

            primaryStage.setX(ev.getScreenX()- xOffset);
            primaryStage.setY(ev.getScreenY()- yOffset);
            System.out.println(xOffset);

        });


    }



    public static void main(String[] args) {

        launch(args);

    }

}
