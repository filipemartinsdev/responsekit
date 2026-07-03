package io.github.responsekit.spring;

import io.github.responsekit.core.SlicedResponse;
import io.github.responsekit.spring.exception.InvalidCursorExtractorException;
import io.github.responsekit.spring.exception.InvalidEntityMapperException;
import io.github.responsekit.spring.exception.InvalidSliceException;
import org.springframework.data.domain.Slice;

import java.util.ArrayList;
import java.util.function.Function;

public class SlicedResponseFactory {
    public static <I, O> SlicedResponse<O> fromSlice(Slice<I> slice, Function<I, O> entityMapper, Function<I, String> cursorExtractor){
        if (slice == null)
            throw new InvalidSliceException("Slice is null");

        if (entityMapper == null)
            throw new InvalidEntityMapperException("EntityMapper is null");

        if (cursorExtractor == null)
            throw new InvalidCursorExtractorException("CursorExtractor is null");

        if (slice.getContent().isEmpty())
            return empty(slice.getSize());

        return SlicedResponse
                .content(slice.getContent().stream()
                        .map(entityMapper)
                        .toList()
                )
                .firstCursor(cursorExtractor.apply(slice.getContent().get(0)))
                .lastCursor(cursorExtractor.apply(slice.getContent().get(slice.getContent().size() - 1)))
                .size(slice.getSize())
                .isLast(slice.isLast())
                .build();
    }

    private static <O> SlicedResponse<O> empty(int size) {
        return SlicedResponse
                .content(new ArrayList<O>())
                .firstCursor(null)
                .lastCursor(null)
                .size(size)
                .isLast(true)
                .build();
    }
}
