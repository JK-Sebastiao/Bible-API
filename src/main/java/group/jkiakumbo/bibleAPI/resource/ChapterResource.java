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

import group.jkiakumbo.bibleAPI.model.Chapter;
import group.jkiakumbo.bibleAPI.service.ChapterService;

@RestController
@RequestMapping("/chapters")
public class ChapterResource {
	
	@Autowired
	private ChapterService chapterService;
	
	@GetMapping
	public List<Chapter> getAllChapters(){
		return chapterService.getAllChapters();
	}
	
	@GetMapping("/{id")
	public Chapter getChapterById(@PathVariable Long id) {
		return chapterService.getChapterById(id);
	}
	
	@GetMapping(params = {"number", "book-name"})
	public Chapter getChapterByNumberAndBook(Integer number, @RequestParam("book-name") String bookName) {
		return chapterService.getChapterByNumberAndBookName(number, bookName);
	}
	
	@GetMapping(params = "number")
	public List<Chapter> getChaptersByNumber(Integer number){
		return chapterService.getChaptersByNumber(number);
	}
	
	@GetMapping(params = "book-name")
	public List<Chapter> getChaptersByBookName(@RequestParam("book-name") String bookName){
		return chapterService.getChaptersByBookName(bookName);
	}
	
	@PostMapping
	public void saveChapter(Chapter chapter) {
		chapterService.saveChapter(chapter);
	}
	
	@PutMapping
	public void updateChapter(Chapter chapter) {
		chapterService.saveChapter(chapter);
	}
	
	@DeleteMapping
	public void deleteChapter(Chapter chapter) {
		chapterService.deleteChapter(chapter);
	}
	
	@DeleteMapping("/{id}")
	public void deleteChapterbyId(Long id) {
		chapterService.deleteChapterbyId(id);
	}

}
