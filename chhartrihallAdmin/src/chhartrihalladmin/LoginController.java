package chhartrihalladmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private TextField username;

    @FXML
    void login(ActionEvent event) throws IOException {
       if((username.getText().equals("admin"))&& (password.getText().equals("buet"))){
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
       Parent root=FXMLLoader.load(getClass().getResource("RequestTable.fxml"));
       
       Scene scene=new Scene(root);
       scene.getStylesheets().add(getClass().getResource("RequestTable.css").toExternalForm());
       primaryStage.setScene(scene);
       primaryStage.show();
       
        }
       else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Invalid Login");
        alert.showAndWait();
        ((Node)event.getSource()).getScene().getWindow().hide();
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
