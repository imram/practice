package paragraph;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ramgupta on 6/21/18.
 */
public class ParagraphWordWiseReverseTest {

    private void assertReverseParagraph(String paragraph, String expected) {
        assertThat(paragraphReverse(paragraph), is(expected));
    }

    @Test
    public void verifyReverseEachWord() {
        assertReverseParagraph(null, "");
        assertReverseParagraph("", "");
        assertReverseParagraph("a", "a");
        assertReverseParagraph("ab", "ba");
        assertReverseParagraph("abc", "cba");
        assertReverseParagraph("abcd", "dcba");
        assertReverseParagraph("abcd a", "dcba a");
        assertReverseParagraph("abcd ab", "dcba ba");
        assertReverseParagraph("abcd ab def", "dcba ba fed");
        assertReverseParagraph("   abcd      ab     def  ", "dcba ba fed");
    }

    private String paragraphReverse(String paragraph) {
        if (paragraph == null)
            return "";

        StringBuilder builder = new StringBuilder();
        String[] words = paragraph.trim().split("\\s+");

        for (int index = 0; index < words.length; index++) {
            builder.append(new String(reverseWord(words[index])));
            if (index + 1 != words.length)
                builder.append(" ");
        }

        return builder.toString();

    }

    private char[] reverseWord(String word) {
        char[] chars = word.toCharArray();
        if (chars.length == 1)
            return chars;
        for (int firstIndex = 0, lastIndex = chars.length - 1; firstIndex < lastIndex; firstIndex++, lastIndex--)
            swap(chars, firstIndex, lastIndex);
        return chars;
    }

    private void swap(char[] chars, int firstIndex, int lastIndex) {
        char tmp = chars[firstIndex];
        chars[firstIndex] = chars[lastIndex];
        chars[lastIndex] = tmp;
    }
}
