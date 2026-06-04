# Response Kit - Core

This is the base library for ResponseKit.

If you want to use ResponseKit with **Spring/Quarkus**, it's recommended to use the integration modules `responsekit-spring` or `responsekit-quarkus` instead of this.

## Features

- Standard response using `StandardResponse` class.
- Paginated responses using `PagedResponse` class.

## Examples of use

1. Simple [JSend](https://github.com/omniti-labs/jsend) response.

    ````java
    import io.github.responsekit.core.StandardResponse;
    
    class App {
        public StandardResponse<Void> hello(){
            return StandardResponse
                    .success()
                    .message("Hello World!")
                    .build();
        }
    }
    ````
    
    JSON view:
    
    ````json
    {
      "status": "success",
      "message": "Hello World!"
    }
    ````
<br> 


2. Response with data.

    ````java
    import io.github.responsekit.core.StandardResponse;
    
    class App {
        public StandardResponse<Person> hello(){
            Person p = new Person(1, "Filipe");
   
            return StandardResponse
                    .success(p)
                    .message("Person retrieved successfully")
                    .build();
        }
    }
   
    record Person (int id, String name){}
    ````

   JSON view:

    ````json
    {
      "status": "success",
      "message": "Person retrieved successfully",
      "data": {
        "id": 1,
        "name": "Filipe"
      }
    }
    ````
<br> 


3. Paginated response.

    ````java
    
    import io.github.responsekit.core.PagedResponse;
    
    import java.util.List;
    
    class App {
        public PagedResponse<String> getAll() {
            return PagedResponse.content(List.of("Hello!"))
                    .page(0)
                    .size(1)
                    .isLast(true)
                    .totalPages(1)
                    .totalElements(1)
                    .build();
        }
    }
    ````

   JSON view:

    ````json
    {
      "page": 0,
      "size": 1,
      "isLast": true,
      "totalPages": 1,
      "totalElements": 1,
      "content": ["Hello!"]
    }
    ````
<br> 


3. Full Paginated JSend standard response.

    ````java
    
    import io.github.responsekit.core.PagedResponse;import io.github.responsekit.core.StandardResponse;
    
    import java.util.List;
    
    class App {
        public StandardResponse<PagedResponse<String>> getAll() {
            return StandardResponse.success(
                    PagedResponse.content(List.of("Hello!"))
                            .page(0)
                            .size(1)
                            .isLast(true)
                            .totalPages(1)
                            .totalElements(1)
                            .build()
            ).build();
        }
    }
    ````

   JSON view:

    ````json
    {
      "status": "success",
      "data": {
        "page": 0,
        "size": 1,
        "isLast": true,
        "totalPages": 1,
        "totalElements": 1,
        "content": ["Hello!"]
      }
    }
    ````
<br> 