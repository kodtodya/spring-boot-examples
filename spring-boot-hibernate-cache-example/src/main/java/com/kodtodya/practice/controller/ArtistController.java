package com.kodtodya.practice.controller;

import com.kodtodya.practice.model.ArtistModel;
import com.kodtodya.practice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/artistManagement")
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    
    @GetMapping("/artists")
    public List<ArtistModel> getAllRecords(){
        return artistService.getAllRecords();
    }

    @GetMapping("/artist/{id}")
    public ArtistModel getRecordById(@PathVariable Long id){
        return artistService.getRecordById(id);
    }

    @GetMapping("/artist")
    public Set<ArtistModel> getRecordByAttribute(@RequestParam String city){
        return artistService.getRecordByAttribute(city);
    }

    @PostMapping("/artist")
    public ArtistModel save(final @RequestBody ArtistModel artistModel){
        return artistService.save(artistModel);
    }

    @DeleteMapping("/artist/{id}")
    public Boolean delete(@PathVariable Long id){
        return artistService.delete(id);
    }
}
