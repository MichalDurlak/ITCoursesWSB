package pl.michaldurlak;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class InformatykaScraping {


    private static String URL = "https://www.wsb.pl/studia-i-szkolenia/szkolenia-i-kursy/listing-szkolen?obszar_szkolenia=informatyka&miasta=gda%C5%84sk";


    public static void getTestSiteResult(){

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
            }


        } catch (Exception e) {
            System.out.println("Get page error");
        }
    }

    private static WebClient setupWebClient(){

        final WebClient client = new WebClient();
        client.getOptions().setCssEnabled(true);
        client.getOptions().setJavaScriptEnabled(true);
        client.getOptions().setThrowExceptionOnScriptError(false);
        client.getOptions().setThrowExceptionOnFailingStatusCode(false);

        return client;
    }
}

