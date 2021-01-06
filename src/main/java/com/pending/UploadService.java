package com.pending;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	private Path root = Paths.get("./src/main/resources/static");

	public HttpStatus save(MultipartFile file) throws IOException {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch (FileAlreadyExistsException e) {
			System.out.println("Archivo duplicado " + e);
			return HttpStatus.CONFLICT;

		}
		return HttpStatus.CREATED;

	}
}
