/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Alert {
    
    public static void display(String Title, String Text){
        Stage window = new Stage();
       window.setTitle(Title);
       Label lbl = new Label();
       lbl.setText(Text);
       GridPane g = new GridPane();
       g.setAlignment(Pos.CENTER);
       g.add(lbl,1,0);
       g.setMinSize(200,70);
       Scene s; s = new Scene(g);
       window.setScene(s);
       window.showAndWait();
    }
}
