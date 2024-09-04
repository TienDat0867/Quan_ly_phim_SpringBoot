package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poly.entity.khachhang;
import com.poly.entityDTO.khachhangDTO;

@Service
public class khachhangMapper {
	@Autowired
	private ModelMapper modelMapper;
	public khachhang convertToEntity(khachhangDTO khachhangDTO) 
	{
		khachhang khachhang= modelMapper.map(khachhangDTO, khachhang.class);
		return khachhang;
	}
	public khachhangDTO convertToDTO(khachhang khachhang) {
		khachhangDTO khachhangDTO= modelMapper.map(khachhang, khachhangDTO.class);
		return khachhangDTO;
	}
}
