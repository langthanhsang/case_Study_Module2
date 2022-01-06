package CaseStudy2.Model;

public class Student {
    private String id;
    private String name;
    private String age;
    private String gender;
    private String phone;
    private String gmail;
    private String address;
    private String avg;

    public Student(String id, String name, String age, String gender, String phone, String gmail, String address, String avg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.gmail = gmail;
        this.address = address;
        this.avg = avg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getage() {
        return age;
    }

    public void setage(String age) {
        this.age = age;
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getavg() {
        return avg;
    }

    public void setavg(String avg) {
        this.avg = avg;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-10s%-20s%-25s%-20s%-15s%-20s\n", id, name, age, gender, phone, gmail, address, avg);
    }


    public String display() {
        return id + "," + name + "," + age + "," + gender + "," + phone + "," + gmail + "," + address + "," + avg;
    }
}
