package io.github.responsekit.spring;

import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.spring.exception.InvalidEntityMapperException;
import io.github.responsekit.spring.exception.InvalidPageException;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PagedResponseFactoryTests {
    @Test
    public void fromPageTestCase1(){
        assertThrows(InvalidPageException.class, () -> {
            PagedResponseFactory.fromPage(
                    null,
                    (object) -> object
            );
        });
    }

    @Test
    public void fromPageTestCase2(){
        assertThrows(InvalidEntityMapperException.class, () -> {
            PagedResponseFactory.fromPage(
                    new PageImpl<>(List.of()),
                    null
            );
        });
    }

    @Test
    public void fromPageTestCase3(){
        var expected = PagedResponse
                .content(List.of())
                .page(0)
                .size(10)
                .isLast(true)
                .totalPages(0)
                .totalElements(0)
                .build();

        Page<Object> page = new PageImpl<>(List.of(), PageRequest.of(0, 10), 0);

        var result = PagedResponseFactory.fromPage(
                page,
                (object) -> object
        );

        assertEquals(expected, result);
    }

    @Test
    public void fromPageTestCase4(){
        var expected = PagedResponse
                .content(List.of("string1", "string2"))
                .page(0)
                .size(10)
                .isLast(true)
                .totalPages(1)
                .totalElements(2)
                .build();

        Page<Object> page = new PageImpl<>(List.of("string1", "string2"), PageRequest.of(0, 10), 2);

        var result = PagedResponseFactory.fromPage(
                page,
                (object) -> object
        );

        assertEquals(expected, result);
    }
}