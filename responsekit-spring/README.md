# Response Kit - Spring

This is the integration library to use ResponseKit with Spring. This module have the transient dependency of `responsekit-core`, then you don't need to install it too. 

## Features

- Idiomatic Factory for PagedResponse with `PagedResponseFactory` class.
- Integration with Page class (JPA Repository response).

## Examples of use

1. Full paged response creation with PanacheQuery and entity mapper.

````java
import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.spring.PagedResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

class App {
    @Autowired
    YourMapper yourMapper;

//    Any JpaRepository
    @Autowired
    YourRepository yourRepository;
    
    public PagedResponse<YourDTO> getAll(Pageable pageable) {
        Page<YourEntity> page = yourRepository.findAll(pageable);

        return PagedResponseFactory.fromPage(page, yourMapper::toResponse);
    }
}

@Component
class YourMapper {
    public YourDTO toResponse(YourEntity entity) {
//        ...
    }
}
````

<br> 

2. Entity mapper using Lambda expresion.

````java
import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.spring.PagedResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

class App {
//    Any JpaRepository
    @Autowired
    YourRepository yourRepository;
    
    public PagedResponse<YourDTO> getAll(){
       Page<YourEntity> page = yourRepository.findAll(pageable);

       return PagedResponseFactory.fromPage(page, (YourEntity) -> {
//           your conversions...
       });
    }
}
````