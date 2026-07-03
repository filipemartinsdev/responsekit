# Response Kit - Spring

This is the integration library to use ResponseKit with Spring. This module have the transient dependency of `responsekit-core`, then you don't need to install it too. 

## Features

- Offset-based pagination response with `PagedResponseFactory`.
- Cursor-based pagination response with `SlicedResponseFactory`.
- Integration with `Page` and `Slice`.

## Examples of use

1. Response with Offset-based pagination.

````java
import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.spring.PagedResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

class App {
    @Autowired
    YourRepository yourRepository; // Any JpaRepository
    
    public PagedResponse<YourDTO> getAll(Pageable pageable) {
        Page<YourEntity> page = yourRepository.findAll(pageable);

        return PagedResponseFactory.fromPage(page, this::responseMapper);
    }

    // Map an entity to DTO
    private YourDTO responseMapper(YourEntity entity){
        // ...
    }
}
````

<br>

2. Response with Cursor-based pagination.

````java
import io.github.responsekit.core.SlicedResponse;
import io.github.responsekit.spring.SlicedResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

class App {
    @Autowired
    YourRepository yourRepository; // Any JpaRepository

    public SlicedResponse<YourDTO> getAll(Object yourCursor, Pageable pageable) {
        Slice<YourEntity> slice = yourRepository.findAll(yourCursor, pageable); // Your custom query for cursor pagination

        return SlicedResponseFactory.fromSlice(slice, this::responseMapper, this::cursorExtractor);
    }
    
    // Map an entity to DTO
    private YourDTO responseMapper(YourEntity entity){
        // ...
    }
    
    // Extract cursor from entity. You can use any lambda expression that returns a string
    private String cursorExtractor(YourEntity entity){
        // ...
    }
}
````