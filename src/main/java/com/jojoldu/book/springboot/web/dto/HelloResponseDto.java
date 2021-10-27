package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언한 모든 필드의 get 메소드를 생성해줍ㄴ니다.
@RequiredArgsConstructor // 선언된 모든ㄴ final 필드가 포함된 생성자 생성해줌(final 없으면 포함X)
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
