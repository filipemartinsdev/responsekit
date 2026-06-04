package io.github.responsekit.spring;

import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.spring.exception.InvalidEntityMapperException;
import io.github.responsekit.spring.exception.InvalidPageException;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.function.Function;

public class PagedResponseFactory {
    public <I, O> PagedResponse<O> fromPage(Page<I> page, Function<I, O> entityMapper){
        if (page == null)
            throw new InvalidPageException("Page is null");

        if (entityMapper == null)
            throw new InvalidEntityMapperException("EntityMapper is null");

        if (page.getContent().isEmpty())
            return empty(page.getSize());

        return PagedResponse
                .content(page.getContent().stream()
                        .map(entityMapper)
                        .toList()
                )
                .page(page.getNumber())
                .size(page.getSize())
                .isLast(page.isLast())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }

    private <O> PagedResponse<O> empty(int size) {
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
