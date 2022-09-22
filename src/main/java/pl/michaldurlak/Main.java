package pl.michaldurlak;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

//        ArrayList<String> testSiteResult = InformatykaScraping.getTestSiteResult();
//        SendEmail.sendEmailTest("kontakt@michaldurlak.pl","WSB Courses", String.valueOf(testSiteResult));

//        InformatykaScraping.getTestSiteResult();
//        InformatykaScraping.getTestSiteResult("BHP,Informatyka,Języki");

        String allCourses = String.valueOf(InformatykaScraping.getTestSiteResult("Informatyka"));
        boolean ifNeedSendEmail = FileUtil.checkFile("infCourses.txt", allCourses);
        if (ifNeedSendEmail == true) {
            SendEmail.sendEmailTest("kontakt@michaldurlak.pl","WSB Courses", allCourses);
        }
//        SendEmail.sendEmailTest("kontakt@michaldurlak.pl","WSB Courses", allCourses);
//        FileUtil.saveToFile("infCourses.txt",allCourses);
    }
}