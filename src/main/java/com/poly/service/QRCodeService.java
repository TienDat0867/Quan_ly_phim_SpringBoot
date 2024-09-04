package com.poly.service;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.WriterException;

@Service
public interface QRCodeService {
	public File sendQR(@RequestParam String text) throws WriterException, IOException;
}
