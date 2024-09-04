package com.poly.entityDTO;

import com.poly.entity.ghe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ticketDTO {
	private ghe ghe;
	private Integer soluong;
	private String soghe;
	private Integer gia;
}
