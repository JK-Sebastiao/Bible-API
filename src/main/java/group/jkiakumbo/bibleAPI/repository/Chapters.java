package group.jkiakumbo.bibleAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.jkiakumbo.bibleAPI.model.Book;
import group.jkiakumbo.bibleAPI.model.Chapter;

@Repository
public interface Chapters extends JpaRepository<Chapter, Long>{
	public Chapter findByNumberAndBook(Integer number, Book book);
	public List<Chapter> findByNumber(Integer number);
	public List<Chapter> findByBook(Book book);
}
