package chhartrihalladmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class roominfo {

    Connection connection=DatabaseConnector.db();
    Statement state2=null;
    ResultSet result2=null;
    PreparedStatement pre1=null;
    PreparedStatement pre2=null;
    Statement state4=null;
    ResultSet result4=null;
    public roominfo() {
    }
    int exroom;
    
    void setRoomTable(int vacancy, int exRoom) throws SQLException{
    int f=0;
    exroom=exRoom;
    String sql2 = "SELECT * FROM seat2";
    String sql4 = "SELECT * FROM seat4";
    state2=connection.createStatement();
    result2=state2.executeQuery(sql2);
    state4=connection.createStatement();
    result4=state4.executeQuery(sql4);
    while(result2.next()){
        if(exroom==result2.getInt("RoomNo"))
        {
        int v=result2.getInt("Vacant");  
        v=v+1;
        String set="UPDATE seat2 SET Vacant = ? WHERE RoomNo = ? ";        
        System.out.println("seat2");
        pre1=connection.prepareStatement(set);
        System.out.println("executing seat2");
        
        pre1.setInt(1, v);
        pre1.setInt(2, exroom);
        pre1.executeUpdate();
        pre1.close();
        f=1;
        break;
        
        }
        
            
    }
     if(f==0){
    while(result4.next()){
        if(exroom==result4.getInt("RoomNo"))
        {
        int v2=result4.getInt("Vacant");
        v2=v2+1;
        String set2="UPDATE seat4 SET Vacant = ? WHERE RoomNo = ? ";        
        System.out.println("seat4");
        pre2=connection.prepareStatement(set2);
        System.out.println("executing seat 4");
        
        pre2.setInt(1, v2);  
        pre2.setInt(2, exroom);
        pre2.executeUpdate();
        pre2.close();
        break;
        }
        
            
    }
     }
    
    state2.close();
    result2.close();
    state4.close();
    result4.close();
    
    
    
    
   
    }
    
}