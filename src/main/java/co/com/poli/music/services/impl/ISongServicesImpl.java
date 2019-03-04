package co.com.poli.music.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.poli.music.dao.ISongDAO;
import co.com.poli.music.model.Playlist;
import co.com.poli.music.model.Song;
import co.com.poli.music.services.ISongServices;

@Service
public class ISongServicesImpl implements ISongServices {

    @Autowired
    private ISongDAO songDAO;

    @Override
    @Transactional(readOnly = false)
    public List<Song> getAll() {
        return (List<Song>) songDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly = false)
    public Song get(Integer id) {
        return songDAO.findById(id).get();
    }
    
    @Override
    @Transactional
    public boolean create(Song song) {
        try {
            songDAO.save(song);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean update(Song song) {
        try {
            songDAO.save(song);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Song song) {
        try {
            songDAO.delete(song);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
