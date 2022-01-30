package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    void getTrelloApiEndpoint() {
        //Given
        String trelloApiEndpoint = trelloConfig.getTrelloApiEndpoint();

        //When & Then
        assertEquals("https://api.trello.com/1", trelloApiEndpoint);
    }

    @Test
    void getTrelloAppKey() {
        //Given
        String trelloAppKey = trelloConfig.getTrelloAppKey();

        //When & Then
        assertEquals("224608de5a9b6daa5ba5bc1aabde2b5e", trelloAppKey);
    }

    @Test
    void getTrelloToken() {
        //Given
        String trelloToken = trelloConfig.getTrelloToken();

        //When & Then
        assertEquals("ca9dd1b96a32f76e70dd283d48a69fef1c3730aa45a55632e8ec9cda39239784", trelloToken);
    }

    @Test
    void getTrelloUser() {
        //Given
        String trelloUser = trelloConfig.getTrelloUser();

        //When & Then
        assertEquals("micha52631660", trelloUser);
    }
}