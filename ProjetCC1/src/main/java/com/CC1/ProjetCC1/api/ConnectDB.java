package com.CC1.ProjetCC1.api;

import java.sql.*;

public class ConnectDB {
    public String connectDB(String request, String method) {
        String result = "";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cc1?autoReconnect=true&useSSL=false","root","root");
            System.out.println("Connexion réussie");
            Statement stmt = con.createStatement();
            ResultSet rs = null;

            if(method=="INSERT" || method=="DELETE" || method=="UPDATE") {
                stmt.executeUpdate(request);
            }
            if(method == "PASSWORD" || method == "ID") {
                rs = stmt.executeQuery(request);
                while(rs.next())
                    result += rs.getString(1);
            }

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
}
