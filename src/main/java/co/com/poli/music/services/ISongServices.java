package co.com.poli.music.services;

import java.util.List;

import co.com.poli.music.model.Song;

public interface ISongServices {

    List<Song> getAll();
    
    Song get(Integer id);

    boolean create(Song song);

    boolean update(Song song);

    boolean delete(Song song);

}
