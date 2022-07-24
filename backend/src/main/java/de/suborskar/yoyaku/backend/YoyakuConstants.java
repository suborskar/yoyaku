package de.suborskar.yoyaku.backend;

import java.time.format.DateTimeFormatter;

public class YoyakuConstants {
    private YoyakuConstants() {
        throw new IllegalStateException("No instance of this one");
    }

    public static class Time {
        private Time() {
            throw new IllegalStateException("No instance of this one");
        }
        public static final  String DATE_FORMAT = "dd.MM.yyyy";

        public  static final  String DATE_TIME_FORMAT = "hh:mm dd.MM.yyyy";

        public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

        public static final  DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    }
}
