package ua.com.spiritus.models;

import javax.persistence.*;

//@Entity
//@Table(name = "album")
public class Album {
  /*  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "albumid")
    private Integer albumId;
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (!albumId.equals(album.albumId)) return false;
        if (!title.equals(album.title)) return false;
        return user.equals(album.user);

    }

    @Override
    public int hashCode() {
        int result = albumId.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", user=" + user +
                '}';
    }*/
}
