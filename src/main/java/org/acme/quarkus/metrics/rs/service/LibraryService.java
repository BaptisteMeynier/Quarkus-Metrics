package org.acme.quarkus.metrics.rs.service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@ApplicationScoped
public class LibraryService {
    private Queue<String> queue = new ConcurrentLinkedDeque<>();


    public LibraryService() {
    }

    public void add(String book) {
        queue.add(book);
    }

    public void remove(String book) {
        queue.remove(book);
    }

    public int size() {
        return queue.size();
    }

    public String[] findAll(){
        return queue.toArray(new String[0]);
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
