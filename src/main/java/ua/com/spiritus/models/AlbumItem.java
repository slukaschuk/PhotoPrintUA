package ua.com.spiritus.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "albumitem")
@Getter
@Setter
public class AlbumItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "album_item_id")
    private Integer albumItemId;
    @Column(name = "caption", length = 100)
    private String caption;
    @Column(name = "item_date")
    private LocalDateTime itemDate;
    @Column(name = "image")
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
