package ReplacementAlgorithms;

import AlgorithmData.*;

public class LeastRecentlyUsed extends ReplacementAlgorithm{
    Page[] pages;
    private int currentPageIndex = -1;
    int counter = 0;


    public LeastRecentlyUsed(Page[] pages, int numberOfFrames) {
        frames = new Page[numberOfFrames];
        this.numberOfFrames = numberOfFrames;
        this.pages = pages;
        this.pointer = 0;
    }

    @Override
    public boolean insert(Page page) {
        System.out.print(page.getPageNumber() + "--> ");
        currentPageIndex++;
        counter++;
        int index = 0;
        if ((index = contains(page)) != -1) {
            frames[index].setCount(counter);
            state = false;
        } else {
            index = findFrameNumber();
            page.setCount(counter);
            frames[index] = page;
            state = true;
        }
        return state;

    }


    private int findFrameNumber() {

        if (pointer < numberOfFrames)
            if (frames[pointer] == null) {
                int temp = pointer;
                pointer++;
                return temp;
            }


        int minCount = frames[0].getCount();
        int frameNumber = 0;

        for (int count = 1; count < numberOfFrames; count++) {
            Page p  = frames[count];
         if(p.getCount() < minCount ) {
             minCount = p.getCount();
             frameNumber = count;
         }
        }
        return frameNumber;
    }


    private int contains(Page page) {
        for (int count = 0; count < frames.length; count++)
         {
            if (frames[count] == null)
                break;
            if (page.equals(frames[count]))
                return count;
        }
        return -1;
    }

    @Override
    public void print() {
        if (state) {
            for (Page p : frames) {
                if (p == null)
                    break;
                System.out.print(p.getPageNumber() + " , ");
            }
        }
        System.out.println();
    }
}
