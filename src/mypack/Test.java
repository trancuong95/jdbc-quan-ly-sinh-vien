/**
 * (C) Copyright 2018 TranCuong-GDP05. All Rights Reserved.
 *
 * @author TranCuong
 * @date Jan 1, 2019
 * @version 1.0
 */
package mypack;

import java.util.Scanner;

public class Test {
    static void Menu() {
        System.out.println("======================================");
        System.out.println("      MỜI NHẬP CHỨC NĂNG");
        System.out.println("  1. Thêm thông tin sinh viên");
        System.out.println("  2: Xoá thông tin sinh viên");
        System.out.println("  3: Hiển thị danh sách sinh viên");
        System.out.println("  4: Thoát");
        System.out.println("======================================");
    }

    public static void main(String[] args) {
        Menu();
        int choose;
        ShowInformation showListStudent = new ShowInformation();
        do {
            System.out.print("Mời chọn chức năng 1 đến 4: ");
            choose = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (choose) {
            case 1:
                AddStudent insertInfoStudent = new AddStudent();
                insertInfoStudent.insertStudent();
                break;
            case 2:
                DeleteSinhVien deleteInfoStudent = new DeleteSinhVien();
                deleteInfoStudent.deleteSinhVien();
                break;
            case 3:
                ShowInformation showInfoStudent = new ShowInformation();
                showInfoStudent.Display();
                break;
            case 4:
                System.out.println("Thoát chương trình");
                return;
            default:
                System.out.println("Bạn cần chọn đúng các chức năng trên");
            }
        } while (true);
    }
}
