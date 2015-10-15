/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hojjat
 */
public class Test {

    
    String filePath;
    int quran;
    int tatil;
    int serial;
    String last4Character;

    public Test(String filePath) {
        this.filePath = filePath;
    }

    public String execute(int bufferSize) {
        char[] buffer = new char[bufferSize];
        FileReader file;
//        String result = "";
        quran = tatil = serial = 0;
        last4Character = "";
        try {
            file = new FileReader(new File(filePath));
            BufferedReader reader = new BufferedReader(file);
            long startTime = System.currentTimeMillis();
            while (reader.ready()) {
                int chars = reader.read(buffer);
                String string = new String(buffer, 0, chars);
//                quran += getCountOfOccurance(string, "قرآن");
//                serial += getCountOfOccurance(string, "سريال");
//                tatil += getCountOfOccurance(string, "تعطيل");
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
                System.out.println(string);
//                break;
            }
            long finishTime = System.currentTimeMillis();
            System.out.println("duration : " + (finishTime - startTime));
            System.out.println("quran : " + quran);
            System.out.println("tatil : " + tatil);
            System.out.println("serial : " + serial);
//            result = "duration : " + (finishTime - startTime) + "   ";
//            result += "quran : " + quran + "    ";
//            result += "serial : " + serial + "   ";
//            result += "tatil : " + tatil;
            reader.close();
        } catch (Exception ex) {
            Logger.getLogger(BufferedReader1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
}
