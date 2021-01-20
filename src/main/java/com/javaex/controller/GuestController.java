package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Controller
@RequestMapping(value="/guest")
public class GuestController {

	//필드
	
	//생성자
	
	//메소드 g.s
	
	//메소드 일반
	//http://localhost:8088/guestbook3/guest/addList
	@RequestMapping(value = "/addList" ,method = {RequestMethod.GET,RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("리스트 처리");
		
		GuestBookDao guestDao = new GuestBookDao();
		List<GuestBookVo> guestList = guestDao.getList();
		System.out.println(guestList.toString());
		
		model.addAttribute("guestList", guestList);
		
		return "addList";
	}
	
	//http://localhost:8088/guestbook3/guest/insert?name=?&password=?&content=?
	@RequestMapping(value="/insert", method = {RequestMethod.GET,RequestMethod.POST})
	public String insert(@ModelAttribute GuestBookVo guestVo) {
		System.out.println("insert");
		System.out.println(guestVo.toString());
		
		GuestBookDao guestDao = new GuestBookDao();
		guestDao.insert(guestVo);
		
		return "redirect:/guest/addList";
	}
	
	//http://localhost:8088/guestbook3/guest/deleteForm&no=61
	@RequestMapping(value="/deleteForm/{no}" , method = {RequestMethod.GET,RequestMethod.POST})
	public String deleteForm(@PathVariable("no") int no) {
		System.out.println("delete");
		System.out.println(no);
	
		return "deleteForm";
	}
	
	//http://localhost:8088/guestbook3/guest/delete?password=?&no=?
	@RequestMapping(value="/delete/{no}/{password}", method = {RequestMethod.GET,RequestMethod.POST})
	public String delete(@PathVariable("no") int no,
						 @PathVariable("password") String password) {
		System.out.println("delete");
		
		GuestBookVo guestVo = new GuestBookVo(no, password);
		GuestBookDao guestDao = new GuestBookDao();
	    guestDao.delete(guestVo);
		
		return "redirect:/guest/addList";
	}
}
