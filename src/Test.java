import AlgorithmData.Page;

import AlgorithmData.*;
import ReplacementAlgorithms.ReplacementAlgorithm;


import java.util.Random;

public class Test {

    private Page[] testSequance ;
    private Random random = new Random() ;

    private ReplacementAlgorithm algorithm ;

    private int numberOfFrames  ;
    private int rangeOfPageNumber ;
    private int pagesSequanceLength;

    Test( int numberOfFrames , int pagesSequanceLength ,int rangeOfPageNumber ){
        this.rangeOfPageNumber = rangeOfPageNumber;
        this.pagesSequanceLength =  pagesSequanceLength;
        this.numberOfFrames = numberOfFrames ;
        createTestSequance();
    }

    Test(int numberOfFrames , Page[] pages ,  int rangeOfPageNumber ){
        this(numberOfFrames , pages.length , rangeOfPageNumber );
        testSequance = pages;
    }

    private void createTestSequance(){
        if(testSequance != null)
            return;

        testSequance = new Page[pagesSequanceLength];
        for(int count = 0 ; count < pagesSequanceLength ; count++ ){
            int pageNumber = random.nextInt(rangeOfPageNumber);
            Page page = new Page(pageNumber);
            testSequance[count] = page ;
        }
    }

    void randomTest(ReplacementAlgorithm algorithm){

        algorithm = algorithm ;
        for(int count = 0 ; count < pagesSequanceLength ; count++ ){
            Page page = testSequance[count];
            algorithm.insert(page);
            algorithm.print();
        }
    }

    public Page[] getTestSequance() {
        return testSequance;
    }
}
