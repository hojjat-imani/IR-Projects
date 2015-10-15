/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir_phase2;

/**
 *
 * @author Hojjat
 */
public class SUtil {

    int counter;
    int counter2;
    int i;

    public int split(char[] content, char[] regex, int[][] result) {
        int[][] words;

        //TODO not implemented
        counter = 0;
        int partStart = 0;
        i = 0;
        while (counter < content.length) {
            if (contains(regex, content[counter])) {
//                if (i >= result.length) {
//                    return -1;
//                }
                if (counter > partStart) {
//                    result[i][0] = partStart;
//                    result[i][1] = counter - partStart;
//                    partStart = counter + 1;
                    i++;
                }
            }
            counter++;
        }
        if (counter > partStart) {
//            result[i][0] = partStart;
//            result[i][1] = counter - partStart;
//            partStart = counter + 1;
            i++;
        }
        return i;
    }

    private boolean contains(char[] s, char c) {
        for (counter2 = 0; counter2 < s.length; counter2++) {
            if (s[counter2] == c) {
                return true;
            }
        }
        return false;
    }

//    public int compare(HString hs) {
//        //TODO not implemented
//        return 0;
//    }
//
//    public int compare(int s1Start, int s1Length, int s2Start, int s2Length) {
//        return 0;
//    }
//
//    public int compare(HString s1, int start, int end) {
//        return 0;
//    }
//
//    public int compare(String s1, int start, int length) {
//        return 0;
//    }
    public int hashCode(char[] content, int start, int length) {
        int h = 0;
        for (counter = 0; counter < length; counter++) {
            h = 35 * h + content[start++];
        }
        return h;
    }
}
