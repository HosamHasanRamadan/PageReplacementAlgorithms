package Ahmed;
import AlgorithmData.Algorithm;
import AlgorithmData.Page;

import java.util.*;

public class LRU implements Algorithm {
		//taking values from user and add them in a list as arraylist
	Scanner ahmed = new Scanner(System.in);
	Random rand = new Random();
	private ArrayList<Integer> list; //creat list
	private ArrayList<Integer> memory; // creat memory
	private int mem;
	private int counter; //refere to next value to insert in memory
	private int pointer;
	private boolean changed;
	public LRU(int NumOFrames) {
		mem =  NumOFrames;
		counter = 0;
		pointer = 0;
		list = new ArrayList<Integer>();
		memory = new ArrayList<Integer>();
		changed = true;
	}

	@Override
	public boolean insert(Page page){

		System.out.print(page.getPageNumber() + "--> ");
		list.add(page.getPageNumber());
			if(memory.contains(list.get(counter)) == false && counter <mem) {//inserte values in memory before it becomes full
				memory.add(list.get(counter));
				counter +=1;

				changed = true;
				return true;
			}
			else	if(memory.contains(list.get(counter)) == false && counter >= mem) {//checking if value not in memory and the memory is fulll
				//int f = list.get(counter);
				//int y = list.get(pointer);
				//int x = memory.indexOf(y);
				//memory.set(x, f)
				memory.set(memory.indexOf(list.get(pointer)), list.get(counter));//replace the least recently used with new value
				counter +=1;
				pointer +=1;
				changed = true;
				return true;
			}
			else {//update the pointer
				if(list.subList(pointer, counter).contains(list.get(counter))) {
					int index = list.subList(pointer,counter).indexOf(list.get(counter));
					list.remove(pointer+index);
				}
				else {
					counter+=1;
				}
				changed = false;
				return false;
			}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(changed) {
			for(int i =0; i<memory.size(); i++) {
				System.out.print(memory.get(i)+ " , ");
			}
		}
		System.out.println("  ");
	}

	
}
