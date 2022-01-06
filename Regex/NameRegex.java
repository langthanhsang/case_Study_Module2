package CaseStudy2.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameRegex {
    public static final String nameRegex = "^[^\\d]+$";
//    public static final String nameRegex = "^[a-z]+$";

    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
