package MainPackage;


import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hojjat
 */
public class Main {
    static int bufferSize;
    static String inputPath;
    static String outputPath;

//    public Main(int bufferSize, String inputPath, String outputPath) {
//        this.bufferSize = bufferSize;
//        this.inputPath = inputPath;
//        this.outputPath = outputPath;
//    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        runReadFile1Sort();
//        runTest();
//        runReadFile2();
//        runReadFile1();
        bufferSize = 1000 * 1024;
        inputPath ="C://file.txt";
        outputPath = "";
//        bufferedReader1();
        ReadFile1Sort sort = new ReadFile1Sort(inputPath);
        sort.execute(bufferSize);
//        Test test = new Test("sorted.txt");
//        test.execute(bufferSize);
    }
//    
//    private static void runReadFile1Sort(){
//        ReadFile1Sort readFile1Sort = new ReadFile1Sort("C://file.txt");
//        System.out.println("sorting ...");
//        int bufferSize = 64 * 1024;
//        readFile1Sort.execute(bufferSize);
//        System.out.println("done.");
//    }
//
//    private static void runReadFile1() {
//        try {
//            PrintWriter writer = new PrintWriter("ReadFile1.txt", "UTF-8");
//            ReadFile1 readFile1 = new ReadFile1("C://file.txt");
//            int i = 4;
//            for (; i <= 100 * 1000 * 1000; i *= 2) {
//                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(readFile1.execute(i));
//                System.out.println("--------------------------");
//                writer.println("--------------------------");
//            }
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    private static void runReadFile2() {
//        try {
//            PrintWriter writer = new PrintWriter("ReadFile2.txt", "UTF-8");
//            ReadFile2 readFile2 = new ReadFile2("C://file.txt");
//            int i = 1;
//            for (; i <= 100 * 1000 * 1000; i *= 2) {
//                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(readFile2.execute(i));
//                System.out.println("--------------------------");
//                writer.println("--------------------------");
//            }
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void runReadFile1MaghaleBased() {
//        try {
//            PrintWriter writer = new PrintWriter("ReadFile1MaghaleBased.txt", "UTF-8");
//            ReadFile1MaghaleBased readFile1MaghaleBased = new ReadFile1MaghaleBased("C://file.txt");
//            int i = 4 * 1024 * 1024;
////            for (; i <= 100 * 1000 * 1000; i *= 2) {
//            System.out.println("buffer size : " + i);
//            writer.println("buffer size : " + i);
//            writer.println(readFile1MaghaleBased.execute(i));
//            System.out.println("--------------------------");
//            writer.println("--------------------------");
//
//            i = 1024 * 1024;
//
//            System.out.println("buffer size : " + i);
//            writer.println("buffer size : " + i);
//            writer.println(readFile1MaghaleBased.execute(i));
//            System.out.println("--------------------------");
//            writer.println("--------------------------");
//
//            i = 256 * 1024;
//
//            System.out.println("buffer size : " + i);
//            writer.println("buffer size : " + i);
//            writer.println(readFile1MaghaleBased.execute(i));
//            System.out.println("--------------------------");
//            writer.println("--------------------------");
//
//            i = 64 * 1024;
//
//            System.out.println("buffer size : " + i);
//            writer.println("buffer size : " + i);
//            writer.println(readFile1MaghaleBased.execute(i));
//            System.out.println("--------------------------");
//            writer.println("--------------------------");
////            }
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void runTest() {
//        Test t = new Test("C://file.txt");
//        t.execute(64 * 1000);
//    }
    
    public static void bufferedReader1(){
        System.out.println("Calcuting best buffer size using BufferedReader");
        try {
//            PrintWriter writer = new PrintWriter(outputPath + "//CalcBestBuffSize_BufferedReader.txt", "UTF-8");
            BufferedReader1 bufferedReader1 = new BufferedReader1(inputPath);
            for (int i = 1; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(bufferedReader1.execute(i));
                bufferedReader1.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void fileInputStream1(){
        System.out.println("Calcuting best buffer size using FileInputStream");
        try {
//            PrintWriter writer = new PrintWriter(outputPath + "//CalcBestBuffSize_FileInputStream.txt", "UTF-8");
            FileInputStream1 fileInputStream1 = new FileInputStream1(inputPath);
            for (int i = 1; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(fileInputStream1.execute(i));
                fileInputStream1.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void pushBackReader1(){
        System.out.println("Calcuting best buffer size using PushBackReader");
        try {
//            PrintWriter writer = new PrintWriter(outputPath + "//CalcBestBuffSize_PushBackReader.txt", "UTF-8");
            PushBackReader1 pushBackReader1 = new PushBackReader1(inputPath);
            for (int i = 1; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(pushBackReader1.execute(i));
                pushBackReader1.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void dataInputStream1(){
        System.out.println("Calcuting best buffer size using DataInputStream");
        try {
//            PrintWriter writer = new PrintWriter(outputPath + "//CalcBestBuffSize_DataInputStream.txt", "UTF-8");
            DataInputStream1 dataInputStream1 = new DataInputStream1(inputPath);
            for (int i = 1; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(dataInputStream1.execute(i));
                dataInputStream1.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void pushBackInputStream1(){
        System.out.println("Calcuting best buffer size using PushBackInputStream");
        try {
//            PrintWriter writer = new PrintWriter(outputPath + "//CalcBestBuffSize_PushBackInputStream.txt", "UTF-8");
            PushBackInputStream1 pushBackInputStream1 = new PushBackInputStream1(inputPath);
            for (int i = 1; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(pushBackInputStream1.execute(i));
                pushBackInputStream1.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void bufferedInputStream1(){
        System.out.println("Calcuting best buffer size using BufferedInputStream");
        try {
//            PrintWriter writer = new PrintWriter(outputPath + "//CalcBestBuffSize_BufferedInputStream.txt", "UTF-8");
            BufferedInputStream1 bufferedInputStream1 = new BufferedInputStream1(inputPath);
            for (int i = 1; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(bufferedInputStream1.execute(i));
                bufferedInputStream1.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
     public void runReadFile2() {
        try {
//            PrintWriter writer = new PrintWriter("ReadFile2.txt", "UTF-8");
            FileInputStream1 readFile2 = new FileInputStream1("C://file.txt");
            int i = 1;
            for (; i <= 100 * 1000 * 1000; i *= 2) {
                System.out.println("buffer size : " + i);
//                writer.println("buffer size : " + i);
//                writer.println(readFile2.execute(i));
                readFile2.execute(i);
                System.out.println("--------------------------");
//                writer.println("--------------------------");
            }
//            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runReadFile1MaghaleBased() {
        try {
            PrintWriter writer = new PrintWriter("ReadFile1MaghaleBased.txt", "UTF-8");
            ReadFile1MaghaleBased readFile1MaghaleBased = new ReadFile1MaghaleBased("C://file.txt");
            int i = 4 * 1024 * 1024;
//            for (; i <= 100 * 1000 * 1000; i *= 2) {
            System.out.println("buffer size : " + i);
            writer.println("buffer size : " + i);
            writer.println(readFile1MaghaleBased.execute(i));
            System.out.println("--------------------------");
            writer.println("--------------------------");

            i = 1024 * 1024;

            System.out.println("buffer size : " + i);
            writer.println("buffer size : " + i);
            writer.println(readFile1MaghaleBased.execute(i));
            System.out.println("--------------------------");
            writer.println("--------------------------");

            i = 256 * 1024;

            System.out.println("buffer size : " + i);
            writer.println("buffer size : " + i);
            writer.println(readFile1MaghaleBased.execute(i));
            System.out.println("--------------------------");
            writer.println("--------------------------");

            i = 64 * 1024;

            System.out.println("buffer size : " + i);
            writer.println("buffer size : " + i);
            writer.println(readFile1MaghaleBased.execute(i));
            System.out.println("--------------------------");
            writer.println("--------------------------");
//            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runTest() {
//        Test t = new Test("C://file.txt");
//        t.execute(64 * 1000);
    }

}
