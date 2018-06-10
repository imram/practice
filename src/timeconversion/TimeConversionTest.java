package timeconversion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TimeConversionTest {
    @Test
    public void test() {
        assertThat(convertTime(null), is(nullValue()));
        assertThat(convertTime(""), is(""));
        assertThat(convertTime("01:05:10AM"), is("01:05:10"));

        assertThat(convertTime("01:05:10PM"), is("13:05:10"));
        assertThat(convertTime("11:05:10PM"), is("23:05:10"));

        assertThat(convertTime("11:05:10AM"), is("11:05:10"));
        assertThat(convertTime("12:05:10AM"), is("00:05:10"));
        assertThat(convertTime("01:00:10AM"), is("01:00:10"));
        assertThat(convertTime("12:00:10AM"), is("00:00:10"));
        assertThat(convertTime("01:05:10PM"), is("13:05:10"));
        assertThat(convertTime("01:05:30AM"), is("01:05:30"));
    }

    private String convertTime(String s) {
        if (s == null) {
            return null;
        }
        String result = "";

        if (s.matches("[0-9]*:?[0-9]*:?[0-9]*(AM|PM)")) {
            String ampm = getAMPMFormat(s);
            if (ampm.matches("PM|pm")) {
                String hour24 = convert12HourTo24HourFormat(getHour(s));
                result += hour24;
            } else if (ampm.matches("AM|am")) {
                String hour12 = getHour(s);
                if (Integer.parseInt(hour12) == 12) {
                    result += "00";
                } else {
                    result += hour12;
                }
            }
        }

        result += getMinutes(s);
        result += getSeconds(s);

        return result;
    }

    private String getMinutes(String s) {
        String min = "";
        if (s.indexOf(':') != -1) {
            min = ":" + s.substring(3, 5);
        }
        return min;

    }

    private String getSeconds(String s) {
        String sec = "";
        if (s.split(":").length == 3)
            sec = ":" + s.substring(6, 8);
        return sec;

    }

    private String getTimeWithNoAMPM(String s) {
        return s.substring(0, s.length() - 2);
    }

    private String convert12HourTo24HourFormat(String hour12) {
        return Integer.toString(12 + Integer.valueOf(hour12));
    }

    private String getAMPMFormat(String s) {
        return s.substring(s.length() - 2, s.length());
    }

    private String getHour(String s) {
        return s.substring(0, 2);
    }

}
