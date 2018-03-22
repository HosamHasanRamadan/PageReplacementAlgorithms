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
            frames[index].setDirtyBit();
            return state;
        } else {
            state = true;
            index = findIndex();
            pointer = index;
            page.setFrameNumber(pointer);
            frames[pointer] = page;
            pointer = (pointer + 1) % numberOfFrames;
            return state;
        }
    }
    private int  findIndex(){
        int p = pointer;

        if(frames[p] != null)
        while(true){
            if(frames[p].getDirtyBit()){
                frames[p].resetDirtyBit();
                p = (p+1) % frames.length;
            }
            else {
                break;
            }
        }
        return p ;
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
