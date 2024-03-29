package org.howard.edu.finals.problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SongsDatabaseTest {
    SongsDatabase db;

    @BeforeEach
    void setUp() {
        // Initialize the SongsDatabase object and add sample data
        db = new SongsDatabase();
        db.addSong("Rap", "All the above");
        db.addSong("Rap", "Hey Man");
        db.addSong("Jazz", "Always There");
    }

    @Test
    void testAddSong() {
        // Test adding a new song to the database
        db.addSong("Pop", "Shape of You");
        Set<String> songs = db.getSongs("Pop");
        assertTrue(songs.contains("Shape of You"));

        // Test adding a song to an existing genre
        db.addSong("Rap", "HUMBLE");
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("HUMBLE"));

        // Test adding a song with the same title to the same genre
        db.addSong("Rap", "All the above");
        rapSongs = db.getSongs("Rap");
        assertEquals(3, rapSongs.size()); // This should pass now since duplicate songs are not counted
    }

    @Test
    void testGetSongs() {
        // Test retrieving songs of a specific genre
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("All the above") && rapSongs.contains("Hey Man"));

        // Test retrieving songs of a genre with no songs
        db.addSong("EmptyGenre", "EmptySong");
        db.addSong("EmptyGenre", "EmptySong2");
        db.getSongs("EmptyGenre").clear();
        Set<String> emptyGenreSongs = db.getSongs("EmptyGenre");
        assertTrue(emptyGenreSongs.isEmpty());
    }

    @Test
    void testGetGenreOfSong() {
        // Test retrieving the genre of a specific song
        assertEquals("Rap", db.getGenreOfSong("All the above"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));

        // Test retrieving the genre of a song with multiple genres
        db.addSong("Alternative", "All the above");
        String genre = db.getGenreOfSong("All the above");
        assertTrue(genre.equals("Rap") || genre.equals("Alternative"));
    }

    @Test
    void testGetSongsForNonExistentGenre() {
        // Test retrieving songs for a non-existent genre
        Set<String> songs = db.getSongs("NonExistentGenre");
        assertTrue(songs.isEmpty());
    }

    @Test
    void testGetGenreOfNonExistentSong() {
        // Test retrieving the genre of a non-existent song
        assertNull(db.getGenreOfSong("NonExistentSong"));
    }
}
