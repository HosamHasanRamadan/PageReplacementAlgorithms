package Amr;

import AlgorithmData.Algorithm;
import AlgorithmData.Page;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class leastFrequentlyUsed implements Algorithm {

	private ArrayList<Integer> frame ;
	private Integer numOfFrames;
	private Integer min , minLoc ;
	private Map<Integer, Integer> list = new HashMap<Integer,Integer >();
	int count ;
	public leastFrequentlyUsed(int numberOfFrames){
		
		frame = new ArrayList<Integer>(numberOfFrames);
		count = 0 ;
		numOfFrames = numberOfFrames;
		
		
		
	
	}
	

	public boolean insert(Page page) {
		// TODO Auto-generated method stub
		System.out.println("Insert "+ page.getPageNumber());
		if(frame.contains(page.getPageNumber())== true){
			System.out.println("Yes Iam n the frame");
			//System.out.println("Number Exists");
			list.put(page.getPageNumber(), list.get(page.getPageNumber())+1) ;
		
			return false ;
		}
		else{
			System.out.println("No I am not in the frame");
			if(list.containsKey(page.getPageNumber())){
				System.out.println("I am in the hashmap");
				list.put(page.getPageNumber(), list.get(page.getPageNumber())+1) ;
			}
			else{
				System.out.println("I am not in the hash map");
				list.put(page.getPageNumber(), 1);
			}
			if(frame.size() < numOfFrames){
				System.out.println("Frame is not full");
				frame.add(page.getPageNumber());
				}
			else{
				
				System.out.println("Frame is full, Let swap");
				min = list.get(frame.get(0)); 
				minLoc = 0 ;
				
					System.out.println("Looping outside");
				for(int i = 1 ; i < frame.size() ; i++){
					
					if(list.get(frame.get(i)) < min ){
						System.out.println("I am looping "+ i);
						System.out.println("min "+ list.get(frame.get(0)));
						System.out.println("I am looping "+ list.get(frame.get(i)));
						min = list.get(frame.get(i)) ;
						minLoc = i ;
					
					
				}	
							
			}
				System.out.println("new min "+ min);
				System.out.println("minLoc "+ minLoc);
				
				frame.set(minLoc, page.getPageNumber());
			}
			
				
			}
		
		
		return true;
	}
	
	public void printdict() {
		// TODO Auto-generated method stub
		
		
		System.out.println(list.keySet());  

		for (Integer name: list.keySet()){

            String key =name.toString();
            String value = list.get(name).toString();  
            System.out.println(key + " " + value);  


		} 
	}
	
	public void print() {
		// TODO Auto-generated method stub
		//System.out.println("??????????????????????????   ");
		for(int i = 0 ; i < frame.size() ; i++){
			System.out.print(frame.get(i)+"  ");
			}
		System.out.println("   ");
		//System.out.println("??????????????????????????   ");
	}}

	/*
	 public static void main (String []Args){
	 
		
		
		leastFrequentlyUsed object = new leastFrequentlyUsed(3);
        Integer arr []  = new Integer[]{7,1,0,2,0,3,0,4,2,3,0,3,0,3,2,1,2,0,1,7,0,1};
        Page []pages = new Page[arr.length];
        object.print();
        ArrayList<Integer> frame = new ArrayList<Integer>(2) ;
        frame.add(0);
        frame.add(1);
        frame.add(2);
        System.out.println("0 "+ frame.get(0));
        System.out.println("1 "+ frame.get(1));
        System.out.println("2 "+ frame.get(2));
        System.out.println("frame"+frame.size());
        System.out.println();
        frame.remove(1);
        
        System.out.println("0 "+ frame.get(0));
        System.out.println("1 "+ frame.get(1));
        System.out.println("frame"+frame.size());
        System.out.println();
       for (int i = 0; i < arr.length; i++) {
           pages[i] = new Page(arr[i]);
           
       }
       for (int i = 0; i < pages.length; i++) {
           object.insert(pages[i]);
           object.printdict();
           object.print();
           //System.out.println("I am here "+pages[i].getPageNumber() );
       }
       
       
	
	}
}


 
 	if(frame.size()<numOfFrames){
				System.out.println("me");
			frame.add(page.getPageNumber());
			
			
			return true ;
			}
			
			System.out.println("I am new");
			if(list.get(page.getPageNumber()) == null){
				System.out.println("I new even to dictionary");
				list.put(page.getPageNumber(), 1) ;
				System.out.println("put to dictionary");
				
			}
			else{
				//System.out.println("I am old in dictionary");
				list.put(page.getPageNumber(), list.get(page.getPageNumber())+1) ;
			}
			
			min = list.get(frame.get(0)); 
			minLoc = 0 ;
			
			
				System.out.println("Reached here");
			for(int i = 0 ; i < frame.size() ; i++){
				System.out.println(frame.get(i));
				System.out.println(list.get(7));
				if(list.get(frame.get(i)) < min || list.get(frame.get(i)) == null ){
					System.out.println("I am looping "+ i);
					min = list.get(frame.get(i)) ;
					minLoc = i ;
				
				
			}
			System.out.println("minLoc " + minLoc);
			print();
			frame.remove(minLoc);
			frame.add(page.getPageNumber());
			print();
			
		}
 
 * */
