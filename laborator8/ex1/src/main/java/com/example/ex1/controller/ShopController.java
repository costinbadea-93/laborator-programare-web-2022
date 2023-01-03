package com.example.ex1.controller;

import com.example.ex1.model.Album;
import com.example.ex1.model.AlbumDetails;
import com.example.ex1.model.Artist;
import com.example.ex1.model.Shop;
import com.example.ex1.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to Shop Controller!!!!")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }

    @PostMapping("/artist/new")
    public ResponseEntity<Artist> saveArtist(@RequestBody Artist artist){
        return ResponseEntity.ok()
                .body(shopService.saveNewArtist(artist));
    }

    @PostMapping("/albumDetails/new")
    @ApiOperation(value = "Some new album details", response = AlbumDetails.class, tags = "newAlbum")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    public ResponseEntity<AlbumDetails> saveAlbumDetails(@RequestBody AlbumDetails albumDetails){
        return ResponseEntity.ok()
                .body(shopService.saveAlbumDetails(albumDetails));
    }

    @PostMapping("/album/new")
    public ResponseEntity<Album> saveAlbum(@RequestBody Album album,
                                           @RequestParam int albumDetailsId,
                                           @RequestParam int artistId){
        return ResponseEntity.ok().body(shopService.saveAlbum(album, albumDetailsId, artistId));
    }

    @PostMapping("/shop/new")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop,
                                         @RequestParam List<Integer> albumIds){
        return ResponseEntity.ok().body(shopService.saveShop(shop, albumIds));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Shop>> retrieveShops() {
        return ResponseEntity.ok().body(shopService.retrieveShops());
    }

    @GetMapping("/albumByName")
    public ResponseEntity<Album> retrieveByName(@RequestParam String albumName){
        return ResponseEntity.ok().body(shopService.retrieveAlbumByName(albumName));
    }

    @PostMapping("/artist/bulkLoad")
    public ResponseEntity<String> addBulkLoadArtist(){
        return ResponseEntity.ok().body(shopService.bulkLoadArtist(20));
    }


}
