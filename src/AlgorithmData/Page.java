package AlgorithmData;

import java.util.Objects;

public class Page  {
    private int pageNumber = -1;
    private int frameNumber = -1;
    private int count = 0 ;
    private boolean dirtBit = false;

    public Page(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Page(int pageNumber, int frameNumber) {
        this.pageNumber = pageNumber;
        this.frameNumber = frameNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public boolean getDirtBit() {
        return dirtBit;
    }

    public void setUsageTime() {
        this.dirtBit = true ;
    }
    public void resetUsageTime() {
        this.dirtBit = false ;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Page)) return false;
        Page page = (Page) o;
        return getPageNumber() == page.getPageNumber();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPageNumber());
    }

    @Override
    public String toString() {
        return String.valueOf(pageNumber);
    }


}
