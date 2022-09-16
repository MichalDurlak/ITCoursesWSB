package pl.michaldurlak;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;


public class InformatykaScraping {

    private static String URL = "https://www.wsb.pl/studia-i-szkolenia/szkolenia-i-kursy/listing-szkolen";


    private static ArrayList<String> listOfAllCourses = new ArrayList<>();
    public static ArrayList<String> getTestSiteResult(){

        WebClient webClient = setupWebClient();
        Document parsedDocument;


        try {
            HtmlPage page = webClient.getPage(URL);
            webClient.waitForBackgroundJavaScript(10000);
            parsedDocument = Jsoup.parse(page.asXml());

            //Set up variable with data
            Element mainElements = parsedDocument.getElementsByClass("study-directions").get(0);
            Elements courseTitle = mainElements.getElementsByClass("title");
            Elements courseDate = mainElements.getElementsByClass("date");
            Elements coursePrice = mainElements.getElementsByClass("price");

            //Print all information
            for(int i=0 ; i < courseTitle.size() ; i++){
//                System.out.print(i + ". " + courseTitle.get(i).text());
//                System.out.print(" -> " + courseDate.get(i).text());
//                System.out.print(" -> " + coursePrice.get(i).text() + "\n");

                listOfAllCourses.add(i + ". " + courseTitle.get(i).text() + "\n" + " -> " + courseDate.get(i).text() + "\n" + " -> " + coursePrice.get(i).text() + "\n\n");
            }

//            System.out.println(listOfAllCourses.size());
            System.out.println(listOfAllCourses.toString());

        } catch (Exception e) {
            System.out.println(e+"Get page error");
        }

        return listOfAllCourses;
    }
    public static ArrayList<String> getTestSiteResult(String specificCatalogs){

        setSpecificUrl(specificCatalogs);
        WebClient webClient = setupWebClient();
        Document parsedDocument;


        try {
            HtmlPage page = webClient.getPage(URL);
            webClient.waitForBackgroundJavaScript(10000);
            parsedDocument = Jsoup.parse(page.asXml());

            //Set up variable with data
            Element mainElements = parsedDocument.getElementsByClass("study-directions").get(0);
            Elements courseTitle = mainElements.getElementsByClass("title");
            Elements courseDate = mainElements.getElementsByClass("date");
            Elements coursePrice = mainElements.getElementsByClass("price");

            //Print all information
            for(int i=0 ; i < courseTitle.size() ; i++){
//                System.out.print(i + ". " + courseTitle.get(i).text());
//                System.out.print(" -> " + courseDate.get(i).text());
//                System.out.print(" -> " + coursePrice.get(i).text() + "\n");

                listOfAllCourses.add(i + ". " + courseTitle.get(i).text() + "\n" + " -> " + courseDate.get(i).text() + "\n" + " -> " + coursePrice.get(i).text() + "\n\n");
            }

//            System.out.println(listOfAllCourses.size());
            System.out.println(listOfAllCourses.toString());

        } catch (Exception e) {
            System.out.println(e+"Get page error");
        }

        return listOfAllCourses;
    }
    public static void setSpecificUrl(String catalogs){
        catalogs = catalogs.replaceAll(" ","%20");
        String[] splitedCatalogs = catalogs.split(",");
        for(int i=0;i<splitedCatalogs.length;i++){
            if(i==0){
                URL+="?obszar_szkolenia="+splitedCatalogs[i];
            } else {
                URL+="&obszar_szkolenia="+splitedCatalogs[i];
            }

        }
        System.out.println(URL);
    }



    private static WebClient setupWebClient(){

        final WebClient client = new WebClient();
        client.getOptions().setCssEnabled(true);
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setThrowExceptionOnScriptError(false);
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);

        return client;
    }


    public static void getListOfAllCourses() {

        WebClient webClient = setupWebClient();
        Document parsedDocument;


        try {
            HtmlPage page = webClient.getPage(URL);
            webClient.waitForBackgroundJavaScript(10000);
            parsedDocument = Jsoup.parse(page.asXml());

            //Set up variable with data
            Element mainElements = parsedDocument.getElementsByClass("study-directions").get(0);
            Elements courseTitle = mainElements.getElementsByClass("title");
            Elements courseDate = mainElements.getElementsByClass("date");
            Elements coursePrice = mainElements.getElementsByClass("price");

            //Print all information
            for(int i=0 ; i < courseTitle.size() ; i++){
                System.out.print(i + ". " + courseTitle.get(i).text());
                System.out.print(" -> " + courseDate.get(i).text());
                System.out.print(" -> " + coursePrice.get(i).text() + "\n");

//                listOfAllCourses.add(i + ". " + courseTitle.get(i).text() + "\n" + " -> " + courseDate.get(i).text() + "\n" + " -> " + coursePrice.get(i).text() + "\n\n");
            }

//            System.out.println(listOfAllCourses.size());
            System.out.println(listOfAllCourses.toString());

        } catch (Exception e) {
            System.out.println(e+"Get page error");
        }

//        return listOfAllCourses;

    }

}

