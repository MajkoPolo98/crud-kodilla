package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    TrelloMapper trelloMapper;

    @Test
    void mapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        TrelloBoardDto board = new TrelloBoardDto("1", "name", new ArrayList<>());
        trelloBoardDtos.add(board);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(trelloBoardDtos.get(0).getName(), trelloBoards.get(0).getName());
    }

    @Test
    void mapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        TrelloBoard board = new TrelloBoard("1", "name", new ArrayList<>());
        trelloBoards.add(board);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(trelloBoards.get(0).getName(), trelloBoardDtos.get(0).getName());
    }

    @Test
    void mapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "name", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(trelloListDtos.get(0).getName(), trelloLists.get(0).getName());
    }

    @Test
    void mapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "name", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(trelloLists.get(0).getName(),trelloListDtos.get(0).getName());
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("name", "desc", "pos", "2");

        //When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        //Then
        assertEquals(card.getName(), cardDto.getName());
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("name", "desc", "pos", "2");

        //When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        //Then
        assertEquals(cardDto.getName(), card.getName());
    }
}