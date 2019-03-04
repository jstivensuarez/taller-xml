package co.com.poli.music.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.poli.music.dao.IPlaylistDAO;
import co.com.poli.music.model.Playlist;
import co.com.poli.music.services.IPlaylistServices;

@Service
public class IPlaylistServicesImpl implements IPlaylistServices {

    @Autowired
    private IPlaylistDAO playlistDAO;

    @Override
    @Transactional(readOnly = false)
    public List<Playlist> getAll() {
        return (List<Playlist>) playlistDAO.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Playlist get(Integer id) {
        return playlistDAO.findById(id).get();
    }

    @Override
    @Transactional
    public boolean create(Playlist playlist) {
        try {
            playlistDAO.save(playlist);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean update(Playlist playlist) {
        try {
            playlistDAO.save(playlist);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean delete(Playlist playlist) {
        try {
            playlistDAO.delete(playlist);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
