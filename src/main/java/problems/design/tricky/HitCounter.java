package problems.design.tricky;

/*
   Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).
 */
public class HitCounter {

    private int[] times;
    private int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        HitCounter hitCounter = new HitCounter();

        hitCounter.hit(3000);
        hitCounter.hit(3001);
        hitCounter.hit(3002);
        hitCounter.hit(3001);
        hitCounter.hit(3001);
        hitCounter.hit(3001);
        hitCounter.hit(9001);
        hitCounter.hit(12001);

    }
}
