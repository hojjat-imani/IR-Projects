package MainPackage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hojjat
 */
public class ReadFile1Sort {

    String filePath;
    String last4Character;
    String maghale = "";
    PrintWriter writer;
    Comparator<String> comparator;
    long totalReadTime;
    long totalSortTime;
    long totalWriteTime;
    long startRead;
    long writeStart;
    long sortStart;
    
    public ReadFile1Sort(String filePath) {
        this.filePath = filePath;
        try {
            writer = new PrintWriter("sorted.txt", "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadFile1Sort.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ReadFile1Sort.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Locale locale = new Locale("ar");
        final Collator collator = Collator.getInstance(locale);
        comparator = new Comparator<String>() {

            @Override
            public int compare(String str1, String str2) {
                int i = 0;
                while (str1.length() > i && str2.length() > i) {
                    if (str1.charAt(i) == str2.charAt(i)) {
                        i++;
                    } else {
                        if (str1.charAt(i) == 'ک' && str2.charAt(i) == 'گ') {
                            return -1;
                        } else if (str1.charAt(i) == 'گ' && str2.charAt(i) == 'ک') {
                            return 1;
                        } else {
                            return collator.compare(str1, str2);
                        }
                    }
                }
                if (str1.length() > str2.length()) {
                    return 1;
                } else if (str2.length() > str1.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }

    public String execute(int bufferSize) {
        startRead = System.currentTimeMillis();
        char[] buffer = new char[bufferSize];
        FileReader file;
        String result = "";
        last4Character = "";
        try {
            file = new FileReader(new File(filePath));
            BufferedReader reader = new BufferedReader(file);
            long startTime = System.currentTimeMillis();
            while (reader.ready()) {
                int chars = reader.read(buffer);
                String string = new String(buffer, 0, chars);
                processString(string);
            }
            long finishTime = System.currentTimeMillis();
            System.out.println("duration : " + (finishTime - startTime));
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(BufferedReader1.class.getName()).log(Level.SEVERE, null, ex);
        }
        writer.close();
        System.out.println("total read time :" + totalReadTime);
        System.out.println("total sort time :" + totalSortTime);
        System.out.println("total write time :" + totalWriteTime);
        return result;
    }

    private void processString(String string) {
        String oonHalate = "";
        if (maghale.length() >= 6) {
            if (string.length() >= 6) {
                oonHalate = maghale.substring(maghale.length() - 6) + string.substring(0, 6);
            } else {
                oonHalate = maghale.substring(maghale.length() - 6) + string;
            }
        }
        if (oonHalate.contains("<مقاله>")) {
            maghale += string.substring(0, 6);
            maghale = maghale.substring(0, maghale.indexOf("<مقاله>"));
            processMaghale();
            string = string.substring(string.indexOf(">"));
            processString(string);
        } else {
            if (!string.contains("<مقاله>")) {
                maghale += string;
            } else {
                maghale += string.substring(0, string.indexOf("<مقاله>"));
                processMaghale();
                string = string.substring(string.indexOf("<مقاله>") + 7);
                processString(string);
            }
        }
    }

    private void processMaghale() {
        totalReadTime =+ System.currentTimeMillis() - startRead;
        sortStart = System.currentTimeMillis();
        List<String> list = Arrays.asList(maghale.split("[\\s.،,;:\"'%*_-]"));
        Collections.sort(list, comparator);
        totalSortTime +=System.currentTimeMillis() - sortStart;
//        System.out.println("list size : "+ list.size());
        writeToFile(list);
        maghale = "";
        startRead = System.currentTimeMillis();
    }
    
    private void writeToFile(List<String> list){
        writeStart  = System.currentTimeMillis();
        for(String str : list){
            writer.print(str + " ");
        }
        writer.println("<مقاله>");
        totalWriteTime += System.currentTimeMillis() - writeStart;
    }
}