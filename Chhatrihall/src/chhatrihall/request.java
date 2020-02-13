package chhatrihall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class request {

    Connection con=databaseconnector.db();
   
    PreparedStatement pre=null;

  
    
   void setdata(int Id,double CGPA, int exroom, String preference, int vacant) throws SQLException{
    String sql = "INSERT INTO Request(RoomNo,StudentId, CGPA, ExRoom, Status, AvailableRoom,Class) VALUES(?,?,?,?,?,?,?)";
       System.out.println(preference+" "+exroom+" "+ Id+ " "+CGPA+ " ");
       pre=con.prepareStatement(sql);
        int seniority=Id/100000;
        pre.setString(1, preference);
        pre.setInt(2, Id);
        pre.setDouble(3, CGPA);
        pre.setInt(4, exroom);
        pre.setInt(6, vacant);
        pre.setInt(7, seniority);
        pre.execute();
        pre.close();

   }
    
    
}