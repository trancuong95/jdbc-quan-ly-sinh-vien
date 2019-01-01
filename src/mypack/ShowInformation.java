/**
 * (C) Copyright 2018 TranCuong-GDP05. All Rights Reserved.
 *
 * @author TranCuong
 * @date Jan 1, 2019
 * @version 1.0
 */
package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowInformation {

    public void Display() {
        Connection cnn = null;
        PreparedStatement pst = null;
        // DbConnection dbcnn = new DbConnection();//khởi tạo lớp dbconnection để lấy dữ
        // liệu hay nói cách khác là khởi tạo kết nối đến db
        cnn = DbConnection.connection();
        String sql = "select * from sinhvien";
        try {
            pst = cnn.prepareStatement(sql); // truyền chuỗi sql vào cho prepareStatement thực thi
                                             // câu lệnh sql
            // khởi tạo resultset
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String masv = rs.getString("masv");
                String tensv = rs.getString("tensv");
                boolean gioitinh = rs.getBoolean("gioitinh");
                String ngaysinh = rs.getString("ngaysinh");
                String quequan = rs.getString("quequan");
                String malop = rs.getString("malop");
                System.out.println("masv: " + masv + ", tensv: " + tensv + ", gioitinh: " + gioitinh
                        + ", ngaysinh: " + ngaysinh + ", quequan: " + quequan + ", malop: "
                        + malop);
            }

        } catch (SQLException e) {
            System.out.println("Loi: " + e.getMessage());
        }

    }
}
