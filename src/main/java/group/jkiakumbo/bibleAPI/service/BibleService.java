package group.jkiakumbo.bibleAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.jkiakumbo.bibleAPI.model.Bible;
import group.jkiakumbo.bibleAPI.repository.Bibles;

@Service
public class BibleService {
	
	@Autowired
	private Bibles bibles;
	
	public List<Bible> getAllBibles(){
		return bibles.findAll();
	}
	
	public Bible getBibleById(Long id) {
		return bibles.getOne(id);
	}
	
	public Bible getBibleByLanguageCode(String languageCode) {
		return bibles.findByLanguageCode(languageCode);
	}
	
	public Bible getBibleByVersion(String version) {
		return bibles.findByVersion(version);
	}
	
	public void saveBible(Bible bible) {
		bibles.save(bible);
	}
	
	public void deleteBible(Bible bible) {
		bibles.delete(bible);
	}
	
	public void deleteBibleBy(Long id) {
		bibles.deleteById(id);
	}

}
