package com.metacube.assignment9_10.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.assignment9_10.model.Friends;

/**
 * @author krishan
 * FriendsMapper is Mapper class for Friends class
 *
 */
public class FriendsMapper implements RowMapper<List<Friends>>
{

	/**
	 * mapRow method is to map the result set
	 */
	@Override
	public List<Friends> mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		List<Friends> allFriendsList = new ArrayList<Friends>();
		while (rs.next())
		{
			Friends f = new Friends();
			f.getE().setEmpId(rs.getInt(1));
			f.getE().setEmpName(rs.getString(2));
			f.getE().setEmpEmail(rs.getString(3));
			f.getE().setEmpContact(rs.getString(4));
			f.getE().setEmpGender(rs.getString(5));
			f.getE().setEmpOrganization(rs.getString(6));

			f.getV().setVehicleName(rs.getString(7));
			f.getV().setVehicleType(rs.getString(8));
			f.getV().setVehicleNumber(rs.getString(9));
			f.getV().setPassPriceDetail(rs.getString(10));
			allFriendsList.add(f);

		}
		return allFriendsList;
	}

}
