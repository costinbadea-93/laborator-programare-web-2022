package com.example.ex1.controller;

import com.example.ex1.model.Album;
import com.example.ex1.model.AlbumDetails;
import com.example.ex1.repository.AlbumDetailsRepository;
import com.example.ex1.repository.AlbumRepository;
import com.example.ex1.repository.ArtistRepository;
import com.example.ex1.repository.ShopRepository;
import com.example.ex1.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ShopController.class)
public class ShopControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();
    @MockBean
    private AlbumDetailsRepository albumDetailsRepository;
    @MockBean
    private AlbumRepository albumRepository;
    @MockBean
    private ArtistRepository artistRepository;
    @MockBean
    private ShopRepository shopRepository;

    @MockBean
    private ShopService shopService;


    @Test
    public void createAlbumDetails() throws Exception{
        AlbumDetails albumDetails = new AlbumDetails("Some new AlbumDetails");

        when(shopService.saveAlbumDetails(any())).thenReturn(albumDetails);

        mockMvc.perform(post("/shop/albumDetails/new")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(albumDetails)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.description").value(albumDetails.getDescription())
        );
    }

    @Test
    public void createAlbum() throws Exception{
        Album album = new Album("Album1", 5);
        String albumDetailsId = "1";
        String artistId = "1";

        when(shopService.saveAlbum(any(),anyInt(),anyInt())).thenReturn(album);

        mockMvc.perform(post("/shop/album/new/")
        .contentType("application/json")
        .content(objectMapper.writeValueAsString(album))
        .param("albumDetailsId", albumDetailsId)
        .param("artistId", artistId))
                .andExpect(status().is2xxSuccessful())
                .andExpect((jsonPath("$.albumName")).value(album.getAlbumName()))
                .andExpect((jsonPath("$.albumQuantity")).value(album.getAlbumQuantity()));
    }

}
