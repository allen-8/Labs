package Java_lab23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab23 {
    public static String deleteVowels(String str)
    {
        return str.replaceAll("[aeyuoiEUIOA]", "");
    }
    public static boolean isNumber(String str)
    {
        return str.matches("[+]\\d{6}");
    }
    public static String editString(String str)
    {
        Pattern p = Pattern.compile("[^[.]]\\d+[^[.]]");
        Matcher m = p.matcher(str);
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (m.find()) {
            if (sb.isEmpty())
                sb.append(str.substring(0, m.start()));
            sb.append(str.substring(m.start(), m.end() - 1));
            sb.append(".0");
            end = m.end() + 1;
            System.out.println(sb.toString());
        }
        if (sb.isEmpty())
            return str;
        sb.append(str.substring(end, str.length()));
        return sb.toString();
    }
    public static void main(String[] args)
    {
        String str = "telephone";
        System.out.println(deleteVowels(str));
        String num = "+123456", notNum = "abcd";
        System.out.println(isNumber(num));
        System.out.println(isNumber(notNum));
        System.out.println(editString("расходы 20 доходы 50.3"));
    }
}
