package com.kodtodya.practice.model;

import com.kodtodya.practice.domain.Artist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistModel {

    private Long id;

    private String name;

    private String city;
}
