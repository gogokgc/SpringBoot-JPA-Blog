package com.kgc.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> { // < >제네릭 DTO 계층간 데이터교환을 위한 객체, DB에서 데이터를 얻어 Service 나 Controller 등으로 보낼때 사용.

	int status;
	T data;
}
