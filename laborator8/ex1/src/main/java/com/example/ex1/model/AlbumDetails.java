package com.example.ex1.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "album_details")
@ApiModel(value="AlbumDetails", description="Sample model for the documentation")
public class AlbumDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int albumDetailsId;
//    @Column(name = "description")
    @ApiModelProperty(notes = "Name of the Album", name="some name",required=true,value="some value", example = "some album detail")
    private String description;

    public AlbumDetails() {
    }

    public AlbumDetails(String description) {
        this.description = description;
    }

    public int getAlbumDetailsId() {
        return albumDetailsId;
    }

    public void setAlbumDetailsId(int albumDetailsId) {
        this.albumDetailsId = albumDetailsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
