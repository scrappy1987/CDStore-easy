package com.qa.cdstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CD")
public class CD {

	@Id
	@Column(nullable = false)
	
	private int id;

	@Column(nullable = false, length = 225)
	@Size(max = 225)
	@NotNull
	private String song;

	@Column(nullable = false, length = 225)
	@Size(max = 225)
	@NotNull
	private String artist;

	@Column(nullable = true, length = 225)
	@Size(max = 225)
	private String album;

	@Column(nullable = true, length = 225)
	@Size(max = 225)
	private String released;

	public CD() {

	}

	public CD(String song, String artist, String album, String released) {
		this.song = song;
		this.artist = artist;
		this.album = album;
		this.released = released;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	@Override
	public String toString() {
		return "CD [id=" + id + ", song=" + song + ", artist=" + artist
				+ ", album=" + album + ", released=" + released + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((released == null) ? 0 : released.hashCode());
		result = prime * result + ((song == null) ? 0 : song.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (id != other.id)
			return false;
		if (released == null) {
			if (other.released != null)
				return false;
		} else if (!released.equals(other.released))
			return false;
		if (song == null) {
			if (other.song != null)
				return false;
		} else if (!song.equals(other.song))
			return false;
		return true;
	}

}
