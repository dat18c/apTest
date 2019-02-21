package com.kea.ap;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String query
                = "SELECT vendor_name "
                + "FROM vendors "
                + "ORDER BY vendor_name ASC";
        String dbUrl = "jdbc:mysql://localhost:3306/ap";
        String username = "ap_tester";
        String password = "sesame";

        //JDBC objekter
        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            //Udskriv resultatsæt
            System.out.println("Leverandører\n");
            while (rs.next()){
                String vendorName = rs.getString("vendor_name");
                System.out.println(vendorName);
            }
            conn.close();
        }
        catch (SQLException e){
            System.out.println("SQL Error " + e.getMessage());
        }
    }
}
