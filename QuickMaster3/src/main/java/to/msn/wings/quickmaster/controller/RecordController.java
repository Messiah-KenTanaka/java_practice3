package to.msn.wings.quickmaster.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import to.msn.wings.quickmaster.model.Book;
import to.msn.wings.quickmaster.repository.BookRepository;

@RequiredArgsConstructor
@RequestMapping("/record")
@Controller
public class RecordController {

	private final BookRepository rep;

	@GetMapping("/find/{id}")
	public String find(@PathVariable int id, Model model) {
		// idで書籍情報を検索
		model.addAttribute("book", rep.findById(id));
		model.addAttribute("main", "record/find::main");
		return "common/layout";
	}

	@GetMapping("/findby")
	public String findby(Model model) {
		model.addAttribute("books", rep.findByPublisher("翔泳社"));
		model.addAttribute("main", "record/list::main");
		return "common/layout";
	}

	@GetMapping("/findbytitle")
	public String findbytitle(Model model) {
//		model.addAttribute("books", rep.findByTitleLike("%入門%"));
		model.addAttribute("books", rep.findByTitleContaining("入門"));
		model.addAttribute("main", "record/list::main");
		return "common/layout";
	}

	@GetMapping("/findbyin")
	public String findbyin(Model model) {
		model.addAttribute("books", rep.findByPublisherIn(List.of("翔泳社", "日経BP")));
		model.addAttribute("main", "record/list::main");
		return "common/layout";
	}

	@GetMapping("/findby2")
	public String findby2(Model model) {
		model.addAttribute("books", rep.findByPublisherOrderByPrice("翔泳社"));
		model.addAttribute("main", "record/minilist::main");
		return "common/layout";
	}

	@GetMapping("/paging")
	public String paging(Model model, @PageableDefault(page = 0, size = 1, sort = { "isbn" }) Pageable pageable) {
		Page<Book> page = rep.findByPublisher("翔泳社", pageable);
		model.addAttribute("page", page);
		model.addAttribute("main", "record/paging::main");
		return "common/layout";
	}

	@GetMapping("/pagingfindall")
	public String pagingfindall(Model model,
			@PageableDefault(page = 0, size = 3, sort = { "isbn" }) Pageable pageable) {
		Page<Book> page = rep.findAll(pageable);
		model.addAttribute("page", page);
		model.addAttribute("main", "record/paging::main");
		return "common/layout";
	}

	@GetMapping("/findbyprice")
	public String findbyprice(Model model) {
		model.addAttribute("books", rep.findByPrice(3000));
		model.addAttribute("main", "record/list::main");
		return "common/layout";
	}

	@GetMapping("/group")
	public String group(Model model) {
		model.addAttribute("books", rep.groupByPublisher());
		model.addAttribute("main", "record/glist::main");
		return "common/layout";
	}
}
