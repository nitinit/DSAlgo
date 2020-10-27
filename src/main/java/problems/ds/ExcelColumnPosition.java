package problems.ds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelColumnPosition {

    public int getExcelColumnPosition(String pos) {
        int result = 0;
        for (int i = 0; i < pos.length(); i++) {
            result *= 26;
            result += pos.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public String getColumnPosition(int num) {
        StringBuffer result = new StringBuffer();

        while (num > 0) {
            char tmpPos = (char) (num % 26 + 'A' - 1);
            result.append(tmpPos);
            num = num / 26;
        }
        return result.toString();
    }

    @Test
    public void test1() {
        assertEquals(1, getExcelColumnPosition("A"));
        assertEquals(27, getExcelColumnPosition("AA"));
        assertEquals(703, getExcelColumnPosition("AAA"));
    }

    @Test
    public void test2() {
        assertEquals("A", getColumnPosition(1));
        assertEquals("AA", getColumnPosition(27));
        assertEquals("AAA", getColumnPosition(703));
    }

    // 1 3 5
    // 2 4 6
}