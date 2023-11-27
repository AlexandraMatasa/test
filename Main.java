import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/bancar";
            String user = "root";
            String password = "Matasaalexandra22";
            Scanner scn = new Scanner(System.in);
            System.out.print("Introdu un nume:\n|> ");
            String nm = scn.nextLine();
            System.out.println("Clientii cu numele de familie " + nm + " sunt: ");
            String sql = "SELECT * FROM client WHERE nume = ?";
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nm);
            ResultSet res = pst.executeQuery();
//            Statement stmt  = conn.createStatement();
//            String sql = "SELECT * FROM client";
//            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                int id = res.getInt("id");
                String nume = res.getString("nume");
                String prenume = res.getString("prenume");
                System.out.println("id: " + id + "\tnume: " + nume + "\tprenume: " + prenume);
            }
            System.out.println("YAY");
            // more processing here
            // ...
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
