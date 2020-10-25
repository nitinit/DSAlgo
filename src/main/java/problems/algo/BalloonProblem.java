package problems.algo;

public class BalloonProblem {

    public static void main(String[] args) {

        int[] arr1 = { 5, 4, 3, 3, 2, 2, 1, 1, 1 };
        int[] arr2 = { 5, 4, 2, 1 };
        int[] arr3 = {9,8, 6, 4, 2, 1};
        int[] arr4 = {9,8, 6, 6, 6, 6, 4, 2,1,0};

        System.out.println(findSol(arr1));
        System.out.println(findSol(arr2));
        System.out.println(findSol(arr3));
        System.out.println(findSol(arr4));

        System.out.println(findSol1(arr1));
        System.out.println(findSol1(arr2));
        System.out.println(findSol1(arr3));
        System.out.println(findSol(arr4));

    }

    private static int findSol1(int[] arr) {
        int seq = 0, same = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] ==1) {
                seq++;
            }
            else if(arr[i] - arr[i-1] != 0) {
                same++;
            }
        }
        return seq + same -1;
    }





















        private static int findSol(int[] arr) {

        if (arr.length == 0)
            return 0;

        int sameNo = 0;
        int seq = 1; // if array is not empty then there will be 1 sequence by default
        int prev = 0; // to keep track of number of repeated numbers.

        for (int i = 1; i < arr.length; i++) {
            // when there is break b/w numbers.
            if (arr[i - 1] - arr[i] > 1) {
                seq++;
            }
            // when number or equal its the same number, hence we can form another set with this.
            if (arr[i] == arr[i - 1])
                sameNo++;
            if (arr[i] != arr[i - 1])
                sameNo = 0;
            if (prev < sameNo)
                prev = sameNo;
        }
        // combine both break in sequence and same numbers.
        return (seq + prev);

    }
}