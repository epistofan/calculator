package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.font.TextLabel;
import sun.security.util.Length;

import java.awt.*;
import java.beans.EventHandler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.Scanner;

public class Main extends Application {
    //Button button;
    float number1, number2, answer;
    int arifm;
    Boolean oko;
    String[] zametki;
    String line;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("calc");


        Label text = new Label();
        text.setText(" 0 ");

       // text.getText(klava);
        //text.setPromptText("0");
        text.setAlignment(Pos.CENTER_RIGHT);
        text.setPrefWidth(300);



        TextArea text2 = new TextArea();
       text2.setPromptText("dlja zametok");

      //  BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\busja\\IdeaProjects\\test\\test1.txt"));


       // for(String line; (line = br.readLine()) != null; ) {

         //   text2.appendText(line+ "\r\n");
      //  }



        text2.setPrefColumnCount(10);
        text2.setPrefRowCount(10);


        Label label1 = new Label();
        label1.setPrefWidth(500);
        label1.setAlignment(Pos.CENTER_RIGHT);
        label1.setStyle("-fx-border-color:black; -fx-background-color: null;");

        Button button1 = new Button();

        button1.setText("1");
        button1.setOnAction(e -> {
            //text.setText("");
            if(text.getText().contains("0")) {
                text.setText("1");
            }else{
            text.setText(text.getText() + "1");}
        });

        Button button2 = new Button();
        button2.setText("2");
        // Controller bf = new Controller();
        button2.setOnAction(e -> {
            // Controller.button2();
            text.setText(text.getText() + "2");
        });

//test
        Button button3 = new Button();
        button3.setText("3");
        // Controller bf = new Controller();
        button3.setOnAction(e -> {
            // Controller.button2();
            text.setText(text.getText() + "3");
        });

        Button button4 = new Button();
        button4.setText("4");
        // Controller bf = new Controller();
        button4.setOnAction(e -> {
            // Controller.button2();
            text.setText(text.getText() + "4");
        });

        Button button5 = new Button();
        button5.setText("5");
        // Controller bf = new Controller();
        button5.setOnAction(e -> {
            // Controller.button2();
            text.setText(text.getText() + "5");
        });

        Button backspacebutton = new Button();
        backspacebutton.setText("Dzest");
        backspacebutton.setOnAction(e -> {

            text.setText("");
        });
        label1.setText("Privet");

        //knopak stiratj

        Button stiratj = new Button();
        stiratj.setText("stiratj");
        stiratj.setOnAction(e -> {
           // String[] zametki = {text.getText()};
            if(text.getText().trim().isEmpty()) {
                popup.alert("gavno", "vsjo, tukss");
            }else{
            text.setText(text.getText().substring(0, text.getText().length()-1));}
           // System.out.println();


            //System.out.println(zametki[0]);
           // text.setText();
        });



        Button plus = new Button();
        plus.setText("+");
        plus.setOnAction(e -> {

            // text.setText("");
            label1.setText(text.getText() + "+");
            text.getText();
            if (text.getText().trim().isEmpty()) {
                popup.alert("Uzmanibu", "pusto");
            } else if(text.getText().matches("[a-z]")){
                popup.alert("Uzmanibu", "vajag cifri");
            } else {
                number1 = Float.parseFloat(text.getText());
            }
            System.out.println(number1);
            text.setText("");
            arifm = '+';
        });
        Button minus = new Button();
        minus.setText("-");
        minus.setOnAction(e -> {

            // text.setText("");
            label1.setText(text.getText() + "-");
            text.getText();
            if (text.getText().trim().isEmpty()) {
                popup.alert("Uzmanibu", "pusto");
            } else {
                number1 = Float.parseFloat(text.getText());
            }
            System.out.println(number1);
            text.setText("");
            arifm = '-';
        });
        Button devide = new Button();
        devide.setText("/");
        devide.setOnAction(e -> {

            // text.setText("");
            label1.setText(text.getText() + "/");
            text.getText();
            if (text.getText().trim().isEmpty()) {
                popup.alert("Uzmanibu", "pusto");
            } else {
                number1 = Float.parseFloat(text.getText());
            }

            text.setText("");
            arifm = '/';
        });

        Button ravno = new Button();
        ravno.setText("=");
        ravno.setOnAction(e -> {
            if (text.getText().trim().isEmpty()) {
                popup.alert("Uzmanibu", "pusto");
            } else {
                label1.setText(label1.getText() + text.getText() + "=");
                text.getText();
                number2 = Float.parseFloat(text.getText());

                switch (arifm) {
                    case '+':
                        text.setText(String.valueOf(number1 + number2));
                        label1.setText(label1.getText() + text.getText());
                        break;
                    case '-':
                        text.setText(String.valueOf(number1 - number2));
                        label1.setText(label1.getText() + text.getText());
                        break;
                    case '/':
                        if (number1 == 0) {
                            popup.alert("you", "nedrixt");
                        } else {
                            text.setText(String.valueOf(number1 / number2));

                            label1.setText(label1.getText() + text.getText());
                        }
                        break;
                    case '*':
                        text.setText(String.valueOf(number1 * number2));
                        label1.setText(label1.getText() + text.getText());
                        break;
                }
            }
            //System.out.println(number2+number1);

            //text.setText("");
        });


        //FlowPane layout = new FlowPane();
        BorderPane layout2 = new BorderPane();
        layout2.setPadding(new Insets(10, 20, 10, 20));
        ToolBar tulstop = new ToolBar(text);
        layout2.setTop(tulstop);
        VBox sleva = new VBox(button1, button2, button3, button4, button5);
        VBox sprava = new VBox(plus, minus, ravno, backspacebutton, devide, stiratj);
        layout2.setLeft(sleva);
        layout2.setRight(sprava);
        layout2.setCenter(text2);
        layout2.setBottom(label1);
        // layout.getChildren().addAll(button1, button2, text, backspacebutton, label1, plus, minus, ravno, text2);
        Scene scene = new Scene(layout2, 400, 250);
        scene.setOnKeyPressed(e -> text.setText((text.getText())+(e.getCode().toString())));
       // if(text.getText().matches("[a-z]")){
            //popup.alert("Uzmanibu", "vajag cifri");}

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
        /* primaryStage.setOnCloseRequest(e -> {System.out.println("sranj");
            String[] zametki = {text2.getText()};
            System.out.println(zametki[0]);
        });*/


          /*  primaryStage.setOnCloseRequest(e -> {
                try {
                    File file = new File("test1.txt");
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(text2.getText());

                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException ez) {
                    ez.printStackTrace();
                }
            });*/


        }
    }




