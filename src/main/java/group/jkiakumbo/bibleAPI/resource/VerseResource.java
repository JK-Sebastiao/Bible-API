package group.jkiakumbo.bibleAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.jkiakumbo.bibleAPI.model.Verse;
import group.jkiakumbo.bibleAPI.service.VerseService;

@RestController
@RequestMapping("/verses")
public class VerseResource {
	
	@Autowired
	private VerseService verseService;
	
	@GetMapping
	public List<Verse> getAllVerses(){
		return verseService.getAllVerses();
	}
	
	@GetMapping("{id}")
	public Verse getVerseById(@PathVariable Long id) {
		return verseService.getVerseById(id);
	}
	
	@GetMapping(params = {"number", "chapter", "book-name"})
	public Verse getVerseByNumberAndChapterNumberAndBookName(Integer number, @RequestParam("chapter") Integer chapterNumber, 
			@RequestParam("book-name") String bookName) {
		return verseService.getVerseByNumberAndChapterNumberAndBookName(number, chapterNumber, bookName);
	}
	
	@GetMapping(params = {"chapter", "book-name"})
	public List<Verse> getVersesByChapterNumberAndBookName (@RequestParam("chapter") Integer chapterNumber, 
			@RequestParam("book-name") String bookName){
		return verseService.getVersesByChapterNumberAndBookName(chapterNumber, bookName);
	}
	
	@PostMapping
	public void saveVerse(Verse verse) {
		verseService.saveVerse(verse);
	}
	
	@PutMapping
	public void updateVerse(Verse verse) {
		verseService.saveVerse(verse);
	}
	
	@DeleteMapping
	public void deleteVerse(Verse verse) {
		verseService.deleteVerse(verse);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVerseById(@PathVariable Long id) {
		verseService.deleteVerseById(id);
	}
}
