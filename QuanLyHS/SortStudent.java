package CaseStudy2.QuanLyHS;

import java.util.Scanner;

public class SortStudent {

    static Scanner sc = new Scanner(System.in);
    public static void sort() {
        int choice;
        do {
            System.out.println("|==================================|");
            System.out.println("|          ----Menu----            |");
            System.out.println("| 1 . Sắp xếp theo tên             |");
            System.out.println("| 2 . Sắp xếp theo điểm trung bình |");
            System.out.println("| 3 . Sắp xếp theo tuổi            |");
            System.out.println("| 0 . Thoát                        |");
            System.out.println("| Mời bạn chọn                     |");
            System.out.println("|==================================|");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManage.sortTheoTen();
                    break;
                case 2:
                    StudentManage.sortTheoDiem();
                    break;
                case 3:
                    StudentManage.sortTheoTuoi();
                    break;
                default:
                    System.err.println("Vui lòng nhập đúng");
            }
        } while ( choice != 0 );
    }
}