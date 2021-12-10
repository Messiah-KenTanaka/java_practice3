package to.msn.wings.quickmaster.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
	// 主キー
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// ISBNコード
	@Column(name = "isbn", nullable = false)
	private String isbn;
	// 書名
	@Column(name = "title", nullable = true)
	private String title;
	// 価格
	@Column(name = "price", nullable = false)
	private int price;
	// 出版社
	@Column(name = "publisher", nullable = false)
	private String publisher;
	// 刊行日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "published", nullable = false)
	private LocalDate published;
	// 付属品
	@Column(name = "attach", nullable = true)
	private String attach;

	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	private Collection<Review> reviews;
}
