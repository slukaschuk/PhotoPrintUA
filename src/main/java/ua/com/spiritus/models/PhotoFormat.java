package ua.com.spiritus.models;

import javax.persistence.*;

@Entity
@Table(name = "photoformat")
public class PhotoFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photoformatid")
    private Integer photoFormatId;
    @Column(name = "format")
    String format;

    public PhotoFormat() {
    }

    public PhotoFormat(String format) {
        this.format = format;
    }

    public Integer getPhotoFormatId() {
        return photoFormatId;
    }

    public void setPhotoFormatId(Integer photoFormatId) {
        this.photoFormatId = photoFormatId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoFormat that = (PhotoFormat) o;

        if (!photoFormatId.equals(that.photoFormatId)) return false;
        return format.equals(that.format);

    }

    @Override
    public int hashCode() {
        int result = photoFormatId.hashCode();
        result = 31 * result + format.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PhotoFormat{" +
                "format='" + format + '\'' +
                '}';
    }
}
