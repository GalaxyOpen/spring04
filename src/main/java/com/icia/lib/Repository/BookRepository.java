package com.icia.lib.Repository;

import com.icia.lib.DTO.BookDTO;
import org.mybatis.spring.SqlSessionTemplate; // CRUD 관련 메소드를 씀.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public List<BookDTO> findAll() {
        return sql.selectList("Book.findAll");
    }

    public int save(BookDTO bookDTO) {
        /* insert : 수행 결과를 int 값으로 리턴. insert 수행이 되지 않았으면 0, 됐으면 1*/
       return sql.insert("Book.save", bookDTO);
        // 1번째는 mapper 호출, 2번째는 실제 쿼리에 적용할 값(객체가 올수도 변수가 올수도 오지 않을수도 있음).

    }
    public BookDTO findById(Long id) {

        return sql.selectOne("Book.findById", id);
    }    // 먼저 DB에서 쿼리문을 어떻게 쓸지 연습해보고 mapper에 쓰는게 좋다.

    public void update(BookDTO bookDTO) {
        sql.update("Book.update", bookDTO);
    }


    public void delete(Long id) {
        sql.delete("Book.delete", id);
    }
}
