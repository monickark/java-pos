package com.pos.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pos.common.constants.CommonCodeConstant;
import com.pos.common.constants.MenuOptionConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;

@Repository
public class UserProfileGroupList extends BaseDao implements
		IUserProfileGroupList {

	Logger logger = Logger.getLogger(UserProfileGroupList.class);

	@Override
	public List<String> selectProfileGroup(final String instid,
			final String branchId, final String menuOptionId)
			throws NoDataFoundException {
		List<String> resultuser = null;
		List<String> data = new ArrayList<String>();
		StringBuffer query = new StringBuffer();
		query.append("SELECT distinct(PROFILE_GROUP) ")
				.append("from usrl, request where ")
				.append("usrl.inst_id = request.inst_id and ")
				.append("usrl.user_id = request.user_id and ")
				.append("request.inst_id = ? and ")
				.append("request.rqst_status != ?");
		data.add(instid);
		data.add(CommonCodeConstant.REQUEST_STATUS_CLOSED);
		if (menuOptionId
				.equals(MenuOptionConstant.REQUEST_MANAGEMENT_BRANCHADMIN)) {
			query.append("and request.BRANCH_ID=?");
			data.add(branchId);
		}
		String[] array = data.toArray(new String[data.size()]);
		logger.debug("select query :" + query.toString());
		resultuser = getJdbcTemplate().query(query.toString(), array,
				new MenuProfileRowMapper());
		if (resultuser.size() == 0) {
			throw new NoDataFoundException();
		}
		return resultuser;
	}

	class MenuProfileRowMapper implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet rs, int arg1) throws SQLException {
			return rs.getString("PROFILE_GROUP");

		}
	}

}