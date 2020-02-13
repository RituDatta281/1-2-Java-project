package chhartrihalladmin;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class RequestTableController implements Initializable {

    ObservableList<Data> table = FXCollections.observableArrayList();
    Connection connect = DatabaseConnector.db();
    PreparedStatement pre = null;
    PreparedStatement pre2=null;
    ResultSet res2=null;
    ResultSet result = null;

    @FXML
    private TableColumn<?, ?> c3;

    @FXML
    private TableColumn<?, ?> c4;

    @FXML
    private TableColumn<?, ?> c5;

    @FXML
    private TableColumn<?, ?> c6;

    @FXML
    private TableView<Data> table1;

    @FXML
    private TableColumn<?, ?> c1;

    @FXML
    private TableColumn<?, ?> c2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("start");
        c1.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
        c2.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        c3.setCellValueFactory(new PropertyValueFactory<>("CGPA"));
        c4.setCellValueFactory(new PropertyValueFactory<>("ExRoom"));
        c5.setCellValueFactory(new PropertyValueFactory<>("Status"));
        c6.setCellValueFactory(new PropertyValueFactory<>("AvailableRoom"));
        try {
            loadTable();
            System.out.println("hello");
        } catch (SQLException ex) {
            Logger.getLogger(RequestTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadTable() throws SQLException {
        String sql = "SELECT * FROM Request ORDER BY RoomNo ASC,Class ASC,CGPA DESC";
        pre = connect.prepareStatement(sql);
        result = pre.executeQuery();

        while (result.next()) {

            table.add(new Data(result.getString("RoomNo"), result.getInt("StudentId"), result.getDouble("CGPA"), result.getInt("ExRoom"), result.getString("Status"), result.getInt("AvailableRoom")));
            table1.setItems(table);
        }
        pre.close();
        connect.close();
        System.out.println("done");

    }

    @FXML
    void showonclick(MouseEvent event) throws SQLException {
        System.out.println("clicked on " + table1.getSelectionModel().getSelectedItems().get(0).getRoomNo());
        String roomno = table1.getSelectionModel().getSelectedItem().RoomNo;
        int Id = table1.getSelectionModel().getSelectedItem().StudentId;
        int exroom = table1.getSelectionModel().getSelectedItem().ExRoom;
        double CGPA = table1.getSelectionModel().getSelectedItem().CGPA;
        String status = table1.getSelectionModel().getSelectedItem().Status;
        System.out.println(Id);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("Are you going to approve it?");
        alert.showAndWait();

        int vacancy = table1.getSelectionModel().getSelectedItem().AvailableRoom;
        System.out.println(vacancy);

        roominfo roomset = new roominfo();
        roomset.setRoomTable(vacancy, exroom);
        newroominfo newroom = new newroominfo();
        int v = newroom.setRoom(roomno);

        seatTable seat = new seatTable();
        seat.setData(roomno, Id, "Accepted");
        if (v == 0) {
            Delete del = new Delete();
            del.setdeleteroom(roomno);
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setHeaderText(null);
            alert2.setContentText("Now the Room is Full");
            alert2.showAndWait();    
        } 
        else if(v<0){
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setHeaderText(null);
            alert3.setContentText("You cannot access this room");
            alert3.showAndWait();
        }
        else {
            Delete delete = new Delete();
            delete.setdelete(Id);
        }

    }

    @FXML
    void close(ActionEvent event) {
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    
@FXML
    void clear(ActionEvent event) throws SQLException {
        String delete="SELECT * FROM Request";
        pre2=connect.prepareStatement(delete);
        res2=pre2.executeQuery();
        Delete dlt=new Delete();
        while(res2.next()){
            dlt.setdelete(res2.getInt("StudentId"));
        }
            Alert alert4 = new Alert(Alert.AlertType.CONFIRMATION);
            alert4.setHeaderText(null);
            alert4.setContentText("Deleted all requests.");
            alert4.showAndWait();   
    }


}