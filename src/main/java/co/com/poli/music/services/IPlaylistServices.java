package co.com.poli.music.services;

import java.util.List;

import co.com.poli.music.model.Playlist;

public interface IPlaylistServices {

    List<Playlist> getAll();

    Playlist get(Integer id);

    boolean create(Playlist playlist);

    boolean update(Playlist playlist);

    boolean delete(Playlist playlist);

}
