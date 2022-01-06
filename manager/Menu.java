package CaseStudy2.manager;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    public static void menuAdmin() {
        int choice;
        do {
            System.out.println("|******************************************|");
            System.out.println("|   ---CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH---    |");
            System.out.println("| 1. Thêm mới học sinh                     |");
            System.out.println("| 2. Hiển thị thông tin học sinh           |");
            System.out.println("| 3. Sửa đổi thông tin học sinh            |");
            System.out.println("| 4. Xóa học sinh                          |");
            System.out.println("| 5. Sắp xếp học sinh                      |");
            System.out.println("| 6. Tìm kiếm học sinh                     |");
            System.out.println("| 7. Ghi học sinh vào File                 |");
            System.out.println("| 8. Đọc học sinh vào File                 |");
            System.out.println("| 0. Thoát                                 |");
            System.out.println("| Mời bạn chọn                             |");
            System.out.println("|******************************************|");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManage.add();
                    break;
                case 2:
                    ShowStudent.show();
                    break;
                case 3:
                    StudentManage.update();
                    break;
                case 4:
                    StudentManage.delete();
                    break;
                case 5:
                    SortStudent.sort();
                    break;
                case 6:
                    StudentManage.searchHS();
                    break;
                case 7:
                    StudentManage.writeFile();
                    System.out.println("ghi file thành công!");
                    break;
                case 8:
                    StudentManage.readFile();
                    break;
            }
        }while ( choice !=0 );

    }

    public static void menuUser() {
        int choice;
        do {
            System.out.println("|******************************************|");
            System.out.println("|   ---CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH---    |");
            System.out.println("| 1. Hiển thị thông tin học sinh           |");
            System.out.println("| 2. Tìm kiếm học sinh                     |");
            System.out.println("| 3. Sắp xếp học sinh                      |");
            System.out.println("| 4. Ghi học sinh vào File                 |");
            System.out.println("| 5. Đọc học sinh vào File                 |");
            System.out.println("| 0. Thoát                                 |");
            System.out.println("| Mời bạn chọn                             |");
            System.out.println("|******************************************|");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ShowStudent.show();
                    break;
                case 2:
                    StudentManage.searchHS();
                    break;
                case 3:
                    SortStudent.sort();
                    break;
                case 4:
                    StudentManage.writeFile();
                    break;
                case 5:
                    StudentManage.readFile();
                    break;
            }
        } while ( choice != 0 );

    }
}
