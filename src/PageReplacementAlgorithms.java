import ReplacementAlgorithms.*;

import java.util.Random;
import java.util.Scanner;

public class PageReplacementAlgorithms {

    public static void main(String args[]){
         Scanner scanner = new Scanner(System.in);
         int numberOfFrames = 0 ;
         int rangeOfPageNumber = 0;
         int pagesSequanceLength = 0;

        System.out.print("Enter Number Of Frames : ");
        numberOfFrames = scanner.nextInt();
        System.out.print("Enter Range Of AlgorithmData.Page Number : ");
        rangeOfPageNumber = scanner.nextInt();
        System.out.print("Enter Length of Pages Sequance : ");
        pagesSequanceLength = scanner.nextInt();

        Test t = new Test(numberOfFrames , pagesSequanceLength ,rangeOfPageNumber );

        t.randomTest(new MostFrequentlyUsed(numberOfFrames));
//        System.out.println("-------------------");
//        t.randomTest(new Optimal(t.getTestSequance(),numberOfFrames));
//        t.randomTest(new FirstInFirstOut(numberOfFrames));
//        System.out.println("----------------------");
//        t.randomTest(new Optimal(t.getTestSequance() , numberOfFrames));
//        System.out.println("----------------------");
//        t.randomTest(new LeastRecentlyUsed(t.getTestSequance() , numberOfFrames));


    }



}

