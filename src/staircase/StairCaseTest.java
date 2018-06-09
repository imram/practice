package staircase;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;

public class StairCaseTest {
    @Test
    public void staircaseWithOneStep() {
        Assert.assertThat( stairCase( 1 ), is( "#" ) );

    }

    @Test
    public void staircaseWithTwoSteps() {
        Assert.assertThat( stairCase( 2 ), is(
                "  #\n"
                        + "# #" ) );

    }

    @Test
    public void staircaseWithThreeSteps() {
        Assert.assertThat( stairCase( 3 ), is( "    #\n"
                + "  # #\n"
                + "# # #" ) );

    }

    private String stairCase(int n) {
        String stairs = "";
        int lastIndex = n - 1;

        for (int rowIndex = 0; rowIndex < n; rowIndex++) {
            for (int columnIndex = 0; columnIndex < n; columnIndex++) {
                if (columnIndex < lastIndex - rowIndex) {
                    stairs += " ";
                } else {
                    stairs += "#";
                }
                /*if (columnIndex != lastIndex) {
                    stairs += " ";
                }*/
            }
            if (rowIndex != lastIndex) {
                stairs += "\n";
            }
        }

        System.out.println(stairs);

        return stairs;
    }
}
