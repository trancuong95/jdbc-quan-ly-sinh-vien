/**
 * (C) Copyright 2018 TranCuong-GDP05. All Rights Reserved.
 *
 * @author TranCuong
 * @date Jan 1, 2019
 * @version 1.0
 */
package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // bước 1: import thư viện có tên là java.sql
    // bước 2: load jdbc driver
    // bước 3: kết nối với mysql sử dụng getConnection (thuộc class driverManager)
    // khởi tạo một đối tượng có tên là Connection
    // chúng ta phải khởi tạo url, username, password
    // bước 4: đóng connection lại

    public static Connection connection() {
        Connection cnn = null;
        String url = "jdbc:mysql://localhost:3306/qlsv";
        String user = "root";
        String password = "3690";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {

            System.out.println("Load driver khong thanh cong");
        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }
        return cnn;

    }
}
