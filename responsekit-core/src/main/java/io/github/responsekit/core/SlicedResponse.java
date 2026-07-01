package io.github.responsekit.core;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/*
 * Template for response using Cursor-Based Pagination.
 * **/
public class SlicedResponse<T> implements Serializable {
    public final String firstCursor;
    public final String lastCursor;
    public final Long size;
    public final Boolean isLast;
    public final List<T> content;

    private SlicedResponse(String firstCursor, String lastCursor, Long size, Boolean isLast, List<T> content) {
        this.firstCursor = firstCursor;
        this.lastCursor = lastCursor;
        this.size = size;
        this.isLast = isLast;
        this.content = content;
    }

    public static <T> Builder<T> content(List<T> content) {
        return new Builder<T>().content(content);
    }

    public static class Builder<T> {
        public String firstCursor;
        public String lastCursor;
        public Long size;
        public Boolean isLast;
        public List<T> content;

        public Builder<T> firstCursor(String firstCursor) {
            this.firstCursor = firstCursor;
            return this;
        }

        public Builder<T> lastCursor(String lastCursor) {
            this.lastCursor = lastCursor;
            return this;
        }

        public Builder<T> size(long size) {
            this.size = size;
            return this;
        }

        public Builder<T> isLast(boolean isLast) {
            this.isLast = isLast;
            return this;
        }

        private Builder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public SlicedResponse<T> build() {
            return new SlicedResponse<>(firstCursor, lastCursor, size, isLast, content);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SlicedResponse<?> that = (SlicedResponse<?>) o;
        return Objects.equals(firstCursor, that.firstCursor) && Objects.equals(lastCursor, that.lastCursor) && Objects.equals(size, that.size) && Objects.equals(isLast, that.isLast) && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstCursor, lastCursor, size, isLast, content);
    }

    @Override
    public String toString() {
        return "SlicedResponse{" +
                "firstCursor='" + firstCursor + '\'' +
                ", lastCursor='" + lastCursor + '\'' +
                ", size=" + size +
                ", isLast=" + isLast +
                ", content=" + content +
                '}';
    }
}
