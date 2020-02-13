package chhartrihalladmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

    Connection con = DatabaseConnector.db();
    PreparedStatement pre = null;

    void setdelete(int Id) throws SQLException {
        System.out.println("hello");
        String sql = "DELETE FROM Request WHERE StudentId = ?";
        pre = con.prepareStatement(sql);

        pre.setInt(1, Id);
        System.out.println("hi");
        pre.executeUpdate();
        System.out.println("there");
        con.close();

    }

    void setdeleteroom(String room) throws SQLException {
        System.out.println("hello");
        String sql = "DELETE FROM Request WHERE RoomNo = ?";
        pre = con.prepareStatement(sql);

        pre.setString(1, room);
        System.out.println("hi");
        pre.executeUpdate();
        System.out.println("there");
        con.close();

    }
}