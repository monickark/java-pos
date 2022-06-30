package com.pos.user.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IMenuprofileListDao {

	List<String> selectMenuProfile(String instid) throws NoDataFoundException;

}
