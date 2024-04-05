package com.kodtodya.practice.service;

import com.kodtodya.practice.domain.Artist;
import com.kodtodya.practice.model.ArtistModel;
import com.kodtodya.practice.model.SongModel;
import com.kodtodya.practice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("artistService")
public class ArtistService implements ModelService<ArtistModel, Artist> {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public ArtistModel save(ArtistModel artistModel) {
        return this.toModel(artistRepository.save(this.toEntity(artistModel)));
    }

    @Override
    public boolean delete(Long id) {
        artistRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ArtistModel> getAllRecords() {
        List<Artist> artists = artistRepository.findAll();

        return artists.stream().map(artist -> {
            return toModel(artist);
        }).toList();
    }

    @Override
    public ArtistModel getRecordById(Long id) {
        return this.toModel(artistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Artist not found")));
    }

    @Override
    public Set<ArtistModel> getRecordByAttribute(String value) {
        return artistRepository.findByAttribute(value).stream().map(artist -> this.toModel(artist)).collect(Collectors.toSet());
    }

    @Override
    public ArtistModel toModel(final Artist artist) {
        return ArtistModel.builder()
                .id(artist.getId())
                .name(artist.getName())
                .city(artist.getCity())
                .build();
    }

    @Override
    public Artist toEntity(ArtistModel artistModel) {
        Artist artist = new Artist();
        artist.setId(artistModel.getId());
        artist.setName(artistModel.getName());
        artist.setCity(artistModel.getCity());
        return artist;
    }
}
