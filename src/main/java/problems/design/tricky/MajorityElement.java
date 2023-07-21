package problems.design.tricky;

/*
We are given an array of integers. We need to return the integer which occurs more than ⌊N / 2⌋ time
in the array where ⌊ ⌋ is the floor operator.
This element is called the majority element. Note that the input array always contains a majority element.
 */

//Approach -Boyer-Moore Voting Algorithm
/*
This algorithm maintains a candidate and its count in the array. We run a single pass of the array with candidate = -1 and count = 0.
If any element in the array is the candidate, we increment count.
Otherwise, we decrement it. If the count becomes zero, we change the candidate and set its count back to 0.
 */
public class MajorityElement {

    static int majorityElement(int[] a)
    {
        int candidate = -1 , cnt = 0;
        for(int i = 0 ; i < a.length ; i++)
        {
            if(cnt == 0)
                candidate = a[i];
            cnt += (candidate == a[i]) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String args[])
    {
        int[] a = {1 , 1 , 2 , 2 , 1 , 2 , 2};
        System.out.println(majorityElement(a));
    }
}
