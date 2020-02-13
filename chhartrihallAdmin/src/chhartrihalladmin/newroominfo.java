package chhartrihalladmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class newroominfo {

    Connection connection = DatabaseConnector.db();
    Statement state2 = null;
    ResultSet result2 = null;
    PreparedStatement pre1 = null;
    PreparedStatement pre2 = null;
    Statement state4 = null;
    ResultSet result4 = null;

    public newroominfo() {
    }
    int room;

    int setRoom(String roomno) throws SQLException {
        int vac = 0;
        int b = 0;
        String sql2 = "SELECT * FROM seat2";
        String sql4 = "SELECT * FROM seat4";
        state2 = connection.createStatement();
        result2 = state2.executeQuery(sql2);
        state4 = connection.createStatement();
        result4 = state4.executeQuery(sql4);
        room = Integer.parseInt(roomno);
        while (result2.next()) {
            if (room == result2.getInt("RoomNo")) {
                int v = result2.getInt("Vacant");
                v = v - 1;
                String set = "UPDATE seat2 SET Vacant = ? WHERE RoomNo = ? ";
                System.out.println("new seat2");
                pre1 = connection.prepareStatement(set);
                System.out.println("executing new seat2");

                pre1.setInt(1, v);
                pre1.setInt(2, room);
                pre1.executeUpdate();
                pre1.close();
                vac = v;
                b = 1;
                break;
            }

        }

        if (b == 0) {
            while (result4.next()) {
                if (room == result4.getInt("RoomNo")) {
                    int v2 = result4.getInt("Vacant");
                    v2 = v2 - 1;
                    String set2 = "UPDATE seat4 SET Vacant = ? WHERE RoomNo = ? ";
                    System.out.println("new seat2");
                    pre2 = connection.prepareStatement(set2);
                    System.out.println("executing new seat 4");

                    pre2.setInt(1, v2);
                    pre2.setInt(2, room);
                    pre2.executeUpdate();
                    pre2.close();
                    vac = v2;
                    break;
                }

            }
        }
        state2.close();
        result2.close();

        state4.close();
        result4.close();
        return vac;

    }
}