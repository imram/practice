package string;

import java.util.Arrays;

/**
 * Created by ramgupta on 6/17/18.
 */
public class MyString {
    private char[] values;

    public MyString(char... c) {

        this.values = Arrays.copyOf(c, c.length);
    }

    public MyString() {
        this.values = "".toCharArray();

    }

    public MyString(String s) {
        this.values = Arrays.copyOf(s.toCharArray(), s.length());
    }

    public int length() {
        return this.values.length;
    }

    public char charAt(int i) {
        if (values.length <= i) {
            throw new MyStringIndexOutOfBoundException(i);
        }
        return this.values[i];
    }

    public int indexOf(char c) {
        if (this.values.length == 0)
            return -1;
        char[] chars = this.values;
        int index = 0;
        while (index < chars.length) {
            if (chars[index] == c) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int indexOf(char c, int startIndex) {
        if (this.values.length == 0 || startIndex >= values.length)
            return -1;
        char[] chars = this.values;
        while (startIndex < chars.length) {
            if (chars[startIndex] == c)
                return startIndex;
            startIndex++;
        }
        return -1;
    }

    public int lastIndexOf(char c) {
        if (values.length == 0)
            return -1;
        int index = values.length - 1;
        while (index >= 0) {
            if (values[index] == c) {
                return index;
            }
            index--;
        }
        return -1;
    }

    public int compareTo(String s) {
        if (s.length() == 0) {
            if (values.length > 0)
                return 1;
            else if (values.length == 0)
                return 0;
        }
        if (values.length != s.length()) {
            if (values.length < s.length())
                return -1;
            else
                return 1;
        }
        int index = 0;
        while (index < values.length) {
            int char1 = values[index];
            int char2 = s.charAt(index);

            if (char1 > char2)
                return 1;
            else if (char1 < char2)
                return -1;
            else
                index++;
        }
        return 0;
    }

    public MyString concat(MyString s) {
        if(this.values.length ==0 && s.length() == 0) return new MyString("");

        int index = 0;
        char[] chars = this.values;
        int otherLength = s.length();
        char[] newChars = new char[values.length + otherLength];

        while (index < chars.length) {
            newChars[index] = chars[index];
            index++;
        }

        if (otherLength > 0) {
            int otherIndex = 0;
            while (otherIndex < otherLength) {
                newChars[index] = s.charAt(otherIndex);
                otherIndex++;
                index++;
            }
        }

        return new MyString(newChars);
    }

    public static class MyStringIndexOutOfBoundException extends IndexOutOfBoundsException {
        public MyStringIndexOutOfBoundException(int i) {
            super("" + i);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof MyString)) return false;
        MyString other = (MyString) obj;
        if(values.length == 0 && other.length() == 0) return true;
        if(this.values.length != other.length()) return false;

        int index = 0;

        while (index < values.length) {
            if(this.values[index] != other.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    @Override public int hashCode() {
        return super.hashCode();
    }

    @Override public String toString() {
        return new String(this.values);
    }
}
