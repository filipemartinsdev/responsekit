# Response Kit - Quarkus

This is the integration library to use ResponseKit with quarkus. This module have the transient dependency of `responsekit-core`, then you don't need to install it too. 

## Features

- Idiomatic Factory for PagedResponse with `PagedResponseFactory` class.
- Integration with PanacheQuery.

## Examples of use

Response with Offset-based pagination.

````java
import io.github.responsekit.core.PagedResponse;
import io.github.responsekit.quarkus.PagedResponseFactory;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

class App {
   public PagedResponse<YourDTO> getAll(int page, int size) {
      PanacheQuery query = YourEntity.findAll()
              .page(page, size);

      return PagedResponseFactory.fromQuery(query, this::responseMapper);
   }

    // Map an entity to DTO
    private YourDTO responseMapper(YourEntity entity){
        // ...
    }
}
````