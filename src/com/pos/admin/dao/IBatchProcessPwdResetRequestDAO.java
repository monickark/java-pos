package com.pos.admin.dao;

import java.util.List;

import com.pos.common.exceptions.BatchUpdateFailedException;
import com.pos.user.dao.User;

public interface IBatchProcessPwdResetRequestDAO {
	public void updateBatch(final List<User> batchup) throws BatchUpdateFailedException ;
}
