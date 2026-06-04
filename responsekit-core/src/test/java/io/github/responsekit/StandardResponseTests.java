package io.github.responsekit;

import io.github.responsekit.core.StandardResponse;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StandardResponseTests {

    @Test
    public void successTestCase1(){
        String expectedStatus = "success";

        StandardResponse<Void> response = StandardResponse
                .success()
                .build();

        assertEquals(expectedStatus, response.status);
        assertNull(response.message);
        assertNull(response.data);
    }

    @Test
    public void successTestCase2(){
        String expectedStatus = "success";
        String expectedMessage = "test";

        StandardResponse<Void> response = StandardResponse
                .success()
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertNull(response.data);
    }

    @Test
    public void successTestCase3(){
        String expectedStatus = "success";
        String expectedMessage = "test";
        String expectedData = "dataTest";

        StandardResponse<String> response = StandardResponse
                .success(expectedData)
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertEquals(expectedData, response.data);
    }

    @Test
    public void successTestCase4(){
        String expectedStatus = "success";
        String expectedMessage = "test";
        Map<String, Object> expectedData = Map.of("id", 1, "name", "any");

        StandardResponse<Map<String, Object>> response = StandardResponse
                .success(expectedData)
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertEquals(expectedData, response.data);
    }


    @Test
    public void failTestCase1(){
        String expectedStatus = "fail";

        StandardResponse<Void> response = StandardResponse
                .fail()
                .build();

        assertEquals(expectedStatus, response.status);
        assertNull(response.message);
        assertNull(response.data);
    }

    @Test
    public void failTestCase2(){
        String expectedStatus = "fail";
        String expectedMessage = "test";

        StandardResponse<Void> response = StandardResponse
                .fail()
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertNull(response.data);
    }

    @Test
    public void failTestCase3(){
        String expectedStatus = "fail";
        String expectedMessage = "test";
        String expectedData = "dataTest";

        StandardResponse<String> response = StandardResponse
                .fail(expectedData)
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertEquals(expectedData, response.data);
    }

    @Test
    public void failTestCase4(){
        String expectedStatus = "fail";
        String expectedMessage = "test";
        Map<String, Object> expectedData = Map.of("id", 1, "name", "any");

        StandardResponse<Map<String, Object>> response = StandardResponse
                .fail(expectedData)
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertEquals(expectedData, response.data);
    }


    @Test
    public void errorTestCase1(){
        String expectedStatus = "error";

        StandardResponse<Void> response = StandardResponse
                .error()
                .build();

        assertEquals(expectedStatus, response.status);
        assertNull(response.message);
        assertNull(response.data);
    }

    @Test
    public void errorTestCase2(){
        String expectedStatus = "error";
        String expectedMessage = "test";

        StandardResponse<Void> response = StandardResponse
                .error()
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertNull(response.data);
    }

    @Test
    public void errorTestCase3(){
        String expectedStatus = "error";
        String expectedMessage = "test";
        String expectedData = "dataTest";

        StandardResponse<String> response = StandardResponse
                .error(expectedData)
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertEquals(expectedData, response.data);
    }

    @Test
    public void errorTestCase4(){
        String expectedStatus = "error";
        String expectedMessage = "test";
        Map<String, Object> expectedData = Map.of("id", 1, "name", "any");

        StandardResponse<Map<String, Object>> response = StandardResponse
                .error(expectedData)
                .message(expectedMessage)
                .build();

        assertEquals(expectedStatus, response.status);
        assertEquals(expectedMessage, response.message);
        assertEquals(expectedData, response.data);
    }
}