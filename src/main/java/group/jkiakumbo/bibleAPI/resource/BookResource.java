package group.jkiakumbo.bibleAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.jkiakumbo.bibleAPI.model.Book;
import group.jkiakumbo.bibleAPI.service.BookService;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
	@GetMapping(params = "name")
	public Book getBookByName(String name) {
		return bookService.getBookByName(name);
	}
	
	
	@PostMapping
	public void saveBook(Book book) {
		bookService.saveBook(book);
	}
	
	@PutMapping
	public void updateBook(Book book) {
		bookService.saveBook(book);
	}
	
	@DeleteMapping
	public void deleteBook(Book book) {
		bookService.deleteBook(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookById(Long id) {
		bookService.deleteBookById(id);
	}

}
