package com.out.io2.timetable.converters;


import com.out.io2.timetable.api.TimetableRequest;
import com.out.io2.timetable.parers.TimetableRequestParser;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public class TimetableCsvMessageConverter extends AbstractHttpMessageConverter<TimetableRequest> {
    private TimetableRequestParser timetableRequestParser;

    public TimetableCsvMessageConverter(TimetableRequestParser timetableRequestParser) {
        this.timetableRequestParser = timetableRequestParser;
    }

    @Override
    protected boolean supports(Class aClass) {
        return aClass.equals(TimetableRequest.class);
    }

    @Override
    protected TimetableRequest readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return new TimetableRequest(timetableRequestParser.parse(IOUtils.toByteArray(httpInputMessage.getBody())));
    }

    @Override
    protected void writeInternal(TimetableRequest o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        throw new UnsupportedOperationException("This mapper should only read messages");
    }
}
