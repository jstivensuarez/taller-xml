package co.com.poli.music.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.poli.music.model.Song;

public interface ISongDAO extends CrudRepository<Song, Integer> {

}
