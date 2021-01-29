package group.jkiakumbo.bibleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jkiakumbo.bibleAPI.model.Book;
import group.jkiakumbo.bibleAPI.repository.Books;

@Service
public class BookService {
	
	@Autowired
	private Books books;
	
	public List<Book> getAllBooks(){
		return books.findAll();
	}
	
	public Book getBookById(Long id) {
		return books.getOne(id);
	}
	
	public Book getBookByName(String name) {
		return books.findByName(name);
	}
	
	public void saveBook(Book book) {
		books.save(book);
	}
	
	public void deleteBook(Book book) {
		books.delete(book);
	}
	
	public void deleteBookById(Long id) {
		books.deleteById(id);
	}

}
