package CaseStudy2.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgeRegex {
//    public static final String ageRegex = "^\\d+$";
    public static final String ageRegex = "^[0-9]+$";

    public AgeRegex(){
    }
    public static boolean validate(String regex){
        Pattern pattern = Pattern.compile(ageRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
