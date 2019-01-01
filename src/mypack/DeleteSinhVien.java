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
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteSinhVien {
    public void deleteSinhVien() {
        Connection cnn = DbConnection.connection();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên cần xoá: ");
        String masv = sc.nextLine();
        String sql = "delete from sinhvien where masv = ?";
        try {
            PreparedStatement pst = cnn.prepareStatement(sql);
            pst.setString(1, masv);
            int kt = pst.executeUpdate();
            if (kt != 0) {
                System.out.println("xoá thành công");
            }
            pst.close();
            cnn.close();

        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
