package com.guestbook.repositories;

import com.guestbook.models.GuestBook;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GuestBookRepositoryTest {

    @Test
    public void shouldIncreaseSizeAndId() {
        GuestBookRepository guestBookRepository = new GuestBookRepository();
        Integer savedId = guestBookRepository.save("faizal", "comment");

        assertEquals((Integer) 1, savedId);
        assertEquals(1, guestBookRepository.guestBookList.size());
    }

    @Test
    public void shouldGetAllDataFromList() {
        GuestBookRepository guestBookRepository = new GuestBookRepository();
        Integer savedId = guestBookRepository.save("faizal", "comment");

        List<GuestBook> guestBookList = guestBookRepository.get();

        assertEquals(1, guestBookList.size());
        assertEquals("faizal", guestBookList.get(0).getName());
        assertEquals("comment", guestBookList.get(0).getComment());
    }

    @Test
    public void shouldGetSingleDataFromList() {
        GuestBookRepository guestBookRepository = new GuestBookRepository();
        guestBookRepository.save("data_id_1", "comment");
        guestBookRepository.save("data_id_2", "comment");

        GuestBook guestBook;

        guestBook = guestBookRepository.get(1);
        assertEquals("data_id_1", guestBook.getName());

        guestBook = guestBookRepository.get(2);
        assertEquals("data_id_2", guestBook.getName());
    }

    @Test
    public void shouldReturnNullIfDataIsNotFound() {
        GuestBookRepository guestBookRepository = new GuestBookRepository();

        GuestBook guestBook;

        guestBook = guestBookRepository.get(1);
        assertNull(guestBook);

    }

}
