package com.icia.lib.Service;

import com.icia.lib.DTO.BookDTO;
import com.icia.lib.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAll() {
        List<BookDTO> bookDTOList = bookRepository.findAll();
        if(bookDTOList.size()== 0){
            return null;
        }else{
            return bookDTOList;
        }
    }

    public int save(BookDTO bookDTO){
        System.out.println("bookDTO = " + bookDTO);
        int result = bookRepository.save(bookDTO);
        return result;
    }
    public BookDTO findById(Long id){
        BookDTO bookDTO = bookRepository.findById(id);
        return bookDTO;
        // return bookRepository.findById(id); 로 한줄로 쓸 수 있다.
    }

    public void update(BookDTO bookDTO) {
        bookRepository.update(bookDTO);
    }
    public void delete(Long id) {
        bookRepository.delete(id);
    }
}
