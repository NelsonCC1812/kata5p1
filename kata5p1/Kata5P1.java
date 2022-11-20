package kata5p1;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {
    public static void main(String[] args) {

        String url;
        String sql;

        // => people query

        url = "jdbc:sqlite:people.db";
        sql = "select * from people";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                System.out.println(String.format("%d %s %s %s",
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getString("Apellidos"),
                        rs.getString("Departamento")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}