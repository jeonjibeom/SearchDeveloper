package com.naver.erp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
@Service
public interface SearchDAO {
	List<Map<String,String>> getDeveloperList(SearchDTO searchDTO);
	List<Map<String,String>> getSkillList();
	int getBoardListCntAll();
	//int getBoardListCnt(SearchDTO searchDTO);
	int getBoardCnt(SearchDTO searchDTO);
}
