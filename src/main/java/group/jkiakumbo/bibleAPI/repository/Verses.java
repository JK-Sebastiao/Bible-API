package group.jkiakumbo.bibleAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import group.jkiakumbo.bibleAPI.model.Chapter;
import group.jkiakumbo.bibleAPI.model.Verse;

public interface Verses extends JpaRepository<Verse, Long>{
	
	public Verse findByNumberAndChapter(Integer number, Chapter chapter);
	public List<Verse> findByChapter(Chapter chapter);
}
