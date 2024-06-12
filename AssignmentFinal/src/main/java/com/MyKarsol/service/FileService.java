package com.MyKarsol.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {

	public String uploadImage(String path,MultipartFile file);
}
