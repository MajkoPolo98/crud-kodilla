package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {
    @InjectMocks
    TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Mock
    SimpleEmailService simpleEmailService;

    @Mock
    AdminConfig adminConfig;

    @Test
    void fetchTrelloBoards() {
        //Given
        List<TrelloListDto> trelloListDtos = List.of(new TrelloListDto("1", "name", false));
        List<TrelloBoardDto> trelloBoardDtos = List.of(new TrelloBoardDto("1", "name", trelloListDtos));

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);

        //When
        List<TrelloBoardDto> boardDtos = trelloService.fetchTrelloBoards();

        //Then
        assertNotNull(boardDtos);
        assertEquals(trelloBoardDtos, boardDtos);

    }

    @Test
    void createTrelloCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("name", "descr", "pos", "1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "name", "url");

        when(trelloClient.createNewCard(cardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto createdCard = trelloService.createTrelloCard(cardDto);

        //Then
        assertNotNull(createdCard);
        assertEquals(createdTrelloCardDto, createdCard);

    }
}