package ReplacementAlgorithms;

import AlgorithmData.Algorithm;
import AlgorithmData.Page;

public abstract class ReplacementAlgorithm implements Algorithm {
    protected Page[] frames ;
    protected int numberOfFrames;
    protected   boolean state;
    protected   int pointer;


    public abstract boolean insert(Page page);
    public abstract void print();
}
