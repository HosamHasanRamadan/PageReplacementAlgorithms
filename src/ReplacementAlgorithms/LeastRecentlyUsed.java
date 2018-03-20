package ReplacementAlgorithms;

import AlgorithmData.*;

public class LeastRecentlyUsed extends ReplacementAlgorithm{
    Page[] pages;
    private int currentPageIndex = -1;


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
        if (contains(page)) {
            state = false;
        } else {
            int index = findFrameNumber();
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


        int PageAccurance = pages.length;
        int frameNumber = 0;

        for (int count = 0; count < numberOfFrames; count++) {
            int currentPageAccurance = findPreAccurance(frames[count]);
            if (currentPageAccurance == -1) {
                frameNumber = count;
                break;
            }
            if (currentPageAccurance < PageAccurance) {
                PageAccurance = currentPageAccurance;
                frameNumber = count;
            }
        }
        return frameNumber;
    }

    private int findPreAccurance(Page frame) {
        int pageNumber = frame.getPageNumber();
        int preAccurance = -1;

        for (int count = currentPageIndex; count >= 0; count--) {
            int p = pages[count].getPageNumber();
            if (pageNumber == p) {
                preAccurance = count;
                break;
            }
        }
        return preAccurance;

    }

    private boolean contains(Page page) {
        for (Page pageFrame : frames) {
            if (pageFrame == null)
                break;
            if (page.equals(pageFrame))
                return true;
        }
        return false;
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
