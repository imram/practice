package sparsearrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SparseArrayTest {

    private void aseertQueryStrings(String[] strings, String[] queries, int[] expected) {
        assertThat(matchingStrings(strings, queries), is(expected));
    }

    @Test
    public void test() {
        aseertQueryStrings(null, null, new int[] {});
        aseertQueryStrings(new String[] {""}, null, new int[] {});
        aseertQueryStrings(new String[] {"a"}, new String[] {"a"}, new int[] {1});
        aseertQueryStrings(new String[] {"a"}, new String[] {"b"}, new int[] {0});
        aseertQueryStrings(new String[] {"a", "a"}, new String[] {"a"}, new int[] {2});
        aseertQueryStrings(new String[] {"a", "b"}, new String[] {"a"}, new int[] {1});
        aseertQueryStrings(new String[] {"a", "b"}, new String[] {"a", "b"}, new int[] {1, 1});
        aseertQueryStrings(new String[] {"a", "b", "a", "c"}, new String[] {"a", "b", "d"}, new int[] {2, 1, 0});
    }

    private int[] matchingStrings(String[] strings, String[] queries) {
        if (strings == null)
            return new int[] {};
        if (queries == null) {
            return new int[] {};
        }

        int[] res = new int[queries.length];

        for (int index = 0; index < queries.length; index++)
            res[index] = searchQueryString(strings, queries[index]);

        return res;

    }

    private int searchQueryString(String[] strings, String query) {
        int count = 0;
        for (String string : strings)
            if (string.equals(query))
                ++count;
        return count;
    }
}
