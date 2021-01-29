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

import group.jkiakumbo.bibleAPI.model.Bible;
import group.jkiakumbo.bibleAPI.service.BibleService;

@RestController
@RequestMapping("bibles")
public class BibleResource {
	
	@Autowired
	private BibleService bibleService;
	
	@GetMapping
	public List<Bible> getAllBibles(){
		return bibleService.getAllBibles();
	}
	
	@GetMapping("/{id}")
	public Bible getBibleById(@PathVariable Long id) {
		return bibleService.getBibleById(id);
	}
	
	@GetMapping(params = "language-code")
	public Bible getBibleByLanguageCode(@RequestParam("language-code") String languageCode) {
		return bibleService.getBibleByLanguageCode(languageCode);
	}
	
	@GetMapping(params = "version")
	public Bible getBibleByVersion(String version) {
		return bibleService.getBibleByVersion(version);
	}
	
	@PostMapping
	public void saveBible(Bible bible) {
		bibleService.saveBible(bible);
	}
	
	@PutMapping
	public void updateBilble(Bible bible) {
		bibleService.saveBible(bible);
	}
	
	@DeleteMapping
	public void deleteBible(Bible bible) {
		bibleService.deleteBible(bible);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBibleBy(@PathVariable Long id) {
		bibleService.deleteBibleBy(id);
	}

}
