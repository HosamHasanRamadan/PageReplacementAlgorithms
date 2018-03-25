package Rimon;

import AlgorithmData.Page;
import ReplacementAlgorithms.ReplacementAlgorithm;


public class FirstInFirstOut extends ReplacementAlgorithm {
    private int pointer;

    public FirstInFirstOut(int numOfFrames) {
        this.numberOfFrames = numOfFrames;
        this.frames = new Page[numOfFrames];
        this.pointer = 0;
    }

    @Override
    public boolean insert(Page page) {
        System.out.print(page.getPageNumber() + "--> ");
        if (contains(page)) {
            state = false;
            return state;
        } else {
            state = true;
            page.setFrameNumber(pointer);
            frames[pointer] = page;
            pointer = (pointer + 1) % numberOfFrames;
            return state;
        }
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
