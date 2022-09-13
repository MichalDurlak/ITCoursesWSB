package pl.michaldurlak;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class InformatykaScraping {


    private static String URL = "https://www.wsb.pl/studia-i-szkolenia/szkolenia-i-kursy/listing-szkolen?obszar_szkolenia=informatyka&miasta=gda%C5%84sk";


    public static void getTestSiteResult(){



            final WebClient client = new WebClient();
            client.getOptions().setCssEnabled(true);
            client.getOptions().setJavaScriptEnabled(true);
            client.getOptions().setThrowExceptionOnScriptError(false);
            client.getOptions().setThrowExceptionOnFailingStatusCode(false);


        HtmlPage page = null;
        Document parsedDocument = null;

        try {
            page = client.getPage(URL);
            client.waitForBackgroundJavaScript(10000);

            parsedDocument = Jsoup.parse(page.asXml());


        } catch (Exception e) {
            System.out.println("Get page error");
        }
        Elements elementsByClass1 = parsedDocument.getElementsByClass("study-directions");
        Elements elementsByClass2 = elementsByClass1.get(0).getElementsByClass("title");
        Elements elementsByClass3 = elementsByClass1.get(0).getElementsByClass("date");
        Elements elementsByClass4 = elementsByClass1.get(0).getElementsByClass("price");
//        System.out.println(elementsByClass2.size());
//        System.out.println(elementsByClass2.get(0).text());

        for(int i=0 ; i < elementsByClass2.size() ; i++){
            System.out.print(elementsByClass2.get(i).text());
            System.out.print(" - " + elementsByClass3.get(i).text());
            System.out.print(" - " + elementsByClass4.get(i).text() + "\n");

        }
    }
}

