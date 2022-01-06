package CaseStudy2.QuanLyHS;


import CaseStudy2.Exception.AgeException;
import CaseStudy2.Exception.ScoreException;
import CaseStudy2.IOOFile.IOOFile;
import CaseStudy2.Regex.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManage {
    public static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public StudentManage() {
    }

    public static void showALL() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void showHSG() {
        for (Student student : students) {
            if (Integer.parseInt(student.getavg()) >= 8) {
                System.out.println(student);
            }
        }
    }

    public static void showHSK() {
        for (Student student : students) {
            if (Integer.parseInt(student.getavg()) < 8 && Integer.parseInt(student.getavg()) >= 5) {
                System.out.println(student);
            }
        }
    }

    public static void showHSTB() {
        for (Student student : students) {
            if (Integer.parseInt(student.getavg()) < 5 && Integer.parseInt(student.getavg()) >= 1) {
                System.out.println(student);
            }
        }
    }

    public static void add() {
        String id = getId();
        String name = getName();
        String age = getAge();
        String gender = getGender();
        String phone = getPhone();
        String gmail = getGmail();
        String address = getAddress();
        String avg = getAvg();
        students.add(new Student(id, name, age, gender, phone, gmail, address, avg));
        IOOFile.writeFile();

    }

    private static String getId() {
        while ( true ) {
            try {
                System.out.println("Nhập ID");
                String id = sc.nextLine();
                if (IDRegex.validate(id)) {
                    boolean check = true;
                    for (Student student : students) {
                        if (student.getId().equals(id)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return id;
                    } else {
                        System.err.println("ID đã tồn tại nhập lại ID");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Mã học sinh với 6 chữ số");
            }
            IOOFile.writeFile();
        }


    }

    private static String getPhone() {
        while ( true ) {
            try {
                System.out.println("Nhập số điện thoại");
                String number = sc.nextLine();
                if (PhoneNumberRegex.validate(number)) {
                    boolean check = true;
                    for (Student student : students) {
                        if (student.getavg().equals(number)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return number;
                    } else {
                        System.err.println("SĐT đã tồn tại. Nhập lại SĐT");
                    }
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("Số điện thoại phải bắt đầu từ số 0 và theo sau 9 số");
            }
        }
    }

    private static String getName() {
        while ( true ) {
            try {
                System.out.println("Nhập họ & tên");
                String name = sc.nextLine();
                if (NameRegex.validate(name)) {
                    return name;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Tên không được là số và không được để trống");
            }
        }
    }

    private static String getAge() {
        while ( true ) {
            try {
                System.out.println("Nhập tuổi");
                String age = sc.nextLine();
                if (AgeRegex.validate(age)) {
                    if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 70) {
                        throw new AgeException();
                    } else {
                        return age;
                    }
                } else {
                    throw new Exception();
                }
            } catch (AgeException age) {
                System.err.println("Người này quá già hoặc quá trẻ để đi học");
            } catch (Exception e) {
                System.err.println("Tuổi phải là số");
            }
        }
    }

    private static String getGender() {
        while ( true ) {
            try {
                System.out.println("Giới tính");
                String gender = sc.nextLine();
                if (GenderRegex.validate(gender)) {
                    return gender;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Giới tính bắt buộc phải là nam hoặc nữ");
            }
        }
    }


    private static String getGmail() {
        while ( true ) {
            try {
                System.out.println("Nhập vào gmail");
                String gmail = sc.nextLine();
                if (GmailRegex.validate(gmail)) {
                    boolean check = true;
                    for (Student student : students) {
                        if (student.getGmail().equals(gmail)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        return gmail;
                    } else {
                        System.err.println("Gmail đã tồn tại. Nhập lại gmail");
                    }


                } else throw new Exception();

            } catch (Exception e) {
                System.err.println("Gmail bắt buộc phải là định dạng .....@gmail.com");
            }
        }
    }

    private static String getAddress() {
        System.out.println("Nhập địa chỉ");
        return sc.nextLine();
    }

    private static String getAvg() {
        while ( true ) {
            try {
                System.out.println("Nhập điểm trung bình");
                String diemTB = sc.nextLine();
                if (ScoreRegex.validate(diemTB)) {
                    if (Double.parseDouble(diemTB) < 0 || Double.parseDouble(diemTB) > 10) {
                        throw new ScoreException();
                    } else return diemTB;
                } else throw new Exception();
            } catch (ScoreException diemTB) {
                System.err.println("Điểm TB phải > 0 và <= 10");
            } catch (Exception e) {
                System.err.println("Sai định dạng");
            }
        }
    }

    public static void update() {
        System.out.println("nhập id cần sủa!");
        String id = sc.nextLine();
        Student studentUpdate = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentUpdate = student;
                System.out.println("nhập tên mới");
                studentUpdate.setname(sc.nextLine());
                System.out.println("nhập tuổi mới");
                studentUpdate.setage(sc.nextLine());
                System.out.println("nhập giới tính mới!");
                studentUpdate.setgender(sc.nextLine());
                System.out.println("nhập số điện thoại mới");
                studentUpdate.setphone(sc.nextLine());
                System.out.println("nhập email mới!");
                studentUpdate.setGmail(sc.nextLine());
                System.out.println("nhập địa chỉ mới!");
                studentUpdate.setaddress(sc.nextLine());
                System.out.println("nhập điểm trung bình mới!");
                studentUpdate.setavg(sc.nextLine());
            }
        }
        writeFile();
    }

    public static void delete() {
        System.out.println("Nhập ID học sinh cần xóa ");
        String idDelete = sc.nextLine();
        System.err.println("Cảnh báo !!!!");
        System.out.println("Bạn có thật sự muốn xóa");
        System.out.println("1 . Có");
        System.out.println("2 . Không");
        int choice = 99;
        try {
            choice = Integer.parseInt(sc.nextLine());

        } catch (Exception e) {
            System.err.println("Vui lòng nhập đúng");
        }
        if (choice == 1) {
            students.removeIf(hocSinh -> hocSinh.getId().equals(idDelete));
        }
    }

    public static void sortTheoTen() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getname().compareTo(o2.getname());
            }
        });
        showALL();
    }

    public static void sortTheoDiem() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (Double.parseDouble(o1.getavg()) > Double.parseDouble(o2.getavg()))
                    return 1;
                else if (Double.parseDouble(o1.getavg()) < Double.parseDouble(o2.getavg())) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        showALL();
    }

    public static void sortTheoTuoi() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (Integer.parseInt(o1.getage()) > Integer.parseInt(o2.getage())) return 1;
                else return -1;
            }
        });
        showALL();
    }

    public static void searchHS() {
        int choice;
        do {
            System.out.println("|******************************************************************|");
            System.out.println("|                       ----Menu----                               |");
            System.out.println("| 1. Tìm kiếm  học sinh theo ID                                    |");
            System.out.println("| 2. Tìm kiếm nhiều học sinh cùng Họ hoặc Tên hoặc ký tự liên quan |");
            System.out.println("| 0. Thoát                                                         |");
            System.out.println("|******************************************************************|");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào id :");
                    String id = sc.nextLine();
                    boolean check = false;
                    for (Student student : students) {
                        if (student.getId().equals(id)) {
                            System.out.println(student);
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        return;
                    } else {
                        System.err.println("Không có kết quả");
                    }
                    break;
                case 2:
                    System.out.println("Nhập vào tên :");
                    String name = sc.nextLine();
                    boolean check2 = false;
                    for (Student student : students) {
                        if (student.getname().equals(name)) {
                            System.out.println(student);
                            check2 = true;
                        }
                    }
                    if (check2) {
                        return;
                    } else {
                        System.err.println("Không có kết quả");
                    }
                    break;
            }
        } while ( choice != 0 );
    }

    public static void readFile() {
        students = IOOFile.readFile();
    }

    public static void writeFile() {
        IOOFile.writeFile();
    }
}
