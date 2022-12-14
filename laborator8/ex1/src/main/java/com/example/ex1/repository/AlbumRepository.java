package com.example.ex1.repository;

import com.example.ex1.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album findAlbumByAlbumName(String name);

    @Query("select a from Album a where a.albumName = :name")
    Album findAlbumByAlbumNameWithJpql(@Param("name") String name);

    @Query(value = "select * from album a where a.album_name = :name", nativeQuery = true)
    Album findAlbumByAlbumNameWithNativeQuery(String name);
}
