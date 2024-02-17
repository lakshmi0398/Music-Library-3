/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here

package com.example.song.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;
import com.example.song.model.Song;

// Don't modify the below code
@Service
public class SongJpaService implements SongRepository {

  @Autowired
  public SongJpaRepository SongJpaRepository;

  // Don't modify the above code

  // Write your code here
  @Override
  public ArrayList<Song> getSongs() {
    Collection<Song> songCollection = SongJpaRepository.findAll();
    ArrayList<Song> songs = new ArrayList<>(songCollection);
    return songs;

  }

  @Override

  public Song addSong(Song song) {
    SongJpaRepository.save(song);
    return song;

  }

  @Override
  public Song getSongById(int songId) {
    try {
      Song song = SongJpaRepository.findById(songId).get();
      return song;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public Song updateSong(int songId, Song song) {

    try {
      Song newSong = SongJpaRepository.findById(songId).get();

      if (song.getSongName() != null) {
        newSong.setSongName(song.getSongName());

      }
      if (song.getMusicDirector() != null) {
        newSong.setMusicDirector(song.getMusicDirector());

      }
      if (song.getLyricist() != null) {

        newSong.setLyricist(song.getLyricist());
      }
      if (song.getSinger() != null) {

        newSong.setSinger(song.getSinger());
      }

      SongJpaRepository.save(newSong);
      return newSong;
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public void deleteSongById(int songId) {
    try {
      SongJpaRepository.deleteById(songId);
    }

    catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
  }

}