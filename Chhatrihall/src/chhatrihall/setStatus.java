package chhatrihall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class setStatus {
    Connection connection = databaseconnector.db();
    PreparedStatement pre=null;

    public setStatus() {
    }
    
    static double ID;
    
    void set(int Id) throws SQLException{
        ID=(double)Id;
        
        String s1="UPDATE studentprofile SET Status = ? WHERE StudentID = ?";
        
        System.out.println(ID);
        pre=connection.prepareStatement(s1);
        pre.setString(1, "Pending");
        pre.setDouble(2, ID);
        pre.executeUpdate();
        System.out.println("done");
        pre.close();
    }
}


