package io.github.responsekit.spring;

import org.junit.Test;
import org.springframework.data.domain.*;

import io.github.responsekit.core.SlicedResponse;
import io.github.responsekit.spring.exception.InvalidCursorExtractorException;
import io.github.responsekit.spring.exception.InvalidEntityMapperException;
import io.github.responsekit.spring.exception.InvalidSliceException;

import static org.junit.Assert.*;

import java.util.List;

public class SlicedResponseFactoryTests {
    @Test
    public void fromSliceTestCase1(){
        assertThrows(InvalidSliceException.class, () -> {
            SlicedResponseFactory.fromSlice(
                    null,
                    (value) -> value,
                    (value) -> ""
            );
        });
    }

    @Test
    public void fromSliceTestCase2(){
        assertThrows(InvalidEntityMapperException.class, () -> {
            SlicedResponseFactory.fromSlice(
                    new SliceImpl<>(List.of()),
                    null,
                    (value) -> ""
            );
        });
    }

    @Test
    public void fromSliceTestCase3(){
        assertThrows(InvalidCursorExtractorException.class, () -> {
            SlicedResponseFactory.fromSlice(
                    new SliceImpl<>(List.of()),
                    (value) -> value,
                    null
            );
        });
    }

    @Test
    public void fromSliceTestCase4(){
        var expected = SlicedResponse
                .content(List.of())
                .size(10)
                .isLast(true)
                .firstCursor(null)
                .lastCursor(null)
                .build();

        Slice<Object> slice = new SliceImpl<>(List.of(), PageRequest.of(0, 10), false);

        var result = SlicedResponseFactory.fromSlice(
                slice,
                (object) -> object,
                (object) -> ""
        );

        assertEquals(expected, result);
    }

    @Test
    public void fromSliceTestCase5(){
        var expected = SlicedResponse
                .content(List.of("string1", "string2"))
                .size(10)
                .isLast(true)
                .firstCursor("cursor string1")
                .lastCursor("cursor string2")
                .build();

        Slice<Object> slice = new SliceImpl<>(List.of("string1", "string2"), PageRequest.of(0, 10), false);

        var result = SlicedResponseFactory.fromSlice(
                slice,
                (object) -> object,
                (object) -> "cursor " + object
        );

        assertEquals(expected, result);
    }
}
