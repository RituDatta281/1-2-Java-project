package chhatrihall;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rituparna Datta
 */
public class HomeController implements Initializable {

   Connection con=databaseconnector.db();
   
    PreparedStatement pre=null;
    ResultSet result=null;
    
    @FXML
    private TextField studentID;

    @FXML
    private Button submitButton;

    @FXML
    private TextField level;

    @FXML
    private TextField studentName;

    @FXML
    private TextField term;

    @FXML
    private TextField cgpa;
    @FXML
    private PasswordField pass;

    @FXML
    private TextField room;
    @FXML
    void submit(ActionEvent event) throws IOException, SQLException {
     
        double StudentID=Double.parseDouble(studentID.getText());
        String StudentName=studentName.getText();
        int Term=Integer.parseInt(term.getText());
        int Level=Integer.parseInt(level.getText());
        double CGPA=Double.parseDouble(cgpa.getText());
        String Password=pass.getText();
        String CurrentRoom=room.getText();
        
       
        String sql = "INSERT INTO studentprofile(StudentID,StudentName,Level,Term,CGPA,Password,CurrentRoom,Status) VALUES(?,?,?,?,?,?,?,'n/a')";
       
         
        pre=con.prepareStatement(sql);
        
        pre.setDouble(1, StudentID);
        pre.setString(2, StudentName);
        pre.setInt(3, Level);
        pre.setInt(4, Term);
        pre.setDouble(5, CGPA);
        pre.setString(6, Password);
        pre.setString(7, CurrentRoom);
        pre.execute();
        pre.close();
        
        
       ((Node)event.getSource()).getScene().getWindow().hide();
        Stage primaryStage = new Stage();
       Parent root=FXMLLoader.load(getClass().getResource("login_1.fxml"));
       Scene scene=new Scene(root);
       primaryStage.setScene(scene);
       primaryStage.show();

System.out.println(StudentID+" "+StudentName+" "+Level+" "+Term+" "+CGPA+" "+Password+" "+CurrentRoom);

    }




    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}