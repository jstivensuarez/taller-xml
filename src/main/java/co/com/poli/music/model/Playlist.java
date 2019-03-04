package co.com.poli.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="playlists")
public class Playlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String description;

	@NotEmpty
	private String name;

	@JsonBackReference
	//bi-directional many-to-one association to Song
	@ManyToOne(fetch = FetchType.LAZY)
	private Song song;

	public Playlist() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Song getSong() {
		return this.song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

}