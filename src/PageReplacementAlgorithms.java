import AlgorithmData.Algorithm;
import AlgorithmData.Page;
import ReplacementAlgorithms.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import AlgorithmData.Page;

public class PageReplacementAlgorithms {

    static Scanner scanner = new Scanner(System.in);
    static int numberOfFrames = 0;
    static int rangeOfPageNumber = 0;
    static int pagesSequanceLength = 0;
    static Page[] pages;
    static Algorithm algorithm;
    static Test test;

    public static void main(String args[]) {


        System.out.println("Chose Algrithm :\n 1.FIFO\n 2.Optimal\n 3.MFU\n 4.LFU\n 5.Second Chance\n 6.LRU");
        int x  = scanner.nextInt();
        System.out.println("Enter Number of Frames ");
        numberOfFrames = scanner.nextInt();
        System.out.println("Manual(1) or Random(2)");
        int c = scanner.nextInt();
        if (c == 1) {
            manual();
        } else if (c == 2) {
            random();
        }
        else{
            test();
        }

        switch (x){
            case 1 : algorithm = new FirstInFirstOut(numberOfFrames); break;
            case 2 : algorithm = new Optimal(pages,numberOfFrames); break;
            case 3 : algorithm = new MostFrequentlyUsed(numberOfFrames); break;
            case 4 : algorithm = new LeastFrequentlyUsed(numberOfFrames); break;
            case 5 : algorithm = new SecondChance(numberOfFrames); break;
            case 6 : algorithm = new LeastFrequentlyUsed(numberOfFrames); break;
        }

        if(c == 1)
            test = new Test(numberOfFrames , pages , 1);
        else
            test = new Test(numberOfFrames,pagesSequanceLength,rangeOfPageNumber);


        test.randomTest(algorithm);




    }

    public static void manual() {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter Frame Sequance Seperated by Spaces \n" +
                "Then enter any key to finsh your sequance ex : 1 2 .. h");
        try {
            while (true) {
                int s = scanner.nextInt();
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println(list);
        }
        pages = new Page[list.size()];
        for (int i = 0; i < list.size(); i++) {
            pages[i] = new Page(list.get(i));
        }
    }

    public static void random() {
        System.out.println("Enter Sequance Length :");
        pagesSequanceLength = scanner.nextInt();
        System.out.println("Enter Max Value of Page Number : ");
        rangeOfPageNumber = scanner.nextInt();
    }

    public static void test() {
        Integer arr[] = new Integer[]
                {0, 4, 1, 4, 2, 4, 3, 4, 2, 4, 0, 4, 1, 4, 2, 4, 3, 4};
        //{7,0,1,2,0,3,0,4,2,3,0,3,0,3,2,1,2,0,1,7,0,1};
        pages = new Page[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pages[i] = new Page(arr[i]);
        }
    }


}

