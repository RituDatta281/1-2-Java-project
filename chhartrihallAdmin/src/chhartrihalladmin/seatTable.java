package chhartrihalladmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rituparna Datta
 */
public class seatTable {

    Connection con = DatabaseConnector.db();
    PreparedStatement pre = null;
    ResultSet res = null;

    public seatTable() {
    }
static double ID;

    void setData(String roomno, int id,String status) throws SQLException {
    
        ID=(double)id;


        String setstatus="UPDATE studentprofile SET CurrentRoom = ? , Status= ? WHERE StudentID = ?";        
        System.out.println("what?");
        pre=con.prepareStatement(setstatus);
        System.out.println("prepared");

        System.out.println("executing");
        
        pre.setString(1, roomno);
        pre.setString(2, status);
        pre.setDouble(3, ID);
        
        pre.executeUpdate();
        pre.close();
}
}