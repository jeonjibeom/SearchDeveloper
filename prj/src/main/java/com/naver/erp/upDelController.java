package com.naver.erp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class upDelController {
	
	@Autowired
	UpDelDAO upDelDAO;
	
	@RequestMapping(value = "/updel.do")
	public ModelAndView inputPage(
			UpDelDTO upDelDTO
			
	) {
		ModelAndView mav = new ModelAndView();
		
		//System.out.println(upDelDTO.getDeveloper_no());
//		System.out.println("-----------------------------------------");
//		System.out.println(upDelDTO.getDeveloper_name());
//		System.out.println(upDelDTO.getJumin_no());
//		System.out.println(upDelDTO.getReligion_code());
//		System.out.println(upDelDTO.getSchool_code());
//		System.out.println(upDelDTO.getSkill_code());
//		System.out.println(upDelDTO.getGraduate_day());
//		System.out.println("-----------------------------------------");
		
		
		//주민번호 합치기
		if(upDelDTO.getJumin_no()!=null) {
			String[] arr = upDelDTO.getJumin_no();
			String tmp = "";
			//System.out.println(arr[1]);
			for(int i = 0 ; i<arr.length; i++) {
				tmp = tmp + arr[i];
			}
			upDelDTO.setSum_jumin_no(tmp);
			//System.out.println(upDelDTO.getSum_jumin_no());
		}
		//졸업일 합치기.
		if(upDelDTO.getJumin_no()!=null) {
			String[] arr = upDelDTO.getGraduate_day();
			String tmp = "";
				for(int i = 0; i < arr.length;i++) {
				
					if(Integer.parseInt(arr[i])<10) {
						tmp=tmp+"0"+arr[i];
								
					}else {
						tmp = tmp+arr[i];
					}
				}
				upDelDTO.setSum_graduate_day(tmp);
				//System.out.println(upDelDTO.getSum_graduate_day());
			
		}
		if(upDelDTO.getSkill_code()!=null) {
			String[] arr = upDelDTO.getSkill_code();
			for(int i = 0 ; i<arr.length ; i++) {
				
			}
		}
		
		
		mav.addObject("developer_no",upDelDTO.getDeveloper_no());
		
		//System.out.println(inputDTO.getSum_graduate_day());
		
		if(upDelDTO.getDeveloper_name()!=null && upDelDTO.getDeveloper_name().length()>0 && upDelDTO.getDeveloper_no()!=0) {
			upDelDAO.deleteSkill(upDelDTO);
			upDelDAO.updateDeveloper(upDelDTO);
			
			String[] arr = upDelDTO.getSkill_code();
			
			for(int i = 0 ; i<arr.length;i++) {
				upDelDTO.setOneByOne_skill_code(arr[i]);
				upDelDAO.updateSkill(upDelDTO);
			}
			
			System.out.println("수정완료");
		}
		
		
		
		//System.out.println(upDelDTO.getDeveloper_no());
		
		
		
		
		

		
		
		mav.setViewName("updel.jsp");
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/del.do")
	public ModelAndView delete(
			UpDelDTO upDelDTO
			
	) {
		ModelAndView mav = new ModelAndView();
		//System.out.println("1234");
		
		System.out.println(upDelDTO.getDeveloper_no());
		
		//1. 스킬먼저 지우고 -> developer지우기.
		if(upDelDTO.getDeveloper_no()!=0) {
			upDelDAO.deleteSkill(upDelDTO);
			upDelDAO.deleteDeveloper(upDelDTO);
			
			System.out.println(upDelDTO.getDeveloper_no()+" 삭제완료");
		}
		
		
		mav.setViewName("search.jsp");
		return mav;
	}
	
}
