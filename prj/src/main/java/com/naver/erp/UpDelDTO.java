package com.naver.erp;

public class UpDelDTO {
	//developer_no 은 구분하기 위한 개발자 고유 넘버(자동부여).
	//===================================
	private int developer_no;
	//===================================
	private String developer_name;
	private String[] jumin_no;
	private String religion_code;
	private String school_code;
	private String[] skill_code;
	private String[] graduate_day;
	
	//아래는 배열로 들어온 코드를 합하는 변수
	//DB에 들어갈 변수이다.
	private String sum_jumin_no;
	private String sum_graduate_day;
	
	
	//스킬을 하나씩 짤라서 들어갈 변수
		private String oneByOne_skill_code;


		public int getDeveloper_no() {
			return developer_no;
		}


		public void setDeveloper_no(int developer_no) {
			this.developer_no = developer_no;
		}


		public String getDeveloper_name() {
			return developer_name;
		}


		public void setDeveloper_name(String developer_name) {
			this.developer_name = developer_name;
		}


		public String[] getJumin_no() {
			return jumin_no;
		}


		public void setJumin_no(String[] jumin_no) {
			this.jumin_no = jumin_no;
		}


		public String getReligion_code() {
			return religion_code;
		}


		public void setReligion_code(String religion_code) {
			this.religion_code = religion_code;
		}


		public String getSchool_code() {
			return school_code;
		}


		public void setSchool_code(String school_code) {
			this.school_code = school_code;
		}


		public String[] getSkill_code() {
			return skill_code;
		}


		public void setSkill_code(String[] skill_code) {
			this.skill_code = skill_code;
		}


		public String[] getGraduate_day() {
			return graduate_day;
		}


		public void setGraduate_day(String[] graduate_day) {
			this.graduate_day = graduate_day;
		}


		public String getSum_jumin_no() {
			return sum_jumin_no;
		}


		public void setSum_jumin_no(String sum_jumin_no) {
			this.sum_jumin_no = sum_jumin_no;
		}


		public String getSum_graduate_day() {
			return sum_graduate_day;
		}


		public void setSum_graduate_day(String sum_graduate_day) {
			this.sum_graduate_day = sum_graduate_day;
		}


		public String getOneByOne_skill_code() {
			return oneByOne_skill_code;
		}


		public void setOneByOne_skill_code(String oneByOne_skill_code) {
			this.oneByOne_skill_code = oneByOne_skill_code;
		}
	
	
		
		
	
	
	
	
	
	
	
	
	
}
