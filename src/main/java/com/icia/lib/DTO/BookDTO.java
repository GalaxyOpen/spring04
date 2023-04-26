package com.icia.lib.DTO;

import lombok.*;

@Getter
@Setter
@ToString
public class BookDTO {
    private Long id;
    private String bookName;
    private String bookPublisher;
    private String bookAuthor;
    private int bookPrice;
}
