package com.naver.erp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputController {
	
	@Autowired
	InputDAO inputDAO;
	
	@RequestMapping(value = "/input.do")
	public ModelAndView inputPage_1(
			InputDTO inputDTO
	) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("input.jsp");
		return mav;
	}
		ModelAndView mav = new ModelAndView();
	@RequestMapping(value = "/input1.do")
	public ModelAndView inputPage(
			InputDTO inputDTO
	) {
		ModelAndView mav = new ModelAndView();
		
		
//		System.out.println("-----------------------------------------");
//		System.out.println(inputDTO.getName());
//		System.out.println(inputDTO.getJumin_no());
//		System.out.println(inputDTO.getReligion_code());
//		System.out.println(inputDTO.getSchool_code());
//		System.out.println(inputDTO.getSkill_code());
//		System.out.println(inputDTO.getGraduate_day());
//		System.out.println("-----------------------------------------");
//		df
		
		//주민번호 합치기
		if(inputDTO.getJumin_no()!=null) {
			String[] arr = inputDTO.getJumin_no();
			String tmp = "";
			//System.out.println(arr[1]);
			for(int i = 0 ; i<arr.length; i++) {
				tmp = tmp + arr[i];
			}
			inputDTO.setSum_jumin_no(tmp);
		}
		//졸업일 합치기.
		if(inputDTO.getJumin_no()!=null) {
			String[] arr = inputDTO.getGraduate_day();
			String tmp = "";
				for(int i = 0; i < arr.length;i++) {
				
					if(Integer.parseInt(arr[i])<10) {
						tmp=tmp+"0"+arr[i];
								
					}else {
						tmp = tmp+arr[i];
					}
				}
			inputDTO.setSum_graduate_day(tmp);
			
		}
		
		
		//개발자 등록과 개발자 스킬 등록
		if(inputDTO.getName()!=null && inputDTO.getName().length()>0) {
			inputDAO.insertBoard(inputDTO);
			String[] arr = inputDTO.getSkill_code();
			
			for(int i = 0 ; i<arr.length;i++) {
				inputDTO.setOneByOne_skill_code(arr[i]);
				inputDAO.insertSkillBoard(inputDTO);
			}
			
		}
		
		
		
		
		mav.setViewName("search.jsp");
		return mav;
	}
}
