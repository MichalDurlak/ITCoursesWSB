package pl.michaldurlak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class FileUtil {

    public static void saveToFile(String nameOfFile, String bodyOfFile) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(nameOfFile, "UTF-8");
        writer.println(bodyOfFile);
        writer.close();
    }

    public static boolean checkFile(String nameOfFile, String bodyOfNewFile) throws FileNotFoundException, UnsupportedEncodingException {
        File myObj = new File(nameOfFile);
        Scanner myReader = new Scanner(myObj);
        String bodyOfOldFile = "";
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            bodyOfOldFile += data;
        }
        myReader.close();

        Scanner myReaderBodyOfNewFile = new Scanner(bodyOfNewFile);
        String tempBodyOfNewFile = "";
        while (myReaderBodyOfNewFile.hasNextLine()){
            String data = myReaderBodyOfNewFile.nextLine();
            tempBodyOfNewFile += data;
        }
        myReaderBodyOfNewFile.close();



//        System.out.println("bodyOfOldFile -> " + bodyOfOldFile);
//        System.out.println("bodyOfNewFile -> " + tempBodyOfNewFile);

        if(bodyOfOldFile.equals(tempBodyOfNewFile)){
            System.out.println("Old file equals new data");
            return false;
        } else {
            System.out.println("Something different");
            saveToFile(nameOfFile,bodyOfNewFile);
            System.out.println("Save data to file");
            return true;
        }
    }
}
