package ocp.ch7.Concurrency.UsingConcurrentCollections;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class WorkingWithConcurrentClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new ConcurrentHashMap<>();
		map.put("zebra", 52);
		map.put("elephant", 10);
		System.out.println(map.get("elephant"));
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(31);
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offer(10);
		deque.push(4);
		System.out.println(deque.peek());
		System.out.println(deque.pop());

		try {
			BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
			blockingQueue.offer(39);
			blockingQueue.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(blockingQueue);
			System.out.println(blockingQueue.poll());
			System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
			System.out.println(blockingQueue);
		} catch (InterruptedException e) {
			// Handle interruption
		}

		try {
			BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
			blockingDeque.offer(91);
			blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
			blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
			blockingDeque.offer(3, 4, TimeUnit.SECONDS);
			System.out.println(blockingDeque.poll());
			System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
			System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
			System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// Handle interruption
		}
		System.out.println();

		/*
		 * List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 52)); for (Integer
		 * item : list) { //java.util.ConcurrentModificationException
		 * System.out.print(item + " "); list.add(9); }
		 */

		List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
		for (Integer item : list) {
			System.out.print(item + " ");
			list.add(9);
		}
		System.out.println();
		System.out.println("Size: " + list.size());
	}

}
