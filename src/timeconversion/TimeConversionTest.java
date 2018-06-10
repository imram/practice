package timeconversion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TimeConversionTest {

    public static final String DATE_12HOUR_FORMAT = "[0-9]*:?[0-9]*:?[0-9]*(AM|PM)";

    @Test
    public void test() {
        assertThat(timeConversion(null), is(nullValue()));
        assertThat(timeConversion(""), is(""));
        assertThat(timeConversion("01:05:10AM"), is("01:05:10"));

        assertThat(timeConversion("01:05:10PM"), is("13:05:10"));
        assertThat(timeConversion("11:05:10PM"), is("23:05:10"));

        assertThat(timeConversion("11:05:10AM"), is("11:05:10"));
        assertThat(timeConversion("12:05:10AM"), is("00:05:10"));
        assertThat(timeConversion("01:00:10AM"), is("01:00:10"));
        assertThat(timeConversion("12:00:10AM"), is("00:00:10"));
        assertThat(timeConversion("01:05:10PM"), is("13:05:10"));
        assertThat(timeConversion("01:05:30AM"), is("01:05:30"));
        assertThat(timeConversion("12:45:54PM"), is("12:45:54"));
    }

    static private String timeConversion(String s) {
        if (s == null) {
            return null;
        }
        String hour = "";

        if (s.matches(DATE_12HOUR_FORMAT)) {
            String ampm = getAMPMFormat(s);
            if (ampm.matches("PM|pm")) {
                String hour24 = convert12HourTo24HourFormat(getHour(s));
                hour = hour24;
            } else if (ampm.matches("AM|am")) {
                String hour12 = getHour(s);
                if (Integer.parseInt(hour12) == 12) {
                    hour = "00";
                } else {
                    hour = hour12;
                }
            }
        }

        return hour + getMinutes(s) + getSeconds(s);
    }

    static private String getMinutes(String s) {
        String min = "";
        if (s.indexOf(':') != -1) {
            min = ":" + s.substring(3, 5);
        }
        return min;

    }

    static private String getSeconds(String s) {
        String sec = "";
        if (s.split(":").length == 3)
            sec = ":" + s.substring(6, 8);
        return sec;

    }

    static private String convert12HourTo24HourFormat(String hour12) {

        Integer hourInt = Integer.valueOf(hour12);
        return hourInt == 12 ? hour12 : Integer.toString(12 + hourInt);
    }

    static private String getAMPMFormat(String s) {
        return s.substring(s.length() - 2, s.length());
    }

    static private String getHour(String s) {
        return s.substring(0, 2);
    }

}
