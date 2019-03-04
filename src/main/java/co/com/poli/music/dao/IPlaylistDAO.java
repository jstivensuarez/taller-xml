package co.com.poli.music.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.music.model.Playlist;

public interface IPlaylistDAO extends CrudRepository<Playlist, Integer> {

}
