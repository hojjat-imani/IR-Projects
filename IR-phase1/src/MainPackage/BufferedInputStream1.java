/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainPackage;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hojjat
 */
public class BufferedInputStream1 {
    
    String filePath;
    int quran;
    int tatil;
    int serial;
    String last4Character;

    public BufferedInputStream1(String filePath) {
        this.filePath = filePath;
    }

    public String execute(int bufferSize) {
        byte[] buffer = new byte[bufferSize];
        File file;
//        String result = "";
        quran = tatil = serial = 0;
        last4Character = "";
        try {
            file = new File(filePath);
            FileInputStream stream = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(stream);
            long startTime = System.currentTimeMillis();
            while (inputStream.available() > 0) {
                int bytes = inputStream.read(buffer);
                String string = new String(buffer, 0, bytes, "UTF-8");
                int index = 0;
                byte[] newBuffer = null;
                if (string.charAt(string.length() - 1) == '�') {
                    newBuffer = new byte[bufferSize + 5];
                    for (int j = 0; j < bufferSize; j++) {
                        newBuffer[j] = buffer[j];
                    }
                }
                while (string.charAt(string.length() - 1) == '�') {
                    newBuffer[bufferSize + index] = (byte) inputStream.read();
                    index++;
                    string = new String(newBuffer, 0, bufferSize + index, "UTF-8");
                }
//                System.out.println(string.charAt(string.length() - 1));
                quran += getCountOfOccurance(string, "قرآن");
                serial += getCountOfOccurance(string, "سريال");
                tatil += getCountOfOccurance(string, "تعطيل");
                String first4Character = "----";
                if (string.length() >= 4) {
                    first4Character = string.substring(0, 4);
                }
                String oonHalate = last4Character + first4Character;
                if (oonHalate.contains("قرآن") && !oonHalate.startsWith("قرآن") && !oonHalate.endsWith("قرآن")) {
                    quran++;
                }
                if (oonHalate.contains("تعطيل")) {
                    tatil++;
                }
                if (oonHalate.contains("سريال")) {
                    serial++;
                }
                if (string.length() >= 4) {
                    last4Character = string.substring(string.length() - 4);
                } else {
                    last4Character = "----";
                }
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
            inputStream.close();
        } catch (Exception ex) {
            Logger.getLogger(BufferedReader1.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return result;
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