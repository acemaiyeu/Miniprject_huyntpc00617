package com.poy.J6_Huyntpc00617.Serviceimpl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.poy.J6_Huyntpc00617.Service.UploadService;

@Service
public class UploadServiceImpl implements UploadService{
@Autowired
ServletContext app;
@Autowired
HttpSession session;
	
//	@Override
//	public File save(MultipartFile file, String folder) {
//		System.out.println("FOlder:"+folder);
//		String s = System.currentTimeMillis() + file.getOriginalFilename();
//		String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
//		this.saveFileStatic(file, folder, name);
//		File dir = new File(app.getRealPath("/assets/" + folder));	
//		System.out.println("Name: "+name);
//		if(!dir.exists()) {
//			dir.mkdirs();
//		}
//		try {
//			File saveFile = new File(dir, name);
////			file.transferTo(saveFile);
//			System.out.println(saveFile.getAbsolutePath());
//			return saveFile;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//	}

	@Override
	public File save(MultipartFile file, String folder) {
		try {
			String s = System.currentTimeMillis() + file.getOriginalFilename();
			String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
			System.out.println("Name1: "+name);
			File files = new ClassPathResource("/static/assets/"+folder+"/").getFile();
			String path = files.toString()+"\\"+name;
			path = path.replace("\\", "//");
			System.out.println(" | "+path);
			File imageexits = new File(path);
			if(!imageexits.exists()) {
				imageexits.mkdirs();
			}
			file.transferTo(imageexits);
System.out.println(imageexits.getAbsolutePath());
			return imageexits;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
	e1.printStackTrace();
			throw new RuntimeException();
		}
	}
	
}
