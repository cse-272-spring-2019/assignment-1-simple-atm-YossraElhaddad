/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.beans.binding.Bindings;


/**
 *
 * 
 */
public class ATM extends Application {
    MyAtm atm = new MyAtm();
    LinkedList<String> list = new LinkedList();
    int count=0;
    int index = count-1;
    Scene scene, scene1,scene2,scene3;  
    @Override
    @SuppressWarnings({"SuspiciousIndentAfterControlStatement", "StringEquality"})
    public void start(Stage primaryStage) throws Exception {
        Button Deposit = new Button();
        Deposit.setText("Deposit");
        Button Withdraw = new Button();
        Withdraw.setText("Withdraw");
        Button BalanceInquiry = new Button();
        BalanceInquiry.setText("Balance Inquiry");
        Button Previous = new Button();
        Previous.setText("Prev");
        Button Next = new Button();
        Next.setText("Next");
        Label label = new Label();
        TextField textfield = new TextField();
        Label w = new Label("Enter the amount you want to withdraw");
        Button submit = new Button();
        submit.setText("Submit");
        Button submit1 = new Button();
        submit1.setText("Submit");
        Label d = new Label("Enter the amout you want to deposit");
        TextField textfield1 = new TextField();
        
        PasswordField password = new PasswordField();
        Label p = new Label("Enter your card number: ");
        Button submit2 = new Button();
        submit2.setText("Submit");
        
        
        BalanceInquiry.setOnAction((ActionEvent event) -> {
            label.textProperty().bind(Bindings.concat("Balance Inquiry: ", atm.getBalance()));
            String s ="Balance Inquiry: ";
            s=s.concat(Double.toString(atm.getBalance()));
            list.add(s);
            count++; index++;
            if( list.size()>5)
                list.remove(0);
        });
        Withdraw.setOnAction((ActionEvent event) -> {
            if(atm.getBalance()==0.0)
                Alert.display("Alert", "YOU HAVE NO BALANCE!");
            else
            primaryStage.setScene(scene1);
        });
         submit.setOnAction((ActionEvent event) -> {
             atm.setAmount(Double.parseDouble(textfield.getText()));
             if(atm.getAmount() < atm.getBalance()){
             atm.withdraw();
            primaryStage.setScene(scene);
            label.textProperty().bind(Bindings.concat("Amount withdrawn: ", atm.getAmount()));
             
             String s = "Amount withdrawn: ";
            s=s.concat(Double.toString(atm.getAmount()));
            list.add(s);
            count++; index++;
            if( list.size()>5)
                list.remove(0);
             }
             else{
                 Alert.display("Alert", "YOU CANNOT WITHDRAW THIS AMOUNT!");
             }
        });
         
          Deposit.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(scene2);
        });
           submit1.setOnAction((ActionEvent event) -> {
               atm.setAmount(Double.parseDouble(textfield1.getText()));
               if(atm.getAmount() < 0)
                    Alert.display("Alert", "YOU CANNOT DEPOSIT NEGATIVE VALUES1");
               else{
               atm.deposit();
            primaryStage.setScene(scene);
             label.textProperty().bind(Bindings.concat("Amount deposited: ", atm.getAmount()));
             String s ="Amount deposited: ";
             s=s.concat(Double.toString(atm.getAmount()));
            list.add(s);
            count++; index++;
            if( list.size()>5)
                list.remove(0);}
        });
           
           submit2.setOnAction((ActionEvent event) -> {
              
           boolean a = password.getText().equals(atm.getNumber());
           if(a)
               primaryStage.setScene(scene);
           else  Alert.display("Alert", "Invalid number!!");
              
               
         } );
           
           
           
           Previous.setOnAction((ActionEvent event) ->{
              if(index > 0)
              label.textProperty().bind(Bindings.concat("", list.get(--index)));
              else  Alert.display("Alert", "No history");
           } );
           Next.setOnAction((ActionEvent event) ->{
            if(index < list.size())
                label.textProperty().bind(Bindings.concat("", list.get(++index)));
            else if(index >= count || index<0)
              Alert.display("Alert", "No history");
               
           } );
        
        GridPane grid = new GridPane();
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        grid.setMinSize(500, 300);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(15);
        grid.setHgap(15);
        grid.add(BalanceInquiry,0,0);
        grid.add(label,1,1);
        grid.add(Deposit,2,0);
        grid.add(Withdraw,0,1);
        grid.add(Previous,0,2);
        grid.add(Next,2,2);
        grid1.setMinSize(500, 300);
        grid1.setAlignment(Pos.CENTER);
         grid1.setVgap(10);
        grid1.setHgap(10);
        grid1.add(textfield, 1, 1);
        grid1.add(w,1,0);
        grid1.add(submit, 1, 2);
        grid2.setMinSize(500, 300);
        grid2.setAlignment(Pos.CENTER);
         grid2.setVgap(10);
        grid2.setHgap(10);
        grid2.add(textfield1, 1, 1);
        grid2.add(d, 1, 0);
        grid2.add(submit1, 1, 2);
         grid3.setMinSize(500, 300);
        grid3.setAlignment(Pos.CENTER);
         grid3.setVgap(10);
        grid3.setHgap(10);
        grid3.add(password, 1, 1);
        grid3.add(p,1,0);
        grid3.add(submit2,1,2);
        
        
        scene3 = new Scene(grid3);
        scene2 = new Scene(grid2);
        scene1 = new Scene(grid1);
         scene = new Scene(grid);
        
        primaryStage.setTitle("ATM");
        primaryStage.setScene(scene3);
        primaryStage.show();
    }
    
   
    /**
     * @param args the command line arguments
     */
      public static void main(String[] args){
launch(args);
}
     
    
}
