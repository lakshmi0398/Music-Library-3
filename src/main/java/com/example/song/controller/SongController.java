
package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.SongJpaService;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SongController {
  @Autowired
  public SongJpaService songJpaService;

  @GetMapping("/songs")
  public ArrayList<Song> getSongs() {
    return songJpaService.getSongs();
  }

  @PostMapping("/songs")
  public Song addSong(@RequestBody Song song) {
    return songJpaService.addSong(song);
  }

  @GetMapping("/songs/{songId}")
  public Song getSongById(@PathVariable int songId) {
    return songJpaService.getSongById(songId);
  }

  @PutMapping("/songs/{songId}")
  public Song updateSong(@PathVariable int songId, @RequestBody Song song) {
    return songJpaService.updateSong(songId, song);
  }

  @DeleteMapping("/songs/{songId}")
  public void deleteSongById(@PathVariable int songId) {
    songJpaService.deleteSongById(songId);
  }
}