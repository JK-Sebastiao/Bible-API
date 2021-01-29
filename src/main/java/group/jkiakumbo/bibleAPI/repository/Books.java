package group.jkiakumbo.bibleAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.jkiakumbo.bibleAPI.model.Book;

@Repository
public interface Books extends JpaRepository<Book, Long> {
	public Book findByName(String name);
}
