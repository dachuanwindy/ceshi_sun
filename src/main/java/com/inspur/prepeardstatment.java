package com.inspur;

import java.sql.*;

public class prepeardstatment {
    private final String db_driver = "oracle.jdbc.driver.OracleDriver";
    private final String url = "jdbc:oracle:thin:@127.0.0.1:1521:oraclesun";

    public prepeardstatment() {
    }

    public static void main(String[] args) throws SQLException {
        //调用prepeardstatment 类，
        prepeardstatment jdbctest1 = new prepeardstatment();
        jdbctest1.query();
    }

    public void query() throws SQLException {
        Connection conn = this.getconnection();
        String strsql = "select * from sun_ceshi where id = ?";
        PreparedStatement ps = conn.prepareStatement(strsql);
        ps.setString(1, "000000000000043");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ID"));
            System.out.println(rs.getString("url"));
        }
        System.out.println(rs.toString());
        rs.close();
        ps.close();
        conn.close();
    }

    //连接信息
    private Connection getconnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(db_driver);
            conn = DriverManager.getConnection(url, "sjcj", "sjcj");
        } catch (ClassNotFoundException ex) {
        }
        return conn;
    }
}

