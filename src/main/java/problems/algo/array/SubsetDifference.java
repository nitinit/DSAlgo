package problems.algo.array;

import java.util.HashMap;

public class SubsetDifference {

    public static int getDifference(int arr[], int n) {
        HashMap<Integer, Integer> positiveElement = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> negativeElement = new HashMap<Integer, Integer>();
        int sumSubset1 = 0, sumSubset2 = 0;
        for (int i = 0; i <= n - 1; i++) {
            if (arr[i] > 0) {
                if (positiveElement.containsKey(arr[i]))
                    positiveElement.put(arr[i], positiveElement.get(arr[i]) + 1);
                else
                    positiveElement.put(arr[i], 1);
            }
        }
        for (int i = 0; i <= n - 1; i++)
            if (arr[i] > 0 && positiveElement.get(arr[i]) == 1)
                sumSubset1 += arr[i];
        for (int i = 0; i <= n - 1; i++) {
            if (arr[i] < 0) {
                if (negativeElement.containsKey(Math.abs(arr[i])))
                    negativeElement.put(Math.abs(arr[i]), negativeElement.get(Math.abs(arr[i])) + 1);
                else
                    negativeElement.put(Math.abs(arr[i]), 1);
            }
        }
        for (int i = 0; i <= n - 1; i++)
            if (arr[i] < 0 && negativeElement.get(Math.abs(arr[i])) == 1)
                sumSubset2 += arr[i];
        return Math.abs(sumSubset1 - sumSubset2);
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, -3, -1, 5, 7};
        int n = arr.length;
        System.out.println("Maximum difference found is:" + getDifference(arr, n));
    }
}