package problems.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {

    public static List<String> giveValidIPAdress(String ipAddress) {
        List<String> validIPAddress = new ArrayList<>();

        for(int i = 1; i <=3 && i < ipAddress.length(); i++) {
            String firstPart = ipAddress.substring(0, i);
            if(isValidIP(firstPart));
            {
                for (int j=1; j <=3 && i+j <ipAddress.length(); j++) {
                    String secondPart = ipAddress.substring(i, i+j);
                    if(isValidIP(secondPart)) {
                        for (int k=1; k <=3 && i+j+k <ipAddress.length(); k++) {
                            String thirdPart = ipAddress.substring(i+j, i+j+k);
                            String forthPart = ipAddress.substring(i+j+k);
                            if(isValidIP(thirdPart) && isValidIP(forthPart)) {
                                validIPAddress.add(firstPart + "." + secondPart + "." + thirdPart + "." + forthPart);
                            }
                        }
                        }
                    }
                }
            }
        return validIPAddress;
    }

    public static boolean isValidIP(String s) {
        int i = Integer.parseInt(s);
        if (s.length() > 1 && i ==0) {
            return false;
        }
        if(i > 255) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        List<String> validIPAddress = giveValidIPAdress("25525511135");
        validIPAddress.forEach(s -> System.out.println(s));
    }
}
