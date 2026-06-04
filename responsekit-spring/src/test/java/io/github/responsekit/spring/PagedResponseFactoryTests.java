package io.github.responsekit.spring;

import io.github.responsekit.core.PagedResponse;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class PagedResponseFactoryTests {

    @Test
    public void fromPageTestCase1() {
        PagedResponse<String> expectedResponse = PagedResponse
                .content(List.of("element1", "element2"))
                .page(0)
                .size(2)
                .isLast(true)
                .totalElements(2)
                .totalPages(1)
                .build();

        PagedResponse<String> response = PagedResponseFactory.fromPage(
                new Page(){
                    @Override
                    public Iterator iterator() {
                        return expectedResponse.content.stream().iterator();
                    }

                    @Override
                    public int getNumber() {
                        return 0;
                    }

                    @Override
                    public int getSize() {
                        return expectedResponse.content.size();
                    }

                    @Override
                    public int getNumberOfElements() {
                        return expectedResponse.content.size();
                    }

                    @Override
                    public List getContent() {
                        return expectedResponse.content;
                    }

                    @Override
                    public boolean hasContent() {
                        return true;
                    }

                    @Override
                    public Sort getSort() {
                        return null;
                    }

                    @Override
                    public boolean isFirst() {
                        return true;
                    }

                    @Override
                    public boolean isLast() {
                        return true;
                    }

                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public boolean hasPrevious() {
                        return false;
                    }

                    @Override
                    public Pageable nextPageable() {
                        return null;
                    }

                    @Override
                    public Pageable previousPageable() {
                        return null;
                    }

                    @Override
                    public int getTotalPages() {
                        return expectedResponse.totalPages.intValue();
                    }

                    @Override
                    public long getTotalElements() {
                        return expectedResponse.totalElements;
                    }

                    @Override
                    public Page map(Function converter) {
                        return null;
                    }
                },

                (str) -> str
        );

        assertEquals(expectedResponse.page, response.page);
        assertEquals(expectedResponse.size, response.size);
        assertEquals(expectedResponse.isLast, response.isLast);
        assertEquals(expectedResponse.totalPages, response.totalPages);
        assertEquals(expectedResponse.totalElements, response.totalElements);
        assertEquals(expectedResponse.content, response.content);
    }
}