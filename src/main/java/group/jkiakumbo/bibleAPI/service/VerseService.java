package group.jkiakumbo.bibleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jkiakumbo.bibleAPI.model.Book;
import group.jkiakumbo.bibleAPI.model.Chapter;
import group.jkiakumbo.bibleAPI.model.Verse;
import group.jkiakumbo.bibleAPI.repository.Books;
import group.jkiakumbo.bibleAPI.repository.Chapters;
import group.jkiakumbo.bibleAPI.repository.Verses;

@Service
public class VerseService {
	
	@Autowired
	private Verses verses;
	
	@Autowired
	private Chapters chapters;
	
	@Autowired
	private Books books;
	
	public List<Verse> getAllVerses(){
		return verses.findAll();
	}
	
	public Verse getVerseById(Long id) {
		return verses.getOne(id);
	}
	
	public Verse getVerseByNumberAndChapter(Integer number, Chapter chapter) {
		return verses.findByNumberAndChapter(number, chapter);
	}
	
	public Verse getVerseByNumberAndChapterNumberAndBookName(Integer number, Integer chapterNumber, String bookName) {
		Book book = books.findByName(bookName);
		Chapter chapter = chapters.findByNumberAndBook(chapterNumber, book);
		return getVerseByNumberAndChapter(number, chapter);
	}
	
	public List<Verse> getVersesByChapter(Chapter chapter){
		return verses.findByChapter(chapter);
	}
	
	public List<Verse> getVersesByChapterNumberAndBookName(Integer chapterNumber, String bookName) {
		Book book = books.findByName(bookName);
		Chapter chapter = chapters.findByNumberAndBook(chapterNumber, book);
		return getVersesByChapter(chapter);
	}
	
	public void saveVerse(Verse verse) {
		verses.save(verse);
	}
	
	public void updateVerse(Verse verse) {
		verses.save(verse);
	}
	
	public void deleteVerse(Verse verse) {
		verses.delete(verse);
	}
	
	public void deleteVerseById(Long id) {
		verses.deleteById(id);
	}

	

	
}
