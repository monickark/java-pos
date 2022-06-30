package com.pos.repair.dao;

import com.pos.common.exceptions.DuplicateEntryException;

public interface IRepairDAO {

	void addRepair(Repair repair) throws DuplicateEntryException;

	

}
