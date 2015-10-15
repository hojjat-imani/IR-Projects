package MainPackage;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class ReadFile1MaghaleBased {

    String filePath;
    int maxQuran;
    int quran;
    int maxTatil;
    int tatil;
    int maxSerial;
    int serial;
    String last4Character;
    String maghale = "";

    public ReadFile1MaghaleBased(String filePath) {
        this.filePath = filePath;
    }

    public String execute(int bufferSize) {
        char[] buffer = new char[bufferSize];
        FileReader file;
        String result = "";
        quran = tatil = serial = maxQuran = maxSerial = maxTatil = 0;
        last4Character = "";
        try {
            file = new FileReader(new File(filePath));
            BufferedReader reader = new BufferedReader(file);
            long startTime = System.currentTimeMillis();
            while (reader.ready()) {
                int chars = reader.read(buffer);
                String string = new String(buffer, 0, chars);
                processString(string);

//                String first4Character;
//                if (string.length() >= 4) {
//                    first4Character = string.substring(0, 4);
//                } else {
//                    first4Character = "";
//                }
//                String oonHalate = last4Character + first4Character;
//                if (oonHalate.contains("قرآن") && !oonHalate.startsWith("قرآن") && !oonHalate.endsWith("قرآن")) {
//                    quran++;
//                }
//                if (oonHalate.contains("تعطيل")) {
//                    tatil++;
//                }
//                if (oonHalate.contains("سريال")) {
//                    serial++;
//                }
//                if (string.length() >= 4) {
//                    last4Character = string.substring(string.length() - 4);
//                } else {
//                    last4Character = "";
//                }
            }
            long finishTime = System.currentTimeMillis();
            System.out.println("duration : " + (finishTime - startTime));
            System.out.println("quran : " + quran);
            System.out.println("tatil : " + tatil);
            System.out.println("serial : " + serial);
            System.out.println("max serial : " + maxSerial);
            System.out.println("max quran : " + maxQuran);
            System.out.println("max tatil : " + maxTatil);
            result = "duration:" + (finishTime - startTime) + " ";
            result += "quran:" + quran + " ";
            result += "serial:" + serial + " ";
            result += "tatil:" + tatil + " ";
            result += "maxQuran:" + maxQuran + " ";
            result += "maxSerial:" + maxSerial + " ";
            result += "maxTatil:" + maxTatil;
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(BufferedReader1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private int getCountOfOccurance(String str, String findStr) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = str.indexOf(findStr, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }

    private void processString(String string) {
        String oonHalate = "";
        if (maghale.length() >= 6) {
            if (string.length() >= 6) {
                oonHalate = maghale.substring(maghale.length() - 6) + string.substring(0, 6) ;
            } else {
                oonHalate = maghale.substring(maghale.length() - 6) + string;
            }
        }
        if(oonHalate.contains("<مقاله>")){
//            System.out.println("maghale-" + maghale);
//            System.out.println("string-"+ string);
            System.out.println("p1:"+ maghale.substring(maghale.length() - 6));
            System.out.println("p2:"+ string.substring(0, 6));
            System.out.println("oonhalete:"+ oonHalate);
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
        if (maghale.contains("قرآن")) {
            quran++;
        }
        if (maghale.contains("تعطيل")) {
            tatil++;
        }
        if (maghale.contains("سريال")) {
            serial++;
        }
        maxQuran = Math.max(maxQuran, getCountOfOccurance(maghale, "قرآن"));
        maxTatil = Math.max(maxTatil, getCountOfOccurance(maghale, "تعطيل"));
        maxSerial = Math.max(maxSerial, getCountOfOccurance(maghale, "سريال"));
        maghale = "";
    }
}
