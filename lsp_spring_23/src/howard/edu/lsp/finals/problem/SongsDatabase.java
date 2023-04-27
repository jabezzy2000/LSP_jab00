package howard.edu.lsp.finals.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
    // Map to store genres and their corresponding songs
    private Map<String, HashSet<String>> map = new HashMap<>();

    /**
     * Add a song to a specific genre.
     *
     * @param genre     The genre of the song.
     * @param songTitle The title of the song.
     */
    public void addSong(String genre, String songTitle) {
        // If the genre does not exist in the map, create a new HashSet for the genre
        // and add the song title to the HashSet
        map.computeIfAbsent(genre, k -> new HashSet<>()).add(songTitle);
    }

    /**
     * Get all the songs of a specific genre.
     *
     * @param genre The genre of the songs.
     * @return A set containing all the songs of the specified genre.
     */
    public Set<String> getSongs(String genre) {
        // Return the set of songs for the genre or an empty HashSet if the genre does not exist
        return map.getOrDefault(genre, new HashSet<>());
    }

    /**
     * Get the genre of a specific song.
     *
     * @param songTitle The title of the song.
     * @return The genre of the song, or null if the song is not found.
     */
    public String getGenreOfSong(String songTitle) {
        // Iterate through the map entries to find the genre of the song
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(songTitle)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
