package com.naver.erp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
@Service
public interface UpDelDAO {
	void updateDeveloper(UpDelDTO updelDTO);
	void updateSkill(UpDelDTO updelDTO);
	void deleteSkill(UpDelDTO updelDTO);
	
	void deleteDeveloper(UpDelDTO updelDTO);
	
}
