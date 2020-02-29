package org.zerock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.VO.AttachFileVO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;


@Controller
@Log4j
public class UploadController {
	final static String UPLOAD_FOLDER = "D:\\upload";
	final static String DOWNLOAD_FOLDER = "D:\\download";
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload Form");
	}
	
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile) {
		
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-------------------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload file Size : " + multipartFile.getSize());
			
			
			File saveFile = new File(UPLOAD_FOLDER, saveFile(multipartFile));
			
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		
		
	}
	
	
	
	//Using Ajax
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	@PostMapping(value = "/uploadAjaxAction", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileVO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		
		List<AttachFileVO> list = new ArrayList<>();
		
		String uploadFolderPath = getFolder();
		
		File uploadPath = new File(UPLOAD_FOLDER, uploadFolderPath);
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("-------------------------------");
			log.info("upload File Name : " + multipartFile.getOriginalFilename());
			log.info("Upload file Size : " + multipartFile.getSize());
			
			
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			UUID uuid = UUID.randomUUID();
			AttachFileVO attachVO = new AttachFileVO();
			
			attachVO.setFileName(uploadFileName);
			
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);
				
				attachVO.setUuid(uuid.toString());
				attachVO.setUploadPath(uploadFolderPath);
				
				if(checkImageType(saveFile)) {
					attachVO.setImage(true);
					
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
				
				list.add(attachVO);
				
			}catch(Exception e) {
				log.error(e.getMessage());
			}
		}
		
		
		return new ResponseEntity<>(list, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		
		log.info("file Name" + fileName);
		
		File file = new File(UPLOAD_FOLDER+"\\"+fileName);
		
		log.info(file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent")String userAgent, String fileName){
		log.info("download file : " + fileName);
		
		Resource resource = new FileSystemResource(UPLOAD_FOLDER +"\\" +  fileName);
		
		
		if(resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		log.info("resource : " + resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			
			String downloadName = null;
			 String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
			
			if(userAgent.contains("Trident")) {
				log.info("IE Browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			}
			else if(userAgent.contains("Edge")) {
				log.info("Edge Browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			}
			else {
				log.info("Chrome Borwser");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"),"ISO-8859-1");
			}
			
			
			
			headers.add("Content-Disposition","attachment; filename=" + downloadName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		log.info("deleteFile : " + fileName);
		
		File file;
		
		try {
			file = new File(UPLOAD_FOLDER + "\\" + URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			
			if(type.equals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName : " + largeFileName);
				
				file = new File(largeFileName);
				file.delete();
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	//Method


	private String saveFile(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String saveName = uuid + "_" + file.getOriginalFilename();
		log.info(saveName);
		return saveName;
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
	
	//이미지인지 아닌지 검사
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	
}
