package com.assesment;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ProjectMain {

	public static void main(String[] args) {
		System.out.println("Project staring...");
		
		List<Integer> numberList = Arrays.asList(1,75,3,83,812,11,67,10);
		
		//find square of each number using streams
		System.out.println("square of each number in List using streams:");
		numberList.stream().map(x->x*x).forEach(System.out::println);
		
		//find square of all even numbers using streams
		System.out.println("square of all even number in List using streams:");
		numberList.stream().filter(x->x%2==0).map(x->x*x).forEach(System.out::println);
		
		
		threadExcecution();
		threadExcecutionWithResource();
	
	}

	
	public int add(int a, int b) {
		return a+b;
	}
	
	//There are 5 threads, T1,T2,T3,T4,T5.T5 should begin processing only after all the remaining threads finish processing
	public static void  threadExcecution() {
		 try { 
		int numberOfThreads = 4;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        // Create and start threads T1, T2, T3, and T4
        for (int i = 1; i <= numberOfThreads; i++) {
            new Thread(new Task("T" + i, latch)).start();
        }

        // Wait for the other threads to finish
			latch.await();
		

        // Now start T5
        new Thread(() -> {
            System.out.println("T5 is starting after T1, T2, T3, and T4 have finished.");
        }).start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Try with resource, check if the resource has closed after execution.
	public static void threadExcecutionWithResource() {
		int numberOfThreads = 4;
        CountDownLatch latch = new CountDownLatch(numberOfThreads);
	    
		try (Resource resource = new Resource()) {
	        // Create and start threads T1, T2, T3, and T4
            for (int i = 1; i <= numberOfThreads; i++) {
            	 new Thread(new Task("T" + i, latch)).start();
            }
            
            // Wait for the other threads to finish
                latch.await();
                // Start T5
                new Thread(() -> {
                    System.out.println("T5 is starting after T1, T2, T3, and T4 have finished.");
                }).start();
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                e.printStackTrace();
            }catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
