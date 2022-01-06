package CaseStudy2.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreRegex {
//    bất kì tự nào từ 0->9
    public static final String scoreRegex = "^[0-9]+$";

    public ScoreRegex(){
    }
    public static boolean validate(String regex){
        Pattern pattern = Pattern.compile(scoreRegex);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
