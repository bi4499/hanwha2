package com.hanhwa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanhwa.model.DeptDAO_Mybatis;
import com.hanhwa.model.DeptDTO;
import com.hanhwa.model.EmpService;
import com.hanhwa.model.EmpVO;

//bean id="myController" class="" />
@Controller
public class MyController {

	// Autowired 붙여주면 알아서 만들어서(new해서) 객체 넣어줌
	@Autowired
	DeptDAO_Mybatis dao;
	// DeptDAO dao;

	@Autowired
	EmpService service;

	@RequestMapping("/emp/emplist")
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", service.selectAll());
		mv.setViewName("emp/empAll");
		return mv;
	}

	@RequestMapping(value = "/emp/empdetail", method = RequestMethod.GET)
	public ModelAndView selectDetail(int empid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.selectById(empid));
		mv.addObject("mlist", service.selectAllManager());
		mv.addObject("joblist", service.selectAllJob());
		mv.addObject("deptlist", dao.selectAll());
		mv.setViewName("emp/empdetail");
		return mv;
	}

	@RequestMapping(value = "/emp/empdetail", method = RequestMethod.POST)
	public String empUpdate(EmpVO emp) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.updateEmp(emp));
		return "redirect:emplist";
	}

	@RequestMapping(value = "/emp/empinsert", method = RequestMethod.GET)
	public ModelAndView empInsert() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("deptlist", dao.selectAll());
		mv.addObject("mlist", service.selectAllManager());
		mv.addObject("joblist", service.selectAllJob());
		mv.setViewName("emp/empinsert");
		return mv;
	}

	@RequestMapping(value = "/emp/empdelete")
	public String deleteEmp(int empid) {
		service.deleteEmp(empid);
		return "redirect:emplist";
	}

	@RequestMapping(value = "/emp/empinsert", method = RequestMethod.POST)
	public String empInsert(EmpVO emp) {
		service.insertEmp(emp);
		return "redirect:emplist";
	}

	@RequestMapping("dept/deptlist2")
	public String deptlist3(Model model) {
		model.addAttribute("deptlist", dao.selectAll());
		return "dept/deptlist";
	}

	// request의 이름(유저의 요청)
	@RequestMapping("/deptlist2")
	// 이건 실행할 함수 명
	public String deptlist1() {

		// page 명(보여줄 jsp의 진짜 이름)
		return "dept/deptlist";

	}

	@RequestMapping(value = "dept/deptdetail", method = RequestMethod.GET)
	public String deptDetailGet(Integer deptid, Model model) {
		model.addAttribute("dept", dao.selectById(deptid));
		return "dept/deptdetail";

	}

	@RequestMapping(value = "dept/deptdetail", method = RequestMethod.POST)
	public String deptDetailPost(DeptDTO dept) {

		dao.updateDept(dept);

		return "redirect:deptlist2";

	}

	@RequestMapping(value = "dept/deptinsert", method = RequestMethod.GET)
	public String deptInsertGet() {
		return "dept/deptinsert";
	}

	@RequestMapping(value = "dept/deptinsert", method = RequestMethod.POST)
	public String deptInsertPost(DeptDTO dept, HttpServletRequest request) {
		MultipartFile uploadfile = dept.getUploadfile();
		if (uploadfile == null)
			return "redirect:deptinsert";

		String path = request.getSession().getServletContext().getRealPath("/resources");
		String fileName = uploadfile.getOriginalFilename();
		String fpath = path + "\\" + fileName;
		dept.setFileName(fileName);
		try {
			// File 사용
			File file = new File(fpath);
			uploadfile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dao.insertdept(dept);
		return "redirect:deptlist2";
	}

	@RequestMapping("/dept/deptdownload")
	public void download(String folder, String file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
		String fullPath = request.getSession().getServletContext().getRealPath(folder + "/" + file);
		FileInputStream fi = new FileInputStream(fullPath);
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fi.read(buf, 0, 1024)) != -1) {
			sout.write(buf, 0, size);
		}
		fi.close();
		sout.close();
	}
	
	

	@RequestMapping(value = "dept/deptdelete", method = RequestMethod.GET)
	public String deptdeleteGet(int deptid) {
		dao.deleteDept(deptid);
		return "redirect:deptlist2";
	}

	// DeptDAO dao = new DeptDAO();
	// <bean id ="dao" class="com.hanhwa.model.DeptDAO"/>
	// <bean id="myController" class="">
	// <property name="dao" ref="dao">

	@ExceptionHandler(Exception.class)
	public String error500(Exception ex, Model model) {
		model.addAttribute("company", "한화ICT");
		model.addAttribute("manager", "BJ");
		model.addAttribute("phone", "010-7124-9348");
		model.addAttribute("errormessage", ex.getMessage());
		return "error500";
	}

	@RequestMapping("/404")
	public String error404(Model model) {
		model.addAttribute("company", "한화ICT");
		model.addAttribute("manager", "BJ");
		return "error404";
	}

	/*
	 * @RequestMapping("/500") public String error500(Model model) {
	 * model.addAttribute("company", "한화ICT"); model.addAttribute("manager", "BJ");
	 * model.addAttribute("phone", "010-7124-9348"); return "error500"; }
	 */

}
