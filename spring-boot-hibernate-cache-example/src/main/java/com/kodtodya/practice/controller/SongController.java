package com.kodtodya.practice.controller;

import com.kodtodya.practice.model.SongModel;
import com.kodtodya.practice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/songsManagement")
public class SongController {

    @Autowired
    private SongService songService;
    
    @GetMapping("/songs")
    public List<SongModel> getAllRecords(){
        return songService.getAllRecords();
    }

    @GetMapping("/song/{id}")
    public SongModel getRecordById(@PathVariable Long id){
        return songService.getRecordById(id);
    }

    @GetMapping("/song")
    public Set<SongModel> getRecordByAttribute(@RequestParam String lyrics){
        return songService.getRecordByAttribute(lyrics);
    }

    @PostMapping("/song")
    public SongModel save(final @RequestBody SongModel songModel){
        return songService.save(songModel);
    }

    @DeleteMapping("/song/{id}")
    public Boolean delete(@PathVariable Long id){
        return songService.delete(id);
    }
}
