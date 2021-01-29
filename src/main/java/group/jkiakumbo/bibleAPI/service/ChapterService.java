package group.jkiakumbo.bibleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jkiakumbo.bibleAPI.model.Book;
import group.jkiakumbo.bibleAPI.model.Chapter;
import group.jkiakumbo.bibleAPI.repository.Books;
import group.jkiakumbo.bibleAPI.repository.Chapters;

@Service
public class ChapterService {
	
	@Autowired
	private Chapters chapters;
	
	@Autowired
	private Books books;
	
	public List<Chapter> getAllChapters(){
		return chapters.findAll();
	}
	
	public Chapter getChapterById(Long id) {
		return chapters.getOne(id);
	}
	
	public Chapter getChapterByNumberAndBook(Integer number, Book book) {
		return chapters.findByNumberAndBook(number, book);
	}
	
	public Chapter getChapterByNumberAndBookName(Integer number, String bookName) {
		Book book = books.findByName(bookName);
		return getChapterByNumberAndBook(number, book);
	}
	
	public List<Chapter> getChaptersByNumber(Integer number){
		return chapters.findByNumber(number);
	}
	
	public List<Chapter> getChaptersByBook(Book book){
		return chapters.findByBook(book);
	}
	
	public List<Chapter> getChaptersByBookName(String bookName){
		Book book = books.findByName(bookName);
		return chapters.findByBook(book);
	}
	
	public void saveChapter(Chapter chapter) {
		chapters.save(chapter);
	}
	
	public void deleteChapter(Chapter chapter) {
		chapters.delete(chapter);
	}
	
	public void deleteChapterbyId(Long id) {
		chapters.deleteById(id);
	}

	
}
