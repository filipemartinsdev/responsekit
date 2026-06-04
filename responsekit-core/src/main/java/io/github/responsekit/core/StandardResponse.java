package io.github.responsekit.core;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
* Template for API responses, following JSend pattern.
* **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardResponse<T> {
    public final String status;
    public final String message;
    public final T data;

    private StandardResponse() {
        this(null, null, null);
    }

    private StandardResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Builder<Void> success(){
        return new Builder<Void>().status(Status.SUCCESS);
    }

    public static <T> Builder<T> success(T data){
        return new Builder<T>().status(Status.SUCCESS).data(data);
    }

    public static Builder<Void> fail(){
        return new Builder<Void>().status(Status.FAIL);
    }

    public static <T> Builder<T> fail(T data){
        return new Builder<T>().status(Status.FAIL).data(data);
    }

    public static Builder<Void> error(){
        return new Builder<Void>().status(Status.ERROR);
    }

    public static <T> Builder<T> error(T data){
        return new Builder<T>().status(Status.ERROR).data(data);
    }


    public static enum Status {
        SUCCESS("success"), FAIL("fail"), ERROR("error");

        public final String value;

        Status(String label) {
            this.value = label;
        }
    }

    public static class Builder<T> {
        private Status status;
        private String message;
        private T data;

        private Builder() {}

        private Builder<T> status(Status status){
            this.status = status;
            return this;
        }

        public Builder<T> message(String message){
            this.message = message;
            return this;
        }

        private Builder<T> data(T data){
            this.data = data;
            return this;
        }

        public StandardResponse<T> build(){
            return new StandardResponse<T>(this.status.value, this.message, this.data);
        }
    }
}

