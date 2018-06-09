package staircase;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DownStairsTest {

    @Test
    public void test() {
        assertThat( downStairCase( 1, 1 ), is( "#" ) );
        assertThat( downStairCase( 2, 1 ), is( "#" ) );
        assertThat( downStairCase( 2, 2 ), is( "#\n##" ) );
        assertThat( downStairCase( 3, 3 ), is( "#\n##\n###" ) );
    }

    private String downStairCase(int c, int r) {
        String downstairs = "";
        int lastRow = r - 1;

        for (int rowIndex = 0; rowIndex < r; rowIndex++) {
            for (int columnIndex = 0; columnIndex < c; columnIndex++) {
                if (rowIndex >= columnIndex)
                    downstairs += "#";
            }
            if (rowIndex != lastRow) {
                downstairs += "\n";
            }
        }
        return downstairs;
    }
}
