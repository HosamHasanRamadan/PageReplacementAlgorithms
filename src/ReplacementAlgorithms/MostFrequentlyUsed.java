package ReplacementAlgorithms;

import java.util.HashMap;
import java.util.Map;
import AlgorithmData.*;

public class MostFrequentlyUsed extends ReplacementAlgorithm {
    Map<Integer,Integer> map;
    int numberOfFrames;
    int counter = 0;

    public MostFrequentlyUsed( int numberOfFrames) {
        this.map = new HashMap<>();
        this.numberOfFrames = numberOfFrames;
        frames = new Page[numberOfFrames];
    }

    @Override
    public boolean insert(Page page) {
        System.out.println(map);
        System.out.print(page.getPageNumber() + "--> ");
        int key = page.getPageNumber();
        counter++;
        int index = 0;

        if((index = contains(page)) != -1) {
            int value = map.get(key);
            value++;
            map.replace(key,value);
            frames[index].setCount(counter);
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

    private int findFrameNumber(){
        if (pointer < numberOfFrames)
            if (frames[pointer] == null) {
                int temp = pointer;
                pointer++;
                return temp;
            }

        int maxFreq = map.get(frames[0].getPageNumber()) ;
        int frameNumber = 0;
        int maxCount = frames[0].getCount();

        for (int count = 1; count < numberOfFrames; count++) {
            Page p  = frames[count];
            int pageNumber = p.getPageNumber();
            int pageFreq = map.get(pageNumber);
            if(pageFreq > maxFreq ) {
                maxFreq = pageFreq;
                frameNumber = count;
            }
            if (pageFreq == maxFreq)
                if (p.getCount() > maxCount) {
                    maxCount = p.getCount();
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
