package problems.algo.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class MinimumDeletionsProb {
    public int minDeletions(String s) {

        int[] chrarray = new int[26];

        for (char c : s.toCharArray()) {
            chrarray[c - 'a']++;
        }

        List<Integer> intArr = Arrays.stream(chrarray).boxed().sorted(Collections.reverseOrder()). collect(Collectors.toList());

        int f = intArr.get(0);
        int ans =0;

        for (Integer a : intArr) {

            if(a > f) {
                if(f >0) {
                    ans+=(a-f);
                } else {
                    ans+=a;
                }
            }
            f = min(f-1, a-1);
        }

        return ans;

    }

    int min(int a, int b) {
        if(a > b) return b;
        return a;
    }
}