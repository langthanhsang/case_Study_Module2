package CaseStudy2.manager;

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
                    Header.header();
                    StudentManage.sortByName();
                    break;
                case 2:
                    Header.header();
                    StudentManage.sortByPoint();
                    break;
                case 3:
                    Header.header();
                    StudentManage.sortByAge();
                    break;
            }
        } while ( choice != 0 );
    }
}