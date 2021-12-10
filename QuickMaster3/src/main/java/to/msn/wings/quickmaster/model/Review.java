package to.msn.wings.quickmaster.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {
	// 主キー
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// レビュアー名
	@Column(name = "name", nullable = false)
	private String name;
	// レビュー本文
	@Column(name = "body", nullable = false)
	private String body;
	// 紐付く書籍（外部キー）
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
}
