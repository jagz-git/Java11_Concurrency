package org.learning.threading_problems;

public class LiveLockExample {

    //    Live lock is difficult to be spotted as both the threads will be in action doing something different but dependent on each other


    public static void run() {
        PhoneCall buddy1 = new PhoneCall("Jack");
        PhoneCall buddy2 = new PhoneCall("Jill");
        HangUp hangUpAction = new HangUp(buddy1);

        new Thread(()->buddy1.endCallWith(hangUpAction,  buddy2)).start();
        new Thread(()->buddy2.endCallWith(hangUpAction,  buddy1)).start();
    }


    static class HangUp {
        private PhoneCall caller;

        public HangUp(PhoneCall caller) {
            this.caller = caller;
        }

        public void setCaller(PhoneCall caller) {
            this.caller = caller;
        }

        public void end() {
            System.out.println(caller.name + "has hang up!");
        }
    }

    static class PhoneCall {

        private String name;

        private boolean isDone;

        public PhoneCall(String name) {
            this.name = name;
            isDone = false;
        }

        public String getName() {
            return name;
        }

        public boolean isDone() {
            return isDone;
        }

        public void endCallWith(HangUp hangUp, PhoneCall buddy) {
            while (!isDone) {
                if (hangUp.caller != this) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        continue;
                    }
                    continue;
                }

                if (!buddy.isDone()) {
                    System.out.println(name + ": No you hang up, buddy " + buddy.getName());
                    hangUp.setCaller(buddy); //
                    continue;
                }

                hangUp.end();
                buddy.isDone = true;
                isDone = true;
            }
        }

    }

    public static void main(String[] args) {
        run();
    }

}
