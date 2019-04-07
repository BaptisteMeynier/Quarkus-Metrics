package org.acme.quarkus.metrics.rs.service;


import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LibraryService {
    private Queue<String> queue = new ConcurrentLinkedDeque<>();

    public void add(String book) {
        queue.add(book);
    }

    public void remove(String book) {
        queue.add(book);
    }

    public int size() {
        return queue.size();
    }

  //  @ConcurrentGauge
    public void readBook(String book){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("I finish to read %s",book));
    }
}
