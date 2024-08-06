package com.example.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Images;
import com.example.repository.ImagesRepository;

@Service
public class ImageService {

	@Autowired
	private ImagesRepository  imagerepo;
	
	
	public Images savetheimagetodb( MultipartFile  file) throws IOException {
			Images image1 =  new Images(file.getName(), file.getContentType(), file.getBytes());
		return   imagerepo.save(image1);
	}
	
	public Optional<Images> gettheimagebyid(Integer id ){
		Optional<Images> img   =  imagerepo.findById(id);
		return  img ;
	}
	
	
}
