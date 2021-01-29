package group.jkiakumbo.bibleAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.jkiakumbo.bibleAPI.model.Bible;

@Repository
public interface Bibles extends JpaRepository<Bible, Long>  {
	
	public Bible findByLanguageCode(String code);
	public Bible findByVersion(String version);

}
