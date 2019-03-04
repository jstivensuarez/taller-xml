package co.com.poli.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="songs")
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String artist;

    @NotEmpty
    private String title;

    @NotEmpty
    private String yearsong;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Playlist playlist;

    public Song() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearsong() {
        return this.yearsong;
    }

    public void setYearsong(String yearsong) {
        this.yearsong = yearsong;
    }

    public Playlist getPlaylists() {
        return this.playlist;
    }

    public void setPlaylists(Playlist playlists) {
        this.playlist = playlists;
    }
    
    @Override
    public String toString() {
        return artist + " " + title;
    }
}
