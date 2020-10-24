package ds.algo;

public class ExcelPosition {

    public static int getExcelColumnPosition(String pos) {
        int result = 0;
        for (int i = 0; i < pos.length(); i++) {
            result *= 26;
            result += pos.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getExcelColumnPosition("AAA"));
    }
}