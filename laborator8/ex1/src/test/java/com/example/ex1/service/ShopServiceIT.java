package com.example.ex1.service;


import com.example.ex1.model.AlbumDetails;
import com.example.ex1.repository.AlbumDetailsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@ActiveProfiles("test")
public class ShopServiceIT{

    @Autowired
    private ShopService shopService;

//    @MockBean
//    private AlbumDetailsRepository albumDetailsRepository;

    @Test
    @DisplayName("Create album details - happy flow")
    public void createAlbumDetailsHappyFlow(){
        AlbumDetails albumDetails = new AlbumDetails("Test AlbumDetails");

//        when(albumDetailsRepository.save(albumDetails)).thenReturn(albumDetails);
        AlbumDetails result = shopService.saveAlbumDetails(albumDetails);

        assertEquals(result.getDescription(), albumDetails.getDescription());
    }

}
