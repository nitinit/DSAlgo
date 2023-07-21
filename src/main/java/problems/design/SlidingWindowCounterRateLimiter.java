package problems.design;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SlidingWindowCounterRateLimiter {
    public long timeLimit = 30; //Overall time window (in seconds) to apply rate limit.
    public long rateLimit = 5; //Overall request count allowed in the time window.
    public long numberofTimeWindows = 5; //Number of smaller time window buckets that the program will use.
    private Map<String, Map<Long, AtomicLong>> UserTimeMap = new ConcurrentHashMap<>();

    //Main method to check if new requests are allowed
    public boolean isAllowed(String username) {
        System.out.println("Instant.now().getEpochSecond():"+Instant.now().getEpochSecond());
        long currentTime = Instant.now().getEpochSecond() / numberofTimeWindows;
        System.out.println("currentTime:"+currentTime);
        //Reference for individual user count data
        Map<Long, AtomicLong> individualUserHits;

        // Case 1: User specific Entry does not exist
        if (!UserTimeMap.containsKey(username)) {
            individualUserHits = new HashMap<>();
            individualUserHits.put(currentTime, new AtomicLong(1L));
            UserTimeMap.put(username, individualUserHits);
            return true;
        }
        // Case 2: User specific Entry exists, Time Window for the user may or may not exist in the map
        else {
            individualUserHits = UserTimeMap.get(username);
            return checkAndAddForExistingUsers(username, currentTime, individualUserHits);
        }
    }


    public boolean checkAndAddForExistingUsers(String username, long currentTimeWindow, Map<Long, AtomicLong> timeWindowVSCountMap) {
        Long countInOverallTime = removeOldEntriesForUser(username, currentTimeWindow, timeWindowVSCountMap);

        if (countInOverallTime < rateLimit) {
            //Handle new time windows
            Long newCount = timeWindowVSCountMap.getOrDefault(currentTimeWindow, new AtomicLong(0)).longValue() + 1;
            timeWindowVSCountMap.put(currentTimeWindow, new AtomicLong(newCount));
            return true;
        }
        return false;
    }
    // Remove Old Entries for the user and returns the current overall request count for the user
    public long removeOldEntriesForUser(String username, long currentTimeWindow, Map<Long, AtomicLong> timeWindowVSCountMap)
    {
        List<Long> oldEntriesToBeDeleted=new ArrayList<>();
        long overallCount=0L;
        for (Long timeWindow : timeWindowVSCountMap.keySet()) {
            //Mark old entries (Entries older than the oldest valid time window within the time limit) for deletion
            if ((currentTimeWindow - timeWindow) >= timeLimit / numberofTimeWindows)
                oldEntriesToBeDeleted.add(timeWindow);
            else
                overallCount+=timeWindowVSCountMap.get(timeWindow).longValue();
        }
        System.out.println("overallCount:"+overallCount);
        timeWindowVSCountMap.keySet().removeAll(oldEntriesToBeDeleted);
        return overallCount;
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounterRateLimiter slidingWindowCounterRateLimiter = new SlidingWindowCounterRateLimiter();
        System.out.println(slidingWindowCounterRateLimiter.isAllowed("nitin"));
        Thread.sleep(1000);
        System.out.println(slidingWindowCounterRateLimiter.isAllowed("nitin"));
        Thread.sleep(1000);
        System.out.println(slidingWindowCounterRateLimiter.isAllowed("nitin"));
        Thread.sleep(1000);
        System.out.println(slidingWindowCounterRateLimiter.isAllowed("nitin"));
        Thread.sleep(1000);
        System.out.println(slidingWindowCounterRateLimiter.isAllowed("nitin"));
        Thread.sleep(1000);
        System.out.println(slidingWindowCounterRateLimiter.isAllowed("nitin"));



    }
}