package com.currentmodificationexception;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationException {

	public static void main(String arg[]) {
		List<String> arrayList = new ArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("q");
		arrayList.add("a");
		for(String s: arrayList){
			if (arrayList.contains(s)) {
				arrayList.remove(s);
				arrayList.add("m");
			}
		}
	}
	
	public void testException(){
		
		try{
			
		}
		catch(ArrayIndexOutOfBoundsException e2){
			
		}
		catch(ArithmeticException e){
			
		}
		catch(NullPointerException nu){
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
