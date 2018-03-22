import AlgorithmData.Page;
import ReplacementAlgorithms.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import AlgorithmData.Page;

public class PageReplacementAlgorithms {

    public static void main(String args[]){
         Scanner scanner = new Scanner(System.in);

         Integer arr []  = new Integer[]
                 {7,0,0,1,2,0,3,0,4,2,3,0,3,0,3,2,1,2,0,1,7,0,1};
        Page []pages = new Page[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pages[i] = new Page(arr[i]);
        }



         int numberOfFrames = 3 ;
         int rangeOfPageNumber = 8;
         int pagesSequanceLength = arr.length;

//        System.out.print("Enter Number Of Frames : ");
//        numberOfFrames = scanner.nextInt();
//        System.out.print("Enter Range Of AlgorithmData.Page Number : ");
//        rangeOfPageNumber = scanner.nextInt();
//        System.out.print("Enter Length of Pages Sequance : ");
//        pagesSequanceLength = scanner.nextInt();

        Test t = new Test(numberOfFrames , pages ,rangeOfPageNumber );

        t.randomTest(new LeastRecentlyUsed(pages,numberOfFrames));
        System.out.println("-----------------------------");
        t.randomTest(new MostFrequentlyUsed(numberOfFrames));
        System.out.println("-----------------------------");
        t.randomTest(new LeastFrequentlyUsed(numberOfFrames));
        System.out.println("-----------------------------");
        t.randomTest(new Optimal(pages,numberOfFrames));


    }



}

