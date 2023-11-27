package com.naver.erp;

public class SearchDTO {

	private String keyword;
	//private String developer_name;
	private String[] sex;//성별
	private String religion_name;//종교
	private String[] school_name;//최종학력
	private String[] skill_name; //value 는 1~5의 숫자


	private String[] graduate_day;
	private String[] graduate_day2;
	
	
	private String first_day;
	private String second_day;
	
	
	//===============================================================================
	private int selectPageNo;	//선택 페이지 번호 관련 파라미터값 저장 변수
	private int rowCntPerPage=5;	//페이지당 보여줄 행의 갯수 관련 파라미터값 저장 변수
	private int begin_rowNo;	//테이블 검색 시 시작행번호 저장 변수 선언.(파라미터값 저장변수 아님)
	private int end_rowNo;		//테이블 검색 시 끝행 번호 저장 변수 선언.(파라미터값 저장변수 아님)
	//===============================================================================
	
	
	
	
	
	
	
	public String getKeyword() {
		return keyword;
	}
	public int getSelectPageNo() {
		return selectPageNo;
	}
	public void setSelectPageNo(int selectPageNo) {
		this.selectPageNo = selectPageNo;
	}
	public int getRowCntPerPage() {
		return rowCntPerPage;
	}
	public void setRowCntPerPage(int rowCntPerPage) {
		this.rowCntPerPage = rowCntPerPage;
	}
	public int getBegin_rowNo() {
		return begin_rowNo;
	}
	public void setBegin_rowNo(int begin_rowNo) {
		this.begin_rowNo = begin_rowNo;
	}
	public int getEnd_rowNo() {
		return end_rowNo;
	}
	public void setEnd_rowNo(int end_rowNo) {
		this.end_rowNo = end_rowNo;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String[] getSex() {
		return sex;
	}
	public void setSex(String[] sex) {
		this.sex = sex;
	}
	public String getReligion_name() {
		return religion_name;
	}
	public void setReligion_name(String religion_name) {
		this.religion_name = religion_name;
	}
	public String[] getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String[] school_name) {
		this.school_name = school_name;
	}
	public String[] getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String[] skill_name) {
		this.skill_name = skill_name;
	}
	public String[] getGraduate_day() {
		return graduate_day;
	}
	public void setGraduate_day(String[] graduate_day) {
		this.graduate_day = graduate_day;
	}
	public String[] getGraduate_day2() {
		return graduate_day2;
	}
	public void setGraduate_day2(String[] graduate_day2) {
		this.graduate_day2 = graduate_day2;
	}
	public String getFirst_day() {
		return first_day;
	}
	public void setFirst_day(String first_day) {
		this.first_day = first_day;
	}
	public String getSecond_day() {
		return second_day;
	}
	public void setSecond_day(String second_day) {
		this.second_day = second_day;
	}
	
	

	
}
