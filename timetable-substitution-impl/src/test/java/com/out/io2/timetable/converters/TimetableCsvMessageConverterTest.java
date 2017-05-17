package com.out.io2.timetable.converters;

import com.out.io2.timetable.api.TimetableCsvRequest;
import com.out.io2.timetable.api.TimetableRequest;
import com.out.io2.timetable.parers.TimetableRequestParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;

import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TimetableCsvMessageConverterTest {
    @Mock
    private TimetableRequestParser  timetableRequestParser;
    @InjectMocks
    private TimetableCsvMessageConverter messageConverter;

    @Test
    public void shouldReturnTrueForSupportedClass() {
        //when
        boolean actual = messageConverter.supports(TimetableRequest.class);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    public void shouldReturnFalseForUnsupportedClass() {
        //when
        boolean actual = messageConverter.supports(String.class);

        //then
        assertThat(actual).isFalse();
    }

    @Test
    public void shouldThrowOnInvokeWrite() {
        assertThatThrownBy(() -> messageConverter.writeInternal(mock(TimetableRequest.class), mock(HttpOutputMessage.class)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void shouldReturnTimetableRequest() throws Exception{
        //given
        HttpInputMessage inputMessage = mock(HttpInputMessage.class);
        when(inputMessage.getBody()).thenReturn(new ByteArrayInputStream("a".getBytes()));
        TimetableCsvRequest request = mock(TimetableCsvRequest.class);
        List<TimetableCsvRequest> expectedList = Collections.singletonList(request);
        when(timetableRequestParser.parse("a".getBytes())).thenReturn(expectedList);

        //then
        assertThat(messageConverter.readInternal(TimetableRequest.class, inputMessage).getTimetableCsvRequests())
                .containsOnlyOnce(request);
    }

    @Test
    public void shouldThrowExceptionWithNull() {
        //then
        assertThatThrownBy(() -> messageConverter.readInternal(TimetableRequest.class, null))
                .isInstanceOf(NullPointerException.class);
    }
}