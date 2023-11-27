package com.naver.erp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
@Service
public interface InputDAO {
	int insertBoard(InputDTO inputDTO);
	int insertSkillBoard(InputDTO inputDTO);
}
