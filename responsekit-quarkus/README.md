# Response Kit - Quarkus

This is the integration library to use ResponseKit with quarkus. This module have the transient dependency of `responsekit-core`, then you don't need to install it too. 

## Features

- Idiomatic Factory for PagedResponse with `PagedResponseFactory` class.
- Integration with PanacheQuery.

## Examples of use

1. Full paged response creation with PanacheQuery and entity mapper.

````java
import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.quarkus.PagedResponseFactory;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

class App {
   @Inject
   YourMapper yourMapper;

   public PagedResponse<YourDTO> getAll(int page, int size) {
      PanacheQuery query = YourEntity.findAll()
              .page(page, size);

      return PagedResponseFactory.fromQuery(query, yourMapper::toResponse);
   }
}

@ApplicationScoped
class YourMapper {
    public YourDTO toResponse(YourEntity entity){
//        ...
    }
}
````

<br> 

2. Entity mapper using Lambda expresion.

````java
class App {
    public PagedResponse<YourDTO> getAll(){
       PanacheQuery query = YourEntity.findAll()
               .page(page, size);

       return PagedResponseFactory.fromQuery(query, (YourEntity) -> {
//           your conversions...
       });
    }
}
````