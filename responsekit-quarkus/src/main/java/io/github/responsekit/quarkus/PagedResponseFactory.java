package io.github.responsekit.quarkus;

import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.quarkus.exception.InvalidEntityMapperException;
import io.github.responsekit.quarkus.exception.InvalidQueryException;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import java.util.ArrayList;
import java.util.function.Function;


public class PagedResponseFactory {
    public static <I, O> PagedResponse<O> fromQuery(PanacheQuery<I> query, Function<I, O> entityMapper){
        if (query == null)
            throw new InvalidQueryException("Query is null");

        if (entityMapper == null)
            throw new InvalidEntityMapperException("EntityMapper is null");

        if (query.list().isEmpty())
            return empty(query.page().size);

        return PagedResponse
                .content(
                        query.stream()
                                .map(entityMapper)
                                .toList()
                )
                .page(query.page().index)
                .size(query.page().size)
                .isLast(!query.hasNextPage())
                .totalElements(query.count())
                .totalPages(query.pageCount())
                .build();
    }

    private static <O> PagedResponse<O> empty(int size) {
        return PagedResponse
                .content(new ArrayList<O>())
                .page(0)
                .size(size)
                .isLast(true)
                .totalElements(0L)
                .totalPages(0)
                .build();
    }
}
