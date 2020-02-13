
package chhatrihall;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoginController2 implements Initializable{

    Connection con=databaseconnector.db();
    Statement state=null;
    ResultSet result=null;
    
    @FXML
    private PasswordField pass;

    @FXML
    private TextField idText;

    @FXML
    private Button sendButton;
   
    @FXML
    private Button reg;

    @FXML
    void login(ActionEvent event) throws IOException, SQLException {
    double id=Double.parseDouble(idText.getText());
    String password=pass.getText();
    
    
    System.out.println(id);
    System.out.println(password);
    String sql = "SELECT * FROM studentprofile";
    state=con.createStatement();
    result=state.executeQuery(sql);
    
    ((Node)event.getSource()).getScene().getWindow().hide();
    int f=0;
   
    while(result.next()) {
        if (id==(result.getDouble("StudentID")) && password.equals(result.getString("Password"))) {

    Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("room.fxml").openStream());
       Scene scene=new Scene(root);
       scene.getStylesheets().add(getClass().getResource("roombooking.css").toExternalForm());
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
       f=1;
       RoomController roomController=(RoomController)loader.getController();
       roomController.setinfo(result.getDouble("StudentID"),result.getString("StudentName"),result.getInt("Level"),result.getInt("Term"),result.getDouble("CGPA"),result.getString("Status"),result.getString("CurrentRoom"));

}
       
                
            }
     
    if(f==0){
    Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("Invalid login! Try again!");
        alert.showAndWait();
    }
    
    
    }
    @FXML
    void send(ActionEvent event) throws IOException {

        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
     Parent root=FXMLLoader.load(getClass().getResource("Studentprofile_1.fxml"));
       Scene scene=new Scene(root);
       scene.getStylesheets().add(getClass().getResource("studentprofile.css").toExternalForm());
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
      
    }

    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}