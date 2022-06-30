package com.pos.framework.sessCache.dao;

public interface IClearSessionDao {
	public void deleteLogin(String sessionId);

	public int selectLogin();

	public void truncateLogin();
}
