package problems.ds;

import java.util.LinkedList;
import java.util.Queue;

class HitCounter {
    private Queue<Long> hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.hits = new LinkedList<Long>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(long timestamp) {
        this.hits.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(long timestamp) {
        while (!this.hits.isEmpty()) {
            long diff = timestamp - this.hits.peek();
            if (diff >= 200) {
                this.hits.remove();
            }
            else break;
        }
        return this.hits.size();
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println();
        HitCounter hc = new HitCounter();
        for(int i = 0; i < 100000; i++) {
            hc.hit(System.currentTimeMillis());
            Thread.sleep(1);
            if(i % 1000 ==0) {
                System.out.println(hc.getHits(System.currentTimeMillis()));
            }
        }
    }
}