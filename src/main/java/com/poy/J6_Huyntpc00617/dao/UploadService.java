package com.poy.J6_Huyntpc00617.dao;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;

public interface UploadService {
	File save(MultipartFile file, String folder);
}
