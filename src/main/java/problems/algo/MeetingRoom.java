package problems.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRoom {

    public static List<Integer> meetingsPossible(int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();
        list.add(startTime[0]);
        int prevTime = endTime[0];

        for (int i = 1; i < startTime.length; i++) {
            if(startTime[i] > prevTime) {
                list.add(startTime[i]);
                prevTime = endTime[i];
            }
        }
        return list;
    }

    public static List<Integer> meetingsPossible1(int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(startTime[i]);
            int start = endTime[i];
            for (int j = i + 1; j < startTime.length; j++) {
                if (start < startTime[j]) {
                    tempList.add(startTime[j]);
                    start = endTime[j];
                }
            }
            if (tempList.size() > list.size()) {
                list = tempList;
            }
        }
        return list;
    }

    int getMaximumMeetings(List<Integer> startTime, List<Integer> finishTime) {
        List<Interval> list = new ArrayList<>(); // create a List of Interval
        for (int i = 0; i < startTime.size(); i++) {
            list.add(new Interval(startTime.get(i), finishTime.get(i)));
        }
        list.sort(Comparator.comparingInt(i -> i.end)); // sort by finish times ascending

        int res = 0;
        int prevEnd = Integer.MIN_VALUE; // finish time of the previous meeting

        for (Interval i : list) {
            if (i.start >= prevEnd) { // is there a conflict with the previous meeting?
                res++;
                prevEnd = i.end; // update the previous finish time
            }
        }
        return res;
    }

    public static void main(String args[]) {
        //int s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9};
        int s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924},
                f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        for (int i = 0; i < f.length; i++) {
            for (int j = i + 1; j < f.length; j++) {
                if (f[i] > f[j]) {
                    int temp = s[i];
                    int temp1 = f[i];
                    s[i] = s[j];
                    f[i] = f[j];
                    s[j] = temp;
                    f[j] = temp1;
                }
            }
        }
        Arrays.stream(s).asLongStream().forEach(n -> System.out.print(n + ","));
        System.out.println();
        Arrays.stream(f).asLongStream().forEach(n -> System.out.print(n + ","));
        System.out.println();
        System.out.println("Meeting possible:"+meetingsPossible(s, f));

        MeetingRoom mr = new MeetingRoom();
        List<Integer> startTimeList = Arrays.stream(s).boxed().collect(Collectors.toList());
        List<Integer> finishTimeList = Arrays.stream(f).boxed().collect(Collectors.toList());

        int max = mr.getMaximumMeetings(startTimeList, finishTimeList);
        System.out.println("Max Meeting Possible:" + max);
    }

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
