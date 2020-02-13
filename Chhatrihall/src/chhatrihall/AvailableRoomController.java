/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chhatrihall;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rituparna Datta
 */
public class AvailableRoomController implements Initializable{
        static double ID;
Connection connection = databaseconnector.db();
    Statement statement1 = null;
    Statement statement2=null;
    ResultSet result1 = null;
    ResultSet result2=null;
    String selectedroom=null;
    
      
    public ObservableList<Label> users = FXCollections.observableArrayList();
    public ObservableList<Label> users2 = FXCollections.observableArrayList();


    @FXML
    private Button submitButton;

    @FXML
    private ListView<Label> four;

    @FXML
    private ListView<Label> two;

    @FXML
    private Label fs;

    @FXML
    private Label ts;

    int studentID;
    double CGPA;
    int exRoom;
 
    void  setroom(int room,String id,double cg){
        exRoom=room;
        studentID=Integer.parseInt(id);
        CGPA=cg;
    }

    @FXML
    void seat2select(MouseEvent event) throws SQLException {
    System.out.println("clicked on " + two.getSelectionModel().getSelectedItems().get(0).getText());
    selectedroom = two.getSelectionModel().getSelectedItems().get(0).getText();
       StringTokenizer st= new StringTokenizer(selectedroom, " ( ");
        String RoomNo=st.nextToken();
        System.out.println(RoomNo);
        int vacant=Integer.parseInt(st.nextToken());
        System.out.println(vacant);

        request req=new request();
        req.setdata(studentID,CGPA,exRoom,RoomNo,vacant);
        setStatus setStat=new setStatus();
        setStat.set(studentID);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Request Sent! Wait for confirmation!");
        alert.showAndWait();
        
        ((Node)event.getSource()).getScene().getWindow().hide();
        
    
    }

    @FXML
    void seat4select(MouseEvent event) throws SQLException {
    System.out.println("clicked on " + four.getSelectionModel().getSelectedItems().get(0).getText());
    selectedroom = four.getSelectionModel().getSelectedItems().get(0).getText();
        StringTokenizer st= new StringTokenizer(selectedroom, " ( ");
        String RoomNo=st.nextToken();
        System.out.println(RoomNo);
        int vacant=Integer.parseInt(st.nextToken());
        System.out.println(vacant);

        request req=new request();
        req.setdata(studentID,CGPA,exRoom,RoomNo,vacant);
         setStatus setStat=new setStatus();
        setStat.set(studentID);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Request Sent! Wait for confirmation! ");
        alert.showAndWait();
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

   
    
    
    @FXML
    void submit(ActionEvent event) throws SQLException {
        ts.setText("Two Seated Room");
        fs.setText("Four Seated Room");
        String sql2 = "SELECT * FROM seat2";
        String sql4 = "SELECT * FROM seat4";
        statement1 = connection.createStatement();
        result1 = statement1.executeQuery(sql2);
        
        while (result1.next()) {
            if(result1.getInt("Vacant")!=0){
                int s1 = result1.getInt("RoomNo");
                String s2=Integer.toString(s1) + " ( ";
                String vac=Integer.toString(result1.getInt("Vacant"));
                s2=s2.concat(vac)+ " ) ";
//            int s1 = result1.getInt("RoomNo") + " ( ";
//            s2 = s2.concat(result1.getString("Vacant") + " ) ");
            
            Label lbl = new Label();
            lbl.setText(s2);
            lbl.setAlignment(Pos.CENTER);
            lbl.setPadding(new Insets(10, 10, 10, 10));

            users.add(lbl);
            System.out.println(s2);
            two.setItems(users);
            }
    }
        statement2=connection.createStatement();
        result2=statement2.executeQuery(sql4);
      while (result2.next()) {
            if(result2.getInt("Vacant")!=0){
                int s = result2.getInt("RoomNo");
                String s4=Integer.toString(s) + " ( ";
                String vac4=Integer.toString(result2.getInt("Vacant"));
                s4=s4.concat(vac4)+ " ) ";
            
            Label lbl2 = new Label();
            lbl2.setText(s4);
            lbl2.setAlignment(Pos.CENTER);
            lbl2.setPadding(new Insets(10, 10, 10, 10));

            users2.add(lbl2);
            System.out.println(s4);
            four.setItems(users2);
            }
            
    }   

    }
   
    @FXML
    void close(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    @FXML
void back(ActionEvent e) throws IOException {
        Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource("room.fxml").openStream());
       Scene scene=new Scene(root);
       scene.getStylesheets().add(getClass().getResource("roombooking.css").toExternalForm());
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
//      f=1;
//      RoomController roomController=(RoomController)loader.getController();
//       roomController.setinfo(result.getDouble("StudentID"),result.getString("StudentName"),result.getInt("Level"),result.getInt("Term"),result.getDouble("CGPA"),result.getString("Status"),result.getString("CurrentRoom"));
  }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}