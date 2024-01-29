package ch15;

public class MyThread extends Thread {
	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + " ==> " + i);
			try {
				Thread.sleep(1000); // CPU 1초 멈춤(인터럽트, 간섭)
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
