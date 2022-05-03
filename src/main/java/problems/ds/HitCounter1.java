package problems.ds;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter1 {
    int counter;
    Deque<Pair<Integer, Integer>> dequeE = new LinkedList<>();

    public HitCounter1() {

    }

    public void hit(int timestamp) {
        if(!dequeE.isEmpty() || dequeE.getLast().getLeft() != timestamp) {
            dequeE.add(Pair.of(timestamp, 1));
            return;
        }
        int tmp = dequeE.getLast().getRight();
        dequeE.removeLast();
        dequeE.add(Pair.of(timestamp, tmp++));
        counter++;
    }

    public int hitCounts(int timestamp) {
        while (!dequeE.isEmpty()) {
            int diff = timestamp - dequeE.getFirst().getLeft();
            if (diff > 300) {
                counter -= dequeE.getFirst().getRight();
                dequeE.removeFirst();
            } else break;
        }
        return counter;
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
