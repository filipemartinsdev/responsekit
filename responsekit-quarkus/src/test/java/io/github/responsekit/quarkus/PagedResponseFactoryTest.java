package io.github.responsekit.quarkus;

import io.github.responsekit.core.PagedResponse;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.runtime.PanacheQueryImpl;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import jakarta.persistence.LockModeType;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class PagedResponseFactoryTest {
    @Test
    public void fromQueryTestCase1(){
        PagedResponse<String> expectedResponse = PagedResponse
                .content(List.of("element1", "element2"))
                .page(0)
                .size(2)
                .isLast(true)
                .totalElements(2)
                .totalPages(1)
                .build();

        PagedResponse<String> response = PagedResponseFactory.fromQuery(
                new PanacheQuery(){
                    @Override
                    public boolean hasNextPage() {
                        return false;
                    }

                    @Override
                    public boolean hasPreviousPage() {
                        return false;
                    }

                    @Override
                    public int pageCount() {
                        return expectedResponse.totalPages.intValue();
                    }

                    @Override
                    public Page page() {
                        return Page.of(0, expectedResponse.size.intValue());
                    }

                    @Override
                    public long count() {
                        return expectedResponse.totalElements;
                    }

                    @Override
                    public Optional singleResultOptional() {
                        return Optional.empty();
                    }

                    @Override
                    public Object singleResult() {
                        return null;
                    }

                    @Override
                    public Optional firstResultOptional() {
                        return Optional.empty();
                    }

                    @Override
                    public Object firstResult() {
                        return null;
                    }

                    @Override
                    public Stream stream() {
                        return expectedResponse.content.stream();
                    }

                    @Override
                    public List list() {
                        return expectedResponse.content;
                    }

                    @Override
                    public PanacheQuery filter(String filterName) {
                        return null;
                    }

                    @Override
                    public PanacheQuery filter(String filterName, Map parameters) {
                        return null;
                    }

                    @Override
                    public PanacheQuery filter(String filterName, Parameters parameters) {
                        return null;
                    }

                    @Override
                    public PanacheQuery withHint(String hintName, Object value) {
                        return null;
                    }

                    @Override
                    public PanacheQuery withLock(LockModeType lockModeType) {
                        return null;
                    }

                    @Override
                    public PanacheQuery range(int startIndex, int lastIndex) {
                        return null;
                    }

                    @Override
                    public PanacheQuery lastPage() {
                        return null;
                    }

                    @Override
                    public PanacheQuery firstPage() {
                        return null;
                    }

                    @Override
                    public PanacheQuery previousPage() {
                        return null;
                    }

                    @Override
                    public PanacheQuery nextPage() {
                        return null;
                    }

                    @Override
                    public PanacheQuery page(int pageIndex, int pageSize) {
                        return null;
                    }

                    @Override
                    public PanacheQuery page(Page page) {
                        return null;
                    }

                    @Override
                    public PanacheQuery project(Class type) {
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