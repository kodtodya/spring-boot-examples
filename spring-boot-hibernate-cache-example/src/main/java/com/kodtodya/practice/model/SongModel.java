package com.kodtodya.practice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongModel {

    private Long id;

    private String title;

    private String lyrics;

    private Set<ArtistModel> artist;
}
