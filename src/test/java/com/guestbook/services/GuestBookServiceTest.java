package com.guestbook.services;

import com.guestbook.models.CommentRequest;
import com.guestbook.repositories.GuestBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GuestBookServiceTest {

    @Mock
    private GuestBookRepository repositoryMock;


    @Test
    public void shouldCallGuestBookRepositorySave() {
        GuestBookService service = new GuestBookService(repositoryMock);
        CommentRequest commentRequest = new CommentRequest("name", "comment");

        service.save(commentRequest);

        verify(repositoryMock, times(1)).save(anyString(), anyString());
    }

    @Test
    public void shouldCallGuestBookRepositoryGet() {
        GuestBookService service = new GuestBookService(repositoryMock);

        service.get();

        verify(repositoryMock, times(1)).get();
    }

    @Test
    public void name() {
        assertTrue(true);
    }
}