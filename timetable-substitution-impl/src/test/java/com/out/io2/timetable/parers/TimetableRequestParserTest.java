package com.out.io2.timetable.parers;

import com.out.io2.timetable.api.TimetableCsvRequest;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TimetableRequestParserTest {
    private static byte [] BYTE_CSV = ("DAY;WEEK;SUBJECT;HOUR;CLASSROOM;TYPE;TEACHER_ID;\n" +
            "PONIEDZIALEK;PARZYSTY;IO;3;053BT;WYKLAD;1;").getBytes();

    private TimetableRequestParser timetableRequestParser = new TimetableRequestParser();

    @Test
    public void shouldReturnParsedObjectFromBytes() throws Exception {
        //when
        List<TimetableCsvRequest> request = timetableRequestParser.parse(BYTE_CSV);

        //then
        assertThat(request).hasSize(1);
        assertThat(request.get(0)).isEqualToComparingFieldByField(expectedRequest());
    }

    @Test
    public void shouldThrowNPE() {
        assertThatThrownBy(() -> timetableRequestParser.parse(null))
        .isInstanceOf(NullPointerException.class);
    }

    private TimetableCsvRequest expectedRequest() {
        return new TimetableCsvRequest("PONIEDZIALEK", "PARZYSTY", "IO", "3", "053BT", "WYKLAD", "1");

    }

}