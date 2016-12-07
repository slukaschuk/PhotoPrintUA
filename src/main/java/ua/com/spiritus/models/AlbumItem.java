package ua.com.spiritus.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;


@Entity
@Table(name = "albumitem")
public class AlbumItem implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "albumitemid")
    private Integer albumItemId;
    @Column(name = "caption")
    private String caption;
    @Column(name = "itemdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDate;
    @Column(name = "image")
    private byte[] image;

    /*@ManyToOne
    @JoinColumn(name = "albumid", nullable = false)
    private Album album;*/

    public AlbumItem() {
    }

    public AlbumItem(String caption, Date itemDate, byte[] image, Album album) {
        this.caption    = caption;
        this.itemDate   = itemDate;
        this.image      = image;
        //this.album      = album;
    }

    public Integer getAlbumItemId() {
        return albumItemId;
    }

    public void setAlbumItemId(Integer albumItemId) {
        this.albumItemId = albumItemId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

   /* public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumItem albumItem = (AlbumItem) o;

        if (!albumItemId.equals(albumItem.albumItemId)) return false;
        if (caption != null ? !caption.equals(albumItem.caption) : albumItem.caption != null) return false;
        if (!itemDate.equals(albumItem.itemDate)) return false;
        return Arrays.equals(image, albumItem.image);

    }

    @Override
    public int hashCode() {
        int result = albumItemId.hashCode();
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        result = 31 * result + itemDate.hashCode();
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "AlbumItem{" +
                "caption='" + caption + '\'' +
                //", album=" + album +
                ", itemDate=" + itemDate +
                '}';
    }
}
