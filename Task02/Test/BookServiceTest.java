/*Задание 2:
У вас есть класс BookService, который использует интерфейс BookRepository для
получения информации о книгах из базы данных. Ваша задача написать unit-тесты
для BookService, используя Mockito для создания мок-объекта BookRepository.
*/

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void findBookById() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        Book myBook = new Book("1","Book1","Author1");

        when(bookService.findBookById("1")).thenReturn(myBook);

        assertEquals(myBook, bookService.findBookById("1"));
    }

    @Test
    void callFindBookById() {
        BookService bookServiceMock = mock(BookService.class);

        bookServiceMock.findBookById("1");

        verify(bookServiceMock, times(1)).findBookById("1");
    }

    @Test
    void findAllBooks() {
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        List<Book> myListBook = new ArrayList<>();
        myListBook.add(new Book("1","Book1","Author1"));
        myListBook.add(new Book("2","Book2","Author2"));

        when(bookService.findAllBooks()).thenReturn(myListBook);

        assertEquals(myListBook, bookService.findAllBooks());
    }

    @Test
    void callFindAllBooks() {
        BookService bookServiceMock = mock(BookService.class);

        bookServiceMock.findAllBooks();

        verify(bookServiceMock, times(1)).findAllBooks();
    }
}