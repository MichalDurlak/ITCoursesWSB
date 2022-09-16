package pl.michaldurlak;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        ArrayList<String> testSiteResult = InformatykaScraping.getTestSiteResult();
        SendEmail.sendEmailTest("kontakt@michaldurlak.pl","WSB Courses", String.valueOf(testSiteResult));

    }
}