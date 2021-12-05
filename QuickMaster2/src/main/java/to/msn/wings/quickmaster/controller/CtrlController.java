package to.msn.wings.quickmaster.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import to.msn.wings.quickmaster.form.MemberForm;

@Controller
public class CtrlController {

	@GetMapping("/form")
	public String form(@ModelAttribute MemberForm memberForm, Model model) {
		model.addAttribute("main", "ctrl/form::main");
		return "common/layout";
	}

	@PostMapping("/ctrl/form")
	public String form_result(@ModelAttribute MemberForm memberForm, Model model) {
		model.addAttribute("main", "ctrl/form_result::main");
		return "common/layout";
	}

	@GetMapping("/upload")
	public String upload(Model model) {
		model.addAttribute("main", "ctrl/upload::main");
		return "common/layout";
	}

	@PostMapping("/ctrl/upload")
	public String upload(Model model, @RequestParam("upfile") MultipartFile file) {
		String name = file.getOriginalFilename();
		// 指定ファイルに保存
		try (BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream("./" + name))) {
			bof.write(file.getBytes());
			model.addAttribute("success", name + "のアップロードに成功しました");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// フォームを再描画
		model.addAttribute("main", "ctrl/upload::main");
		return "common/layout";
	}
}
