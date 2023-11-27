package com.naver.erp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@Autowired
	SearchDAO searchDAO;

	@RequestMapping(value = "/search.do")
	public ModelAndView searchPage(
			SearchDTO searchDTO
	) {
		ModelAndView mav = new ModelAndView();
		
		
		
		//졸업일 배열로 들어오기 확인
		
		if(searchDTO.getGraduate_day()!=null) {
			String[] arrGraduate_day = searchDTO.getGraduate_day();
			//System.out.println("길이: "+arrGraduate_day.length);
			//System.out.println(arrGraduate_day[0]);
			String first="";
			for(int i = 0; i < arrGraduate_day.length;i++) {
				
				if(Integer.parseInt(arrGraduate_day[i])<10) {
					first=first+"0"+arrGraduate_day[i];
							
				}else {
					first = first+arrGraduate_day[i];
				}
			}
			searchDTO.setFirst_day(first);
			//System.out.println(searchDTO.getFirst_day());
		}


		
		if(searchDTO.getGraduate_day2()!=null) {
			String[] arrGraduate_day2 = searchDTO.getGraduate_day2();
			//System.out.println("길이: "+arrGraduate_day2.length);
			//System.out.println(arrGraduate_day[0]);
			String second="";
			for(int i = 0; i < arrGraduate_day2.length;i++) {
				
				if(Integer.parseInt(arrGraduate_day2[i])<10) {
					second=second+"0"+arrGraduate_day2[i];
							
				}else {
					second = second+arrGraduate_day2[i];
				}
			}
			searchDTO.setSecond_day(second);
			//System.out.println(searchDTO.getSecond_day());
		}
		
		/*
		if(searchDTO.getGraduate_day2()!=null) {
			String[] arrGraduate_day2 = searchDTO.getGraduate_day2();
			//System.out.println(arrGraduate_day2[0]);
		}
		*/
		
		
		//조건에 맞는 개발자 목록 불러오기. + 개발자가 가지고 있는 스킬 목록 불러오기.
		//====================================================================
		Map<String, Object> developerListMap = getDeveloperListMap(searchDTO);
		List<Map<String, String>> skillListMap = getSkillListMap();
		//====================================================================
		//System.out.println(developerListMap);
		//System.out.println(skillListMap);
		
		//성별체크 하는게 배열로 들어오기
		if(searchDTO.getSex()!=null) { 
			String[] arrSex = searchDTO.getSex();
			//System.out.println(arrSex[0]);
			
		}
		//최종학력체크 하는게 배열로 들어오기
		if(searchDTO.getSchool_name()!=null) {
			String[] arrSchool_name = searchDTO.getSchool_name();
			//System.out.println(arrSchool_name[1]);
		}
		//기술체크 하는게 배열로 들어오기
		if(searchDTO.getSkill_name()!=null) {
			String[] arrSkill_name = searchDTO.getSkill_name();
			//System.out.println(arrSkill_name[0]);
		}
		
		
		
		//System.out.println(searchDTO.getKeyword());
		//System.out.println(searchDTO.getSex());
		/*
		System.out.println(searchDTO.getReligion_name());
		System.out.println(searchDTO.getSchool_name());
		System.out.println(searchDTO.getSkill_name());
		*/
	
		mav.addObject("developerListMap",developerListMap);
		mav.addObject("skillListMap",skillListMap);
		mav.setViewName("search.jsp");

		return mav;
	}
	
	//개발자 매퍼를 통해 리스트 얻어오기
	public Map<String, Object> getDeveloperListMap( 
			SearchDTO	searchDTO
	) {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, String>> developerList;
		int boardListCnt;
		int boardListCntAll;
		
		Map<String,Integer> pagingMap;
		
		boardListCntAll = this.searchDAO.getBoardListCntAll();
		boardListCnt = this.searchDAO.getBoardCnt(searchDTO);
		
		
		pagingMap = Util.getPagingMap(
				searchDTO.getSelectPageNo() //선택한 페이지 번호
				,searchDTO.getRowCntPerPage() //한 화면에 보여지는 행의 개수
				,boardListCnt						//검색된 게시판의 총 개수
		);
		
		searchDTO.setSelectPageNo((int)pagingMap.get("selectPageNo"));		//보정된 선택 페이지 번호 저장하기.
		searchDTO.setRowCntPerPage((int)pagingMap.get("rowCntPerPage"));	//페이지당 보일 행 개수 저장하
		searchDTO.setBegin_rowNo((int)pagingMap.get("begin_rowNo"));		//테이블에서 검색 시 시작행 번호 저장
		searchDTO.setEnd_rowNo((int)pagingMap.get("end_rowNo"));			// 테이블에서 검색 시 끝 행 번호 저장.


		developerList = this.searchDAO.getDeveloperList(searchDTO);

		resultMap.put("boardList", developerList);
		resultMap.put("boardListCnt", boardListCnt);
		resultMap.put("boardListCntAll", boardListCntAll);	
		resultMap.put("boardSearchDTO", searchDTO);
		//----------------------------------------------
		resultMap.put("begin_pageNo", pagingMap.get("begin_pageNo"));
		resultMap.put("end_pageNo", pagingMap.get("end_pageNo"));
		resultMap.put("selectPageNo", pagingMap.get("selectPageNo"));
		resultMap.put("last_pageNo", pagingMap.get("last_pageNo"));
		resultMap.put("begin_serialNo_asc", pagingMap.get("begin_serialNo_asc"));
		resultMap.put("begin_serialNo_desc", pagingMap.get("begin_serialNo_desc"));
		
		
		
		
		resultMap.put("developerList", developerList);
		resultMap.put("developerListCnt", developerList.size());
		//System.out.println(developerList.get(0).get("JUMIN_NO"));
		return resultMap;
	}
	public List<Map<String, String>> getSkillListMap( 
			
	) {

		
		List<Map<String, String>> skillList;

		skillList = this.searchDAO.getSkillList();

	
	
		return skillList;
	}
	
	
	
	
	
	
	
	
}
