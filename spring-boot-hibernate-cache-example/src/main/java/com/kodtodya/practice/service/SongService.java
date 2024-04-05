package com.kodtodya.practice.service;

import com.kodtodya.practice.domain.Song;
import com.kodtodya.practice.model.SongModel;
import com.kodtodya.practice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("songService")
public class SongService implements ModelService<SongModel, Song> {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistService artistService;

    @Override
    public SongModel save(SongModel songModel) {
        return this.toModel(songRepository.save(this.toEntity(songModel)));
    }

    @Override
    public boolean delete(Long id) {
        songRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SongModel> getAllRecords() {
        List<Song> songs = songRepository.findAll();

        return songs.stream().map(song -> {
            return toModel(song);
        }).toList();
    }

    @Override
    public SongModel getRecordById(Long id) {
        return this.toModel(songRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Song not found")));
    }

    @Override
    public Set<SongModel> getRecordByAttribute(String value) {
        return songRepository.findByAttribute(value).stream().map(song -> this.toModel(song)).collect(Collectors.toSet());
    }

    @Override
    public SongModel toModel(final Song song) {
        return SongModel.builder()
                .id(song.getId())
                .title(song.getTitle())
                .lyrics(song.getLyrics())
                .artist(song.getArtists().stream().map(artist -> artistService.toModel(artist)).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public Song toEntity(SongModel songModel) {
        return new Song(
                songModel.getId(),
                songModel.getTitle(),
                songModel.getLyrics(),
                songModel.getArtist().stream().map(artist -> artistService.toEntity(artist)).collect(Collectors.toSet())
        );
    }
}
