package io.github.responsekit;

import io.github.responsekit.core.PagedResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PagedResponseTests {
    @Test
    public void builderTestCase1(){
        PagedResponse<Void> response = PagedResponse
                .content(new ArrayList<Void>())
                .build();

        assertNull(response.page);
        assertNull(response.size);
        assertNull(response.isLast);
        assertNull(response.totalPages);
        assertNull(response.totalElements);
        assertTrue(response.content.isEmpty());
    }

    @Test
    public void builderTestCase2(){
        List<String> content = List.of("element1", "element2", "element3");
        Long page = 0L;
        boolean isLast = true;
        Long size = 20L;
        Long totalPages = 1L;
        Long totalElements = 3L;

        PagedResponse<String> response = PagedResponse
                .content(content)
                .page(page)
                .isLast(isLast)
                .size(size)
                .totalPages(totalPages)
                .totalElements(totalElements)
                .build();

        assertEquals(content, response.content);
        assertEquals(page, response.page);
        assertEquals(isLast, response.isLast);
        assertEquals(size, response.size);
        assertEquals(totalPages, response.totalPages);
        assertEquals(totalElements, response.totalElements);
    }
}