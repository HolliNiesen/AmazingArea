package com.mathtasticgames.persistence.rest;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersApiTest {

    @Test
    public void testNumbersApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://numbersapi.com/1/trivia");

        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("1 ", response.substring(0, 2));
    }
}
