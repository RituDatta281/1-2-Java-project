/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chhatrihall;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rituparna Datta
 */
public class RoomController implements Initializable {

    @FXML
    private Button submitbutton2;

    @FXML
    private TextField exRoom;

    @FXML
    private TextField level;

@FXML
    private TextField stat;
    @FXML
    private TextField name;

    @FXML
    private TextField term;

    @FXML
    private TextField id;
     @FXML
    private TextField croom;

    double cgpa;

    void setinfo(double studentID, String studentName, int Level, int Term, double cg,String status,String currentroom) {
        int x = (int) studentID;

        id.setText(Integer.toString(x));
        name.setText(studentName);
        level.setText(Integer.toString(Level));
        term.setText(Integer.toString(Term));
        cgpa = cg;
        stat.setText(status);
        croom.setText(currentroom);
    }

    @FXML
    void submit2(MouseEvent event) throws IOException, SQLException {

//        int roomno = Integer.parseInt(exRoom.getText());

        ((Node) event.getSource()).getScene().getWindow().hide();
//        if (roomno <= 100 || roomno >= 600) {
//
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setHeaderText(null);
//            alert.setContentText("Invalid Room Number!");
//            alert.showAndWait();

//        } else {
            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("availableRoom.fxml").openStream());
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("roomNumber.css").toExternalForm());
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
            int roomno=Integer.parseInt(croom.getText());
            AvailableRoomController availableRoomController = (AvailableRoomController) loader.getController();
            availableRoomController.setroom(roomno, id.getText(),cgpa);
//        }

    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
