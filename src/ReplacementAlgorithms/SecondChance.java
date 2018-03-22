package ReplacementAlgorithms;

import AlgorithmData.Page;

public class SecondChance extends ReplacementAlgorithm {
    private int pointer;

    public SecondChance(int numOfFrames) {
        this.numberOfFrames = numOfFrames;
        this.frames = new Page[numOfFrames];
        this.pointer = 0;
    }

    @Override
    public boolean insert(Page page) {
        System.out.print(page.getPageNumber() + "--> ");
        int index = 0;
        if ((index = contains(page)) != -1) {
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
