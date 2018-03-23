package sample;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.beans.Expression;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextArea;
import javafx.stage.Window;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.*;



public class Controller {
    boolean islocked=false;
    boolean isopen=false;
    double cxOffset = 0.0;
    double cyOffset = 0.0;
    float n1;
    float n2;
    //int ansver;
    String op;
    float number1;
    float number2;
    float number3;
    int arifm1;
    int arifm2;
    //float ansver;
    String[] aaa;
    int aaalen;
boolean ifnul;
    String otvet;
    String otvet2;
    @FXML
    private Button b0;
    @FXML
    public ListView<String> test_v;
    @FXML
    private Button plusw;
    @FXML
    private Label history;
    @FXML
    Label lab1;
    @FXML
    public Button ravno;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private Button p;
    @FXML
    private Button about;
    @FXML
    public TextField mainD;
    @FXML
    private BorderPane controller;
    @FXML
    public TextArea zam;
    @FXML
    public Button bminus;
    @FXML
    private Button buttonsqr;
    @FXML
    private MenuItem Close;
    @FXML
    public Button clear;
    @FXML
    private Button help;


    public void closeProgramm() {
        System.out.println("eaaaaaa");
        System.exit(1);


    }

    @FXML
    void saveZ(MouseEvent event) throws Exception {

        try {
            File file = new File("/sample/test1.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(zam.getText());

            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ez) {
            ez.printStackTrace();
        }
    }


    @FXML
    void loadZ(MouseEvent event) throws Exception {
        if (zam.getText().trim().isEmpty()) {
            try {

                BufferedReader br = new BufferedReader(new FileReader("/sample/test1.txt"));


                for (String line; (line = br.readLine()) != null; ) {

                    zam.appendText(line + "\r\n");
                }
            } catch (IOException ez) {
                ez.printStackTrace();
            }

        } else {
            System.out.println("bam");
        }
    }

    @FXML
    void about(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene((root1), 400, 200));

            stage.initStyle(StageStyle.UNDECORATED);
           stage.setX((((Button) event.getSource()).getScene().getWindow().getX()) -402);
         stage.setY(((Button) event.getSource()).getScene().getWindow().getY() + 0);
            stage.initOwner(((Button) event.getSource()).getScene().getWindow());

           //tage.initModality(Modality.APPLICATION_MODAL);
            stage.show();


            root1.setOnMousePressed(e-> {

                stage.getX();
                stage.getY();
                e.getScreenX();
                e.getScreenY();
                cxOffset = e.getScreenX() - stage.getX();
                //System.out.println(cxOffset);
                cyOffset = e.getScreenY() - stage.getY();
            });
            root1.setOnMouseDragged(e->{
                //System.out.println(stage.getY());
               // System.out.println(stage.getX());
                //stage.setX((((Stage) ((Button) event.getSource()).getScene().getWindow()).getX()) - 405);
                //stage.setY((((Stage) ((Button) event.getSource()).getScene().getWindow()).getY()) - 0);
                Double mainX=(((Button) event.getSource()).getScene().getWindow().getX());
                Double mainY=(((Button) event.getSource()).getScene().getWindow().getY());

                stage.setX(e.getScreenX()- cxOffset);
                stage.setY(e.getScreenY()- cyOffset);
                System.out.println(cxOffset);
                Double result = stage.getX()-mainX;
                System.out.println(result);
                Double f = -400.0;
                Double g = -350.0;
                if (result<(g)&& result>(f)){
                  stage.setX((stage.getOwner().getX())-402);
                   stage.setY(stage.getOwner().getY());
                   System.out.println(result+"magnit");
               }
            });

            ((Button) event.getSource()).getScene().setOnMousePressed(e -> {
                        Double mainX = (((Button) event.getSource()).getScene().getWindow().getX());
                        Double chX = stage.getX();
                        Double t=mainX-chX;
                        if (t.equals(402.0)) {
                            islocked = true;
                            System.out.println("zakryvaju");
                            //stage.close();
                            stage.setX((stage.getOwner().getX()) - 402);
                            stage.setY(stage.getOwner().getY());
                            // stage.setX((((Button) event.getSource()).getScene().getWindow().getX()) + 100);

                        }else{
                            islocked=false;
                        }
                    }


            );


            ((Button) event.getSource()).getScene().setOnMouseDragged(e -> {
if(islocked) {
    System.out.println("zakryvaju");
    //stage.close();
    stage.setX((stage.getOwner().getX()) - 402);
    stage.setY(stage.getOwner().getY());
    // stage.setX((((Button) event.getSource()).getScene().getWindow().getX()) + 100);
}

                    }


            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void help(ActionEvent event) throws Exception {


        if (isopen == true) {


            System.out.println("otrkrito");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("help.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage cstage = new Stage();
                cstage.setScene(new Scene((root1), 400, 600));

                cstage.initStyle(StageStyle.UNDECORATED);
                //cstage.setX((( ((Button) event.getSource()).getScene().getWindow()).getX()) - 405);
                //cstage.setY((( ((Button) event.getSource()).getScene().getWindow()).getY()) - 0);
                // cstage.initModality(Modality.NONE);
//stage.showAndWait();
                cstage.show();
                isopen = true;
                cstage.setX(cxOffset);
                root1.setOnMousePressed(e -> {

                            cstage.getX();
                            cstage.getY();
                            e.getScreenX();
                            e.getScreenY();
                            cxOffset = e.getScreenX() - cstage.getX();
                            System.out.println(cxOffset);
                            cyOffset = e.getScreenY() - cstage.getY();
                            // System.out.println("zakryvaju");
                            //stage.close();
                            //cstage.setX((((Stage) ((Button) event.getSource()).getScene().getWindow()).getX()) - 405);
                           // cstage.setY((((Stage) ((Button) event.getSource()).getScene().getWindow()).getY()) - 0);
                        }


                );

                root1.setOnMouseDragged(ev -> {

                    System.out.println(cstage.getY());
                    System.out.println(cstage.getX());
                    cstage.setX((((Stage) ((Button) event.getSource()).getScene().getWindow()).getX()) - 405);
                    cstage.setY((((Stage) ((Button) event.getSource()).getScene().getWindow()).getY()) - 0);

                    cstage.setX(ev.getScreenX()- cxOffset);
                    cstage.setY(ev.getScreenY()- cyOffset);
                    System.out.println(cxOffset);

                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    void movew(ActionEvent event) {


    }

    @FXML
    void minimize(ActionEvent event) {

        System.out.println("min");
//vlijanije na primaryStage
        ((Stage) ((Button) event.getSource()).getScene().getWindow()).setIconified(true);

    }
    @FXML
    void button0(ActionEvent event) {
        mainD.setText(mainD.getText() + "0");
    }

    @FXML
    void button1(ActionEvent event) {
        mainD.setText(mainD.getText() + "1");


    }

    @FXML
    void button2(ActionEvent event) {

        mainD.setText(mainD.getText() + "2");


    }

    @FXML
    void button3(ActionEvent event) {
        mainD.setText(mainD.getText() + "3");


    }

    @FXML
    void button4(ActionEvent event) {
        mainD.setText(mainD.getText() + "4");


    }

    @FXML
    void buttonp(ActionEvent event) {
        mainD.setText(mainD.getText() + ".");


    }

    @FXML
    void button5(ActionEvent event) {
        mainD.setText(mainD.getText() + "5");


    }

    @FXML
    void button6(ActionEvent event) {
        mainD.setText(mainD.getText() + "6");


    }

    @FXML
    void button7(ActionEvent event) {
        mainD.setText(mainD.getText() + "7");


    }

    @FXML
    void button8(ActionEvent event) {
        mainD.setText(mainD.getText() + "8");


    }

    @FXML
    void button9(ActionEvent event) {
        mainD.setText(mainD.getText() + "9");


    }



        //equation


    @FXML
    void ravno(ActionEvent event) {
       //String[] aaa = mainD.getText().split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");

        Stack<String> cifri = new Stack<String>();
        Stack<String> temp1 = new Stack<String>();
        Stack<String> oper = new Stack<String>();
        Stack<String> cifri2 = new Stack<String>();
        Stack<String> cifriTemp = new Stack<String>();
        Stack<String> oper2 = new Stack<String>();
        Stack<String> operTemp = new Stack<String>();
        Stack<String> postfix = new Stack<String>();
        Stack<String> tempOper = new Stack<String>();


                                //cfri
                               // String[] aaa = mainD.getText().split("\\(|\\)|(?<=[0-9])[-+*/]|(?<=[)])[-+*/]");
        //String[] aaa = mainD.getText().replaceAll("\\(|\\)|(?<=[(])[-]","").split("[-+*/]");
        String[] aaa = mainD.getText().replaceAll("[()]","").split("(?<=[\\d])[-+*/]");
        if (aaa.length == 1){
            System.out.println("1 cifra");
            test_v.getItems().add(mainD.getText());
        }else{
        //znaki
      String[] operators = mainD.getText().replaceAll("\\(\\-[\\d]\\)|\\d|[.]","").split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        //String[] operators = mainD.getText().split("(?<=[(])[0-9](?=[)])|(?<=[(])[-]|[(]|[)]|\\d");
       // String[] operators = mainD.getText().split("\\(\\-[\\d]\\)|\\d");
                              //  String[] operators = mainD.getText().split("[-+](?=\\d)|" +
                                     //   "(?<=\\d)[*/]|" +
                                     //  "[-+](?=[()])|" +
                                        //"[()]|" +
                                     //   "(?<=\\A|[+-])\\d(?=[-+])|" +
                                     //   "(?<=[(])[-](?=[0-9])");

                                //String[] aaa = mainD.getText().split("\\d(?=[*/])|(?<=[*/])\\d|[-+()]|\\d");
                               //String[] aaa = mainD.getText().split("-(?=[-+*/(])|[+*/]|[()]");



                for (int j = 0; j < aaa.length; j++) {
                    System.out.println(aaa[j]);
                }
                for (int g = 0; g < operators.length; g++) {
                    System.out.println(operators[g]);
                }

                                String aaa2 = mainD.getText();
                                String pattern = "[+]{2,10}";
                                //String pattern = "[a-zA-Z]";
                                Pattern r = Pattern.compile(pattern);
                                Matcher m = r.matcher(aaa2);

        if (mainD.getText().trim().isEmpty() || m.find()) {
            lab1.setText("pishite cifri pls");
            mainD.setText("");
        }else {

test_v.getItems().add(mainD.getText());
            System.out.println("start");

            for (int i = 0; i < aaa.length; i++) {
                cifri.push(aaa[i]);

                            }
            while (!cifri.isEmpty()){
                cifri2.push(cifri.pop());

            }
            for (int z = 0; z < operators.length; z++) {
               oper.push(operators[z]);
                System.out.println("drjuk"+oper.peek());

            }
            while (!oper.isEmpty()){
                oper2.push(oper.pop());
                System.out.println("drjuk2" + oper2.peek());
            }


           System.out.println("start2");

             while (!oper2.isEmpty()) {
                 //postfix.push(cifri2.pop());
                 System.out.println("cikl");


                 op = oper2.pop();
                 n1 = Float.valueOf(cifri2.pop());

                 if (op.equals("-")|op.equals("+")) {
                     operTemp.push(op);
                     cifriTemp.push(String.valueOf(n1));
if (oper2.isEmpty()){System.out.println("pusto");
    cifriTemp.push(cifri2.pop());}


                    } else if (op.equals("/")|op.equals("*")) {

                        switch (op){
                                case "/":
                                     System.out.println("//");
                                    n2 = Float.valueOf(cifri2.pop());

                                        cifri2.push(String.valueOf(n1 / n2));

                                break;
                                 case "*":
                                        System.out.println("**");
                                     n2 = Float.valueOf(cifri2.pop());
                                        cifri2.push(String.valueOf(n2 * n1));

                                break;
                                    }


                     System.out.println(cifri2.peek());


                 }
                 }

            while (!cifriTemp.isEmpty()){
                cifri2.push(cifriTemp.pop());
            }

            while (!operTemp.isEmpty()){
                oper2.push(operTemp.pop());
            }

            while (!oper2.isEmpty()) {
                op = oper2.pop();
                n1 = Float.valueOf(cifri2.pop());
                if (op.equals("-")|op.equals("+")) {
                    switch (op) {
                        case "-":
                            System.out.println("-");
                            n2 = Float.valueOf(cifri2.pop());
                            cifri2.push(String.valueOf(n1 - n2));
                            break;
                        case "+":
                            System.out.println("+");
                            n2 = Float.valueOf(cifri2.pop());
                            cifri2.push(String.valueOf(n1 + n2));
                            break;
                    }
                }
             }
            System.out.println(cifri2.peek());









            System.out.println("start3");
            mainD.setText(cifri2.peek());
            test_v.getItems().add(mainD.getText());

        }


            }
    }

                                    // DecimalFormat df = new DecimalFormat("0.###");
                                   // System.out.println(df.format(r2.ansver));
                                  //  mainD.setText(String.format(Locale.US,"%.2f",(r2.ansver)));








    @FXML
    void plusw(ActionEvent event) {

        if (mainD.getText().endsWith("+")|mainD.getText().endsWith("-")) {

        } else {

            mainD.appendText("+");
        }

    }
    @FXML
    void bminus(ActionEvent event) {

        if (mainD.getText().endsWith("-")|mainD.getText().endsWith("+")) {

        } else {

            mainD.appendText("-");
        }

    }
    @FXML
    void clear() {
        mainD.setText("");

    }

    @FXML
    void history() {

        history.setOnMouseClicked(e -> {
            mainD.setText(history.getText());
            System.out.println("stoggggp");
        });

    }

    @FXML
    void copy_text() {

            System.out.println("esjjj");

        test_v.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        mainD.setText(new_val);
                        //label.setTextFill(Color.web(new_val));
                    }
                });











    }
    @FXML
    void bsqr(ActionEvent event) {
        if (mainD.getText().isEmpty()){
            mainD.setText(String.valueOf(Math.sqrt(0)));
        }else{
            number1= Float.parseFloat(mainD.getText());

            mainD.setText(String.valueOf(Math.sqrt(number1)));
        }


    }


}
