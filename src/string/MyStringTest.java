package string;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by ramgupta on 6/17/18.
 */
public class MyStringTest {

    @Test
    public void createStringClass() {
        assertThat(new MyString(), isA(MyString.class));
        assertThat(new MyString('a').length(), is(1));
        assertThat(new MyString('a', 'b').length(), is(2));
        assertThat(new MyString("a").length(), is(1));
    }

    @Test
    public void givwnString_returnCharAtIndex() {
        assertThat(new MyString("abcd").charAt(2), is('c'));
    }

    @Test(expected = MyString.MyStringIndexOutOfBoundException.class)
    public void givwnEmptyString_charAtIndexReturnsException() {
        assertThat(new MyString("").charAt(0), is('a'));
    }

    @Test
    public void givenEmptyString_returnsMinusOne() {
        assertThat(new MyString("").indexOf('a'), is(-1));
    }

    @Test
    public void givenStringWithOneChar_FoundSearchReturnsPositionIndex() {
        assertThat(new MyString("a").indexOf('a'), is(0));
    }

    @Test
    public void givenStringWithTwoChar_FoundSearchIn2ndReturnsPositionIndex1() {
        assertThat(new MyString("ab").indexOf('b'), is(1));
    }

    @Test
    public void givenSearchCharAndStartIndex_returnsPositionIndex() {
        assertThat(new MyString("").indexOf('b', 0), is(-1));
        assertThat(new MyString("a").indexOf('a', 0), is(0));
        assertThat(new MyString("a").indexOf('a', 1), is(-1));
        assertThat(new MyString("ab").indexOf('b', 0), is(1));
        assertThat(new MyString("aba").indexOf('a', 1), is(2));
    }


    @Test
    public void givenSearchCharReturnsPositionLastIndexOf() {
        assertThat(new MyString("").lastIndexOf('c'), is(-1));
        assertThat(new MyString("a").lastIndexOf('a'), is(0));
        assertThat(new MyString("ab").lastIndexOf('a'), is(0));
        assertThat(new MyString("aba").lastIndexOf('a'), is(2));
        assertThat(new MyString("abacdfebrd").lastIndexOf('b'), is(7));
    }

    @Test
    public void givenTwoString_ReturnsTheirComparisionResult() {
        assertThat(new MyString().compareTo(""), is(0));
        assertThat(new MyString("a").compareTo(""), is(1));
        assertThat(new MyString("a").compareTo("b"), is(-1));
        assertThat(new MyString("ab").compareTo("aa"), is(1));
        assertThat(new MyString("ab").compareTo("abc"), is(-1));
        assertThat(new MyString("abc").compareTo("ab"), is(1));
    }

    @Test
    public void givenTwoStringReturnsConcatenatedString() {
        assertThat(new MyString().concat(new MyString("")), is(new MyString("")));
        assertThat(new MyString("a").concat(new MyString("")), is(new MyString("a")));
        assertThat(new MyString("aa").concat(new MyString("")), is(new MyString("aa")));
        assertThat(new MyString("").concat(new MyString("a")), is(new MyString("a")));
        assertThat(new MyString("").concat(new MyString("aa")), is(new MyString("aa")));
        assertThat(new MyString("abcde").concat(new MyString("fghij")), is(new MyString("abcdefghij")));
    }

    @Test
    public void verifyEquals() {
        assertThat(new MyString().equals(null), is(false));
        assertThat(new MyString().equals(new MyString()), is(true));
        assertThat(new MyString("a").equals(new MyString("a")), is(true));
        assertThat(new MyString("a").equals(new MyString("b")), is(false));
        assertThat(new MyString("ab").equals(new MyString("aa")), is(false));
        assertThat(new MyString("a").equals("a"), is(false));
    }

    @Test
    public void verifyToString() {
        assertThat(new MyString().toString(), is(""));
        assertThat(new MyString("abcdef").toString(), is("abcdef"));
    }




}
