package com.demo.controllers;

import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyDemoController3 {
	
	@RequestMapping(value="/myform")
	public String myForm() {
		
		return "myForm";
	}
	
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file) {
		
		try{
			if(!file.isEmpty()) {
				byte[] bytes=file.getBytes();
				FileOutputStream fos = new FileOutputStream("c:\\Users\\myFile.jpg");
				fos.write(bytes);
				fos.close();
				System.out.println("file saved successfully");
			}
			else {
				System.out.println("no files available to save");
			}
				
		}
		catch(Exception e){
			System.out.println("error saving file.");
		}
		return "operationComplete";
	}

}
