class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        // implement this method
        Thread foundThread = null;
        for (var thread : threads) {
            if (thread.getState() == Thread.State.NEW) {
                foundThread = thread;
                break;
            }
        }
        foundThread.start();
        foundThread.join();
        //foundThread.interrupt();
    }
}