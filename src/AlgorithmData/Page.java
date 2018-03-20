package AlgorithmData;

import java.util.Objects;

public class Page  {
    private int pageNumber = -1;
    private int frameNumber = -1;
    private int usageTime = 0;

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

    public int getUsageTime() {
        return usageTime;
    }

    public void setUsageTime() {
        this.usageTime += 1 ;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
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
