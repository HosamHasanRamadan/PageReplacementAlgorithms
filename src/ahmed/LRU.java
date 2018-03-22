import java.util.*;

//least recently used algorithm
//this algorithms replace least recently used data in memory and replace it with new one if there is
//no space in memory.
//i created arraylist (list) which contains the data which will be inserted in memory.
//and another arraylist (memory) which contains the values in memory.
//we have two core variable (counter, pointer) counter refers to the index of (list) which value will be
//inserted in memory.
//pointer refere to least recently used

public class LRU {
//taking values from user and add them in a list as arraylist
		public void LRU2() {
			Scanner ahmed = new Scanner(System.in);
			ArrayList<Integer> list = new ArrayList<Integer>(); //creat list
			ArrayList<Integer> memory = new ArrayList<Integer>(); // creat memory
			System.out.print("enter the memory size : ");
			int counter = ahmed.nextInt();
			int pointer = 0;
			int iterations = counter;
			// 7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1
			System.out.print("enter the your list size : ");
			int size = ahmed.nextInt();
			
			System.out.println("enter your list");
			for(int b = 0; b<size; b++) {
				list.add(ahmed.nextInt());
			}
			for(int i=0; i<3; i++) {
				memory.add(list.get(i));
			}
			for( int i=counter; i<size; i++) {
				if(memory.contains(list.get(counter)) == false) {//checking if value not in memory
	//				int f = list.get(counter);
	//				int y = list.get(pointer);
	//				int x = memory.indexOf(y);
	//				memory.set(x, g)
					memory.set(memory.indexOf(list.get(pointer)), list.get(counter));//replace the least recently 
																					//used with new value
					counter +=1;
					pointer +=1;
					iterations += 1;
				}
				else {//update the pointer 
					if(list.subList(pointer, counter).contains(list.get(counter))) {
						int index = list.subList(pointer,counter).indexOf(list.get(counter));
						list.remove(pointer+index);
					}
					else {
						counter+=1;
					}
				}
				System.out.println(memory);
			}
			System.out.println(memory);
			System.out.println("number of iterations" + iterations);
		}
}

