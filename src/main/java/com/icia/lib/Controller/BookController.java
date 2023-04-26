package com.icia.lib.Controller;

import com.icia.lib.DTO.BookDTO;
import com.icia.lib.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class BookController {
  // BookService 의존성 주입(필드 주입)
  @Autowired
  private BookService bookService;
    // 도서 등록 화면 : 화면 출력이 목적
  @GetMapping("/save")
    public String saveForm(){
      return "save";
  }
  // 도서 등록 처리 : 도서 등록이 목적
  @PostMapping("/save")
    public String save(@ModelAttribute BookDTO bookDTO, Model model){
    System.out.println("bookDTO = " + bookDTO);
    int saveResult=bookService.save(bookDTO);
    model.addAttribute("result", saveResult);
    return "saveResult";

  }
  @GetMapping("/list")
  public String findAll(Model model){
    List<BookDTO> bookDTOList = bookService.findAll();

    for(BookDTO bookDTO: bookDTOList){
      System.out.println("bookDTO = " + bookDTO);
    }
    model.addAttribute("bookList", bookDTOList);
    return "list";
  }
  @GetMapping("/detail")
  public String findById(@RequestParam("id") Long id, Model model){
    //Long id와 Model model을 쓰는 이유는 ID값을 뽑고 이를 객체 단위로 화면에 보여줘야 하기 때문.
    BookDTO bookDTO = bookService.findById(id);
    // List만 쓰거나 DTO만 쓰는게 답이 아니다. 상황에 맞춰서 써야함.
    model.addAttribute("book",bookDTO);
    return "detail";
  }
  //수정화면 출력
  @GetMapping("/update")
  public String updateForm(@RequestParam("id") Long id, Model model) {
    BookDTO bookDTO = bookService.findById(id);
    model.addAttribute("book", bookDTO);
    return "update";
    // 어차피 아이디를 찾긴 해야하므로 따로 만들 필요 없이 findById를 쓴다.
  }

  //수정처리
  @PostMapping("/update")
  public String update(@ModelAttribute BookDTO bookDTO) {
    bookService.update(bookDTO);
    // 수정이 완료되면 수정된 상세페이지를 다시 출력
    // 곧바로 다시 출력하는게 아니라 상세페이지가 있는 주소를 다시 요청해야함.
    // 그런데 우리는 단순하게 다시 요청할 수 없음("detail"을 쓸 수 없다).
    // 이때, redirect를 요청함 : 다른 컨트롤러 메소드의 주소를 요청(jsp 페이지 이름을 리턴하는 것이 아님)
    // 간간이 redirect를 사용하긴함.
    return "redirect:/detail?id="+bookDTO.getId();
  }
  //삭제 처리
  @GetMapping("/delete")
  public String delete(@RequestParam("id") Long id){
    bookService.delete(id);
    // 삭제 처리 후 목록 출력
    // 다른 메소드의 주소를 요청할 필요가 있다면 redirect를 써야한다.
    // redirect가 붙으면 주소 값을 다시 부른다.
    // 다른 컨트롤러에 지정한 주소를 요청하는 것.
    return "redirect:/list";
  } // 어노테이션 / 주소와 jsp의 차이점. 모든 요청은 주소를 기준으로 함.
}
