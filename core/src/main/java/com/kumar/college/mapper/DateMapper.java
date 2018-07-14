package com.kumar.college.mapper;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public class DateMapper {

    public static final String EST_ZONE = "EST";

   public DateTime toDateValue(Long value) {
       return new DateTime(value, DateTimeZone.forTimeZone(TimeZone.getTimeZone(EST_ZONE)));
   }

    public Long toLongValue(DateTime dateTime) {
        return dateTime.toDateTime(DateTimeZone.UTC).getMillis();
    }

}
