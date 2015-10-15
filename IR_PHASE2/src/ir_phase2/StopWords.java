/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir_phase2;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Hojjat
 */
public class StopWords {

    String stopWordsFilePath;
    BinarySearchTree stopWords;

    public StopWords(String stopWordsFilePath) {
        this.stopWordsFilePath = stopWordsFilePath;
        stopWords = new BinarySearchTree();
    }

    public void deleteStopWords() {
        try {
            Scanner fileScanner = new Scanner(new File(stopWordsFilePath));
            while (fileScanner.hasNextLine()) {
                BinarySearchTree.StopWord sw;
                String s;
                System.out.println(sw = stopWords.new StopWord(fileScanner.nextLine().trim()));
                
                try {
                    TreeMap<Integer,String> tree = new TreeMap<>();
                    tree.put(sw.word.hashCode(), sw.word);
                    stopWords.insert(sw);
                } catch (BinarySearchTree.DuplicateItemException ex) {
                    System.err.println("duplicate!");
                }
            }
            while (!stopWords.isEmpty()) {
                BinarySearchTree.StopWord sw;
                System.out.println(sw = (BinarySearchTree.StopWord) stopWords.findMin());
                stopWords.remove(sw);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
