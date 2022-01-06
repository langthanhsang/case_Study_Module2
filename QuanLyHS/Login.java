package CaseStudy2.QuanLyHS;

import CaseStudy2.IOOFile.IOOFile;
import CaseStudy2.Regex.UserPassRegex;

import java.util.List;
import java.util.Scanner;

public class Login {
    public static User loginUser;
    public static List<User> userList = IOOFile.readUserFile();
    static Scanner sc = new Scanner(System.in);

    public static void login() {
        int choice;
       do {
           System.out.println();
           System.out.println("|*******************************************************|");
           System.out.println("|--CHÀO MỪNG BẠN ĐẾN VỚI CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH--|");
           System.out.println("|                 1. Đăng nhập                          |");
           System.out.println("|                 2. Đăng ký mới                        |");
           System.out.println("|                 0. Thoát                              |");
           System.out.println("|                 Mời bạn chọn                          |");
           System.out.println("|*******************************************************|");

           choice = Integer.parseInt(sc.nextLine());
           switch (choice) {
               case 1:
                   int choice1 = 100;
                   do {
                       System.out.println("|***********************************|");
                       System.out.println("| 1. Đăng nhập bằng tài khoản ADMIN |");
                       System.out.println("| 2. Đăng nhập bằng tài khoản User  |");
                       System.out.println("| 3. Thoát                          |");
                       System.out.println("| Mời bạn chọn                      |");
                       System.out.println("|***********************************|");

                       try {
                           choice1 = Integer.parseInt(sc.nextLine());

                       } catch (Exception e) {
                       }
                       if (choice1 == 3) {
                           login();
                       }
                       switch (choice1) {
                           case 1:
                               logInAdmin();
                               break;
                           case 2:
                               logInUser();
                               break;
                       }
                   }while ( choice!=0 );
               case 2:
                   System.out.println("Đăng ký người dùng mới");
                   String user = getUserName();
                   String pass = getPassword();
                   userList.add(new User(user, pass));
                   IOOFile.writeUserFile();
                   break;

           }

        }while ( choice !=0 );
    }




    private static void logInUser() {
        int choice = 100;
       do {
            System.out.println("|**************|");
            System.out.println("| ----Menu---- |");
            System.out.println("| 1. Tiếp tục  |");
            System.out.println("| 2. Thoát     |");
            System.out.println("|**************|");

            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
            }
            if (choice == 2) {
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("Tài Khoản :");
                    String username = sc.nextLine();
                    System.out.println("Mật khẩu");
                    String password = sc.nextLine();
                    boolean login = false;
                    for (User user : userList) {
                        if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                            System.out.println("Xin chào " + user.getUsername());
                            login = true;
                            loginUser = user;
                            StudentManage.readFile();
                        }
                    }
                    if (login) {
                        Menu.menuUser();
                    } else {
                        System.err.println("Sai tài khoản hoặc mật khẩu");
                    }
                    break;
            }
        }while (choice !=0 );
    }

    private static void logInAdmin() {
        int choice = 99;
       do {
            System.out.println("|**************|");
            System.out.println("| ----Menu---- |");
            System.out.println("| 1. Tiếp tục  |");
            System.out.println("| 2. Thoát     |");
            System.out.println("|**************|");

            try {
                choice = Integer.parseInt(sc.nextLine());

            } catch (Exception e) {
            }
            if (choice == 2) {
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("Tài Khoản :");
                    String username = sc.nextLine();
                    System.out.println("Mật khẩu");
                    String password = sc.nextLine();
                    boolean login = false;
                    if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
                        System.out.println("Xin chào " + username);
                        login = true;
                        StudentManage.readFile();
                    }
                    if (login) {
                        Menu.menuAdmin();
                    } else {
                        System.err.println("Sai tài khoản hoặc mật khẩu");
                    }
                    break;
            }
        }while ( choice != 0 );
    }

    private static String getUserName() {
        while ( true ) {
            try {
                System.out.println("Tài khoản");
                String username = sc.nextLine();
                if (UserPassRegex.validate(username)) {
                    boolean exit = false;
                    for (User user : userList) {
                        if (user.getUsername().equalsIgnoreCase(username)) {
                            System.err.println("Tài khoản đã tồn tại");
                            exit = true;
                        }
                    }
                    if (!exit) {
                        return username;
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Tài khoản có ít nhất 1 ký tự");
            }
        }
    }

    private static String getPassword() {
        while ( true ) {
            try {
                System.out.println("Mật khẩu");
                String password = sc.nextLine();
                if (UserPassRegex.validate(password)) {
                    return password;
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Mật khẩu ít nhất phải có 1 ký tư");
            }
        }
    }
}
