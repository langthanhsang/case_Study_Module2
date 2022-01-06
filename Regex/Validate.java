package CaseStudy2.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final String ageRegex = "^[0-9]+$";
    public static final String genderRegex = "^[Nn][Aa][Mm]+|[Nn][Uu]$";
    public static final String gmailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*(@gmail.com)$";
    public static final String idRegex = "^\\d{6}$";
    public static final String nameRegex = "^[^\\d]+$";
    public static final String numberRegex = "^[0]\\d{9}$";
    public static final String scoreRegex = "^[0-9]+$";
    public static final String userRegex = "[^\\s]+";

    public Validate() {
    }
    public static boolean validateGender( String regex){
        Pattern pattern = Pattern.compile(genderRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateAge( String regex){
        Pattern pattern = Pattern.compile(ageRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateGmail( String regex){
        Pattern pattern = Pattern.compile(gmailRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public  static boolean validateId( String regex){
        Pattern pattern = Pattern.compile(idRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean validateName( String regex){
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public  static boolean validateNumber( String regex){
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public  static boolean validateScore( String regex){
        Pattern pattern = Pattern.compile(scoreRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public  static boolean validateUser( String regex){
        Pattern pattern = Pattern.compile(userRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
