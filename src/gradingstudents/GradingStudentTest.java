package gradingstudents;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GradingStudentTest {
    @Test
    public void test() {
        assertThat(gradingStudents(30), is(new int[] {30}));
        assertThat(gradingStudents(38), is(new int[] {40}));
        assertThat(gradingStudents(30, 38), is(new int[] {30, 40}));
        assertThat(gradingStudents(73, 67, 38, 33), is(new int[] {75, 67, 40, 33}));
        assertThat(gradingStudents(99), is(new int[] {100}));
    }

    private int[] gradingStudents(int... grades) {
        int[] result = new int[grades.length];
        int index = 0;

        for (int grade : grades) {
            if (grade < 38) {
                result[index] = grade;
            } else {
                int nextMultipleOf5 = grade + (5 - grade % 5);
                if (nextMultipleOf5 - grade < 3) {
                    result[index] = nextMultipleOf5;
                } else {
                    result[index] = grade;
                }
            }
            index++;
        }
        return result;
    }
}
