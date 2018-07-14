package com.kumar.college.framework.util;

import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class DateUtil {

    public static final String UTC_TIME_ZONE = "UTC";

    public static final String EST_TIME_ZONE = "EST";

    public static final String DATE_TIME_FORMAT = "dd-MMM-YY HH:mm:ss.SSS";

    public static final DateTimeZone EST_DATE_TIME_ZONE = DateTimeZone.forTimeZone(TimeZone.getTimeZone(EST_TIME_ZONE));

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(DATE_TIME_FORMAT);

    public static final DateTimeFormatter EST_DATE_TIME_FORMATTER = DATE_TIME_FORMATTER.withLocale(Locale.US).withZone(EST_DATE_TIME_ZONE);

    private DateUtil() {
    }

    public static Long setMillisForAudit(DateTime createdDate) {
        return createdDate == null ? new DateTime(DateTimeZone.UTC).getMillis()
                : createdDate.toDateTime(DateTimeZone.UTC).getMillis();
    }

	public static DateTime getCurrentEstDate() {
        return new DateTime(EST_DATE_TIME_ZONE);
    }

    public static DateTime getEstDateFromMillis(Long millis) {
        return new DateTime(millis, EST_DATE_TIME_ZONE);
    }

}
