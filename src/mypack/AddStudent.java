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
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class AddStudent {
    // b1: import thư viện
    // b2.1: khởi tạo đối tượng connection, prepareStatement
    // b2.2: gán kết nối cho đối tượng connection vừa tạo
    // b3: thêm dữ liệu:
    // b3.1: vào trong mysql: tạo 1 bảng có tên student chứa 2 thuộc tính masv,
    // username trong csdl quản lý sinh viên
    // b3.2: khai báo chuỗi sql thêm dữ liệu
    // b3.3: khai báo các biến.
    // b4: truyền chuỗi sql vào trong đối tượng prepareStatement
    // b5: thực thi sql đó
    // b6: đóng đối tượng lại

    public void insertStudent() {
        Connection cnn = null;
        PreparedStatement pst = null;

        cnn = DbConnection.connection(); // gán kết nối cho đối tượng connection vừa tạo

        // thêm dữ liệu:
        System.out.print("Nhập mã sv: ");
        String masv = new Scanner(System.in).nextLine();
        System.out.print("Nhập tên sv: ");
        String tensv = new Scanner(System.in).nextLine();
        System.out.print("Nhập giới tính sv: ");
        boolean gioitinh = new Scanner(System.in).nextBoolean();
        System.out.print("Nhập ngày sinh: ");
        String ngaysinh = new Scanner(System.in).nextLine();
        System.out.print("Nhập quê quán: ");
        String quequan = new Scanner(System.in).nextLine();
        System.out.print("Nhập mã lớp: ");
        String malop = new Scanner(System.in).nextLine();

        // thêm hàm chỉnh sửa để tên chèn vào được đẹp hơn
        tensv = lamDepTen(tensv);

        // kiểm tra masv thêm vào có bị trùng không
        if (ktmssv(masv)) {
            // khai báo chuỗi sql thêm dữ liệu
            String sql = "insert into sinhvien values (?, ?, ?, ?, ?, ?)";

            try {
                pst = cnn.prepareStatement(sql); // truyền chuỗi sql vào trong đối tượng
                                                 // prepareStatement

                pst.setString(1, masv);
                pst.setString(2, tensv);
                pst.setBoolean(3, gioitinh);
                pst.setString(4, ngaysinh);
                pst.setString(5, quequan);
                pst.setString(6, malop);

                int kt = pst.executeUpdate();
                if (kt != 0) {
                    System.out.println("Insert thành công");
                } else {
                    System.out.println("Insert không thành công");
                }

                pst.close();
                cnn.close();

            } catch (SQLException e) {
                System.out.println("Loi: " + e.getMessage());
            }
        } else {
            System.out.println("Mã số sinh viên thêm vào bị trùng yêu cầu nhập lại");
        }
    }

    public String lamDepTen(String chuoiCanChinh) {
        String[] str = chuoiCanChinh.toLowerCase().trim().split("\\s+");
        String chuoiChinhSua = "";
        for (int i = 0; i < str.length; i++) {
            chuoiChinhSua += String.valueOf(str[i].charAt(0)).toUpperCase()
                    + str[i].substring(1).toLowerCase() + " ";
        }
        return chuoiChinhSua;
    }

    public boolean ktmssv(String masv) {
        // First: tạo kết nối đến db
        Connection cnn = null; // không thể khởi tạo một đối tượng do Connection là 1 interface
        PreparedStatement pst = null; // tương tự trên
        cnn = DbConnection.connection(); //
        String sql = "select masv from qlsv.sinhvien";
        try {
            pst = cnn.prepareStatement(sql); // prepareStatement extends từ Statement. cụ thể bước
                                             // này là bước thực thi câu lệnh sql
            // được truyền vào. Tạo prepareStatenment thực thi câu lệnh sql
            ResultSet rs = pst.executeQuery(); // xử lý kết quả trả về câu lệnh sql được thực thi
            while (rs.next()) { // bắt đầu duyệt để xét masv truyền vào từ hàm trên với từng mã
                                // trong rs.
                if (masv.equals(rs.getString("masv"))) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        return true;
    }
}
