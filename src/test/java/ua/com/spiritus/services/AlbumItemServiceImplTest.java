package ua.com.spiritus.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.com.spiritus.models.AlbumItem;
import ua.com.spiritus.models.User;
import ua.com.spiritus.repositories.AlbumItemRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AlbumItemServiceImplTest {

    @InjectMocks
    private AlbumItemServiceImpl sut;
    @Mock
    private AlbumItemRepository albumItemRepository;
    @Mock
    private UserService userService;

    @Test
    public void shouldSavePhotoForUser() {
        // given
        when(userService.findById(any())).thenReturn(new User());

        AlbumItem albumItem = new AlbumItem();

        // when
        boolean saved = sut.savePhotoForUser(1, albumItem);

        // then
        verify(albumItemRepository).save(eq(albumItem));
        assertThat(saved, is(true));

            }

    @Test
    public void shouldNotSavePhotoForUnknownUser() {
        // given
        when(userService.findById(any())).thenReturn(null);

        AlbumItem albumItem = new AlbumItem();

        // when
        boolean saved = sut.savePhotoForUser(1, albumItem);

        // then
        verify(albumItemRepository, times(0)).save(eq(albumItem));
        verifyZeroInteractions(albumItemRepository);
        assertThat(saved, is(false));

    }
}
