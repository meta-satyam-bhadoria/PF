package main.java.com.metacube.ds.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.metacube.ds.beans.Entities;
import main.java.com.metacube.ds.util.Heap;

/**
 * Simulates printer
 * 
 * @author satyam bhadoria
 *
 */
public class Printer {

	private static Printer printer;
	private Heap<Entities> queue = new Heap<>();
	private List<String> printPool = new ArrayList<>();
	
	/**
	 * declaring a singleton object
	 * 
	 * @return object of printer
	 */
	public static Printer getInstance() {
		if(printer == null) {
			printer = new Printer();
		}
		return printer;
	}
	
	/**
	 * can't call using new keyword
	 */
	private Printer() {
	}
	
	/**
	 * adds the job to print based on priority in the heap
	 * 
	 * @param item - item to add in a queue 
	 */
	public void addToPrint(Entities item) {
		queue.addItem(item);
	}
	
	/**
	 * picks up the job according to the priority and prints them
	 * 
	 * @return print pool
	 */
	public List<String> print() {
		while(!queue.isEmpty()) {
			printPool.add(queue.removeMax().toString());
			print();
		}
		return printPool;
	}
}
