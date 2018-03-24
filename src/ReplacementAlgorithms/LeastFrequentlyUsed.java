package ReplacementAlgorithms;

import AlgorithmData.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeastFrequentlyUsed extends ReplacementAlgorithm {

    Map<Integer,Integer> map;
    int numberOfFrames;
    Stack<Page> equalFreqPages;
    Stack<Page> equalPages;
    int counter = 0;

    public LeastFrequentlyUsed( int numberOfFrames) {
        this.map = new HashMap<>();
        this.numberOfFrames = numberOfFrames;
        frames = new Page[numberOfFrames];
        equalPages = new Stack<>();
    }

    @Override
    public boolean insert(Page page) {

        System.out.print(page.getPageNumber() + "--> ");
        int key = page.getPageNumber();
        int index = 0 ;
        counter++;

        if((index = contains(page)) != -1 ) {
            int value = map.get(key);
            value++;
            frames[index].setCount(counter);
            map.replace(key,value);
            state = false;
        }
        else{
            int frameNumber = findFrameNumber();
            page.setFrameNumber(frameNumber);
            page.setCount(counter);
            frames[frameNumber] = page;
            state = true;
            if(map.containsKey(key))
                updateMap(page);
            else
                map.put(key,1);
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

        int minFreq = map.get(frames[0].getPageNumber());
        int minCount = frames[0].getCount();
        int frameNumber = 0;

        for (int count = 1; count < numberOfFrames; count++) {
            Page p = frames[count];
            int pageNumber = p.getPageNumber();
            int pageFreq = map.get(pageNumber);

            if (pageFreq < minFreq) {
                minFreq = pageFreq;
                frameNumber = count;
            } else {
                if (pageFreq == minFreq)
                    if (p.getCount() < minCount) {
                        minCount = p.getCount();
                        frameNumber = count;
                    }
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
