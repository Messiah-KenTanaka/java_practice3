package to.msn.wings.quickmaster.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import to.msn.wings.quickmaster.model.Book;
import to.msn.wings.quickmaster.model.BookTitleOnly;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	Collection<Book> findByPublisher(String publisher);

	Collection<Book> findByTitleLike(String title);

	Collection<Book> findByTitleContaining(String title);

	Collection<Book> findByPublisherIn(Collection<String> publisher);

	Collection<BookTitleOnly> findByPublisherOrderByPrice(String publisher);

	Page<Book> findByPublisher(String publisher, Pageable pageable);

	@Override
	Page<Book> findAll(Pageable pageable);
}
