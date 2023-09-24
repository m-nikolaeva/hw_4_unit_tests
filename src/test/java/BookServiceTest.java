import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.gb.book.Book;
import ru.gb.book.BookRepository;
import ru.gb.book.BookService;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class BookServiceTest {

    private BookRepository mockBook;
    BookService bookService;

    @BeforeEach
    void setUp(){
        mockBook = Mockito.spy(BookRepository.class);
        bookService = new BookService(mockBook);
    }

    @Test
    public void  findByBookIdTest() {
        String nameId = "15";
        Book newBook = new Book(nameId, "book15","author15");

        when(mockBook.findById(nameId)).thenReturn(newBook);

        Book result = bookService.findBookById(nameId);

        assertEquals(newBook,result);
    }

    @Test
    public void  findAllBookIdTest() {
        List<Book> mockBook1 = new ArrayList<>();
        mockBook1.add(new Book("15", "book55","author15"));
        mockBook1.add(new Book("25", "book25","author25"));
        mockBook1.add(new Book("25", "book21","author25"));

        when(mockBook.findAll()).thenReturn(mockBook1);

        List<Book> result = bookService.findAllBooks();

        assertEquals(mockBook1,result);
    }
}