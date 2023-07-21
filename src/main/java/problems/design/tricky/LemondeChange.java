package problems.design.tricky;

/*
there is a queue of customers. They want to buy lemonade from us which costs 5 rupees.
The customers can give us 5 rupees, 10 rupees, or 20 rupees.
We need to answer if we can successfully return the correct amount of change to each customer or not.
 */
public class LemondeChange {

    public static boolean lemonadeChange(int[] bills) {
        int five =0 , ten =0, twenty = 0;

        for(int coin : bills) {
            if(coin == 5) {
                five++;
            } else if(coin == 10) {
                ten++;
                if(five > 0) five--;
                else return false;
            } else if(coin == 20) {
                if (five > 1 && ten > 0) {
                    five = five - 2;
                    ten--;
                } else if(five > 2) {
                    five = five -3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] arr = {5,5,5,10,20};
        boolean ans= lemonadeChange(arr);
        System.out.println(ans);
    }
}
