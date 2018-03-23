package AhmedLeader;

import AlgorithmData.*;
import ReplacementAlgorithms.ReplacementAlgorithm;

public class Optimal extends ReplacementAlgorithm {
    Page[] pages;
    private int currentPageIndex;
    boolean change;

    public Optimal(Page[] pages, int numberOfFrames) {
        frames = new Page[numberOfFrames];
        this.pages = pages;
        this.currentPageIndex = -1;
    }

    @Override
    public boolean insert(Page page) {
        currentPageIndex++;
        System.out.print(page.getPageNumber() + "--> ");
        if( search(page.getPageNumber()) )
            change = false;
        else{
        int i = predict(currentPageIndex);
        frames[i] = page;
        change = true;
        }
        return change;
    }

    @Override
    public void print() {
        
            for (Page p : frames) {
                if (p != null)
                    System.out.print(p.getPageNumber() + " , ");
                
            }
        System.out.println();
    }

    
    private boolean search(int key){
    for (int i = 0; i < frames.length; i++)
        if (frames[i] != null)
            if(frames[i].getPageNumber() == key)
                return true;
    return false;
    }
    
    private int predict(int index){
    int res = -1, farthest = index;
    for (int i = 0; i < frames.length; i++) {
        int j;
        for (j = index; j < pages.length; j++) {
            if (frames[i] != null){
                if (frames[i].getPageNumber() == pages[j].getPageNumber()) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }
        }
        if (j == pages.length)
            return i;
    }
    return (res == -1) ? 0 : res;
    }
    
}
