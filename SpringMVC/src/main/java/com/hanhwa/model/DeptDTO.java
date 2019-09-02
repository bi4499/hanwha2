package com.hanhwa.model;

import org.springframework.web.multipart.MultipartFile;

//DTO(Data Transfer Object)
//VO(Value Object)
//JAVA Beans 湲곗닠 : default �깮�꽦�옄, getter/setter留� �엳�쑝硫� 媛��뒫
// jsp�븞�뿉�꽌 JAVA Beans 湲곗닠�쓣 �궗�슜
public class DeptDTO {
	private int department_id;
	private String department_name;
	MultipartFile uploadfile;
	String fileName;
	
	
	
	public DeptDTO() {
		
	}
	
	public DeptDTO(int department_id, String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("부서번호....DeptDTO [department_id=").append(department_id).append(", department_name=")
				.append(department_name).append("]");
		return builder.toString();
	}
	
	
	
	
}
