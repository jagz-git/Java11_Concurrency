package org.learning;


public class RunThread implements Runnable {

    @Override
    public void run() {
//        System.out.println("Runnable Interface thread!");
        for (int i = 0; i < 10; i++) {
            System.out.println("Current thread id: " + Thread.currentThread().getId() + "\tRunThread run: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                break; //If you don't break every time the thread is interrupted will show the stack trace
            }
        }
    }

}
