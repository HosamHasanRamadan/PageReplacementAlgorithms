package ReplacementAlgorithms;

import AlgorithmData.*;

import java.util.HashMap;
import java.util.Map;

public class LeastFrequentlyUsed extends ReplacementAlgorithm {

    Map<Integer,Integer> map;
    int numberOfFrames;

    public LeastFrequentlyUsed( int numberOfFrames) {
        this.map = new HashMap<>();
        this.numberOfFrames = numberOfFrames;
        frames = new Page[numberOfFrames];
    }

    @Override
    public boolean insert(Page page) {
        //currentPageIndex++;

        System.out.print(page.getPageNumber() + "--> ");
        int key = page.getPageNumber();


        if(contains(page)) {
            int value = map.get(key);
            value++;
            map.replace(key,value);
            state = false;
        }
        else{
            int frameNumber = findFrameNumber();
            page.setFrameNumber(frameNumber);
            frames[frameNumber] = page;
            state = true;
            if(map.containsKey(key))
                updateMap(page);
            else
                map.put(key,1);
        }



        return state;
    }

    private int findFrameNumber(){
        if (pointer < numberOfFrames)
            if (frames[pointer] == null) {
                int temp = pointer;
                pointer++;
                return temp;
            }

            int minFreq = Integer.MAX_VALUE ;
            int frameNumber = 0;
        for (int count = 0; count < numberOfFrames; count++) {
                int pageNumber = frames[count].getPageNumber();
                int pageFreq = map.get(pageNumber);
                if(pageFreq < minFreq ) {
                    minFreq = pageFreq;
                    frameNumber = count;
                }
        }
        return frameNumber;
    }

    private void updateMap(Page page){
        int key  = page.getPageNumber();
        int value = map.get(key);
        value++;
        map.replace(key,value);
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
