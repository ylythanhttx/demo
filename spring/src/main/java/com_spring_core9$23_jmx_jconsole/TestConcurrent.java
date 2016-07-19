package com_spring_core9$23_jmx_jconsole;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestConcurrent {

	static String name = "name";
	static int i = 0;
	private static Map<String, Lock> mapLock = new ConcurrentHashMap<String, Lock>();

	static ExecutorService executorService = Executors.newFixedThreadPool(20);

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 5000; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println("start "+Thread.currentThread().getName());
					if (!mapLock.containsKey(name)) {
						// Save lock of name
						mapLock.put(name, new ReentrantLock());
					}
					Lock lock = mapLock.get(name);
					try {
						lock.lock();
						TestConcurrent.i++;
					} finally {
						lock.unlock();
					}
					System.out.println("stop "+Thread.currentThread().getName());
				}
			});
		}
		Thread.sleep(5000);
		System.out.println(i);
	}

	public static void start(final int id) {

	}
}
