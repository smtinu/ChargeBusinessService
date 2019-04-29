/*==============================================================================
EDS Confidential
Copyright �2005 Electronic Data Systems Corporation. All rights reserved.
================================================================================
$Revision: 1.1 $

$Log:
 3    Trunk-Rlse711.2         8/1/2005 5:17:11 PM    Starbase Server
      Administrator checkin to bring prod up to date with R5.2
 2    Trunk-Rlse711.1         7/17/2005 9:00:46 PM   Starbase Server
      Administrator Retrofit 52 to Prod.  Lisa
 1    Trunk-Rlse711.0         5/9/2005 4:21:01 PM    Starbase Server
      Administrator 
$

==============================================================================*/

package com.vz.intrada.charge.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ChargeMapper extends MapperBase {

	@Autowired
	private DataSource ds;

	private String TABLE_NAME = "WCOMDBA.IN_CHARGE";
	private String CLASS_NAME = "ChargeMapper";
	private String SEQUENCE_NAME = "in_charge_s01";
	private boolean IS_SEQUENCE_PADDED = true;
	private int SEQUENCE_LENGTH = 12;

	public ChargeMapper() {
		System.out.println(this.ds);
	}

	public void persist(ChargePBO theCharge) throws Exception {
		String newChargeId = getNextSequenceNumber(ds, SEQUENCE_NAME, IS_SEQUENCE_PADDED, SEQUENCE_LENGTH);
		String createSQL = "";
		PreparedStatement preparedStatement = getPreparedStatement(ds, createSQL);
		int rowCount = preparedStatement.executeUpdate();
		return;
	}

	public void update(ChargePBO theCharge) throws Exception {
		return;
	}

	public ChargePBO[] findByCustomerId(Long aCustomerId) throws Exception {
		String sqlString = "Select * from in_charge where WHERE customer_id = ?";
		PreparedStatement preparedStatement = getPreparedStatement(ds, sqlString);
		preparedStatement.setLong(1, aCustomerId.longValue());
		ResultSet rs = preparedStatement.executeQuery(sqlString);
		List<ChargePBO> resultList = new ArrayList<ChargePBO>();
		while (rs.next()) {
			// Retrieve by column name
			ChargePBO chargeBO = new ChargePBO();
			chargeBO.setChargeId("charge_id");
			chargeBO.setBillingTnId("billing_tn_id");
			chargeBO.setChargeType("charge_type");
			chargeBO.setChargeSubType("charge_sub_type");
			chargeBO.setChargeDesc("charge_desc");
			resultList.add(chargeBO);
		}
		// STEP 6: Clean-up environment
		rs.close();
		preparedStatement.close();

		return convertListToArray(resultList);
	}

	public ChargePBO findByChargeId(String chargeId) throws Exception {
		System.out.println("ds=============" + ds);
		String sqlString = "select * from IN_CHARGE  WHERE charge_id=:id";
		String sqlString1 = "SELECT CHARGE_ID, CUSTOMER_ID, BILLING_TN_ID, CHARGE_CODE, "
				+ "CHARGE_TYPE, CHARGE_SUB_TYPE, CHARGE_DESC, \"SOURCE\", RECURRING_FLAG, TAXABLE_FLAG, WAIVED_FLAG, "
				+ "PRORATE_FLAG, MONTHLY_AMOUNT, ORIGINAL_AMOUNT, TOTAL_AMOUNT, MINIMUM_AMOUNT, MAXIMUM_AMOUNT, EFFECTIVE_DATE, "
				+ "DEACTIVATE_DATE, FIRST_BILLED_DATE, BILLED_THROUGH_DATE, DISCOUNT_TYPE, PRODUCT_CODE, USOC, QUANTITY, "
				+ "PRESENT_IN_BILL_SYSTEM_FLAG, VALIDATED_FLAG, ACTION_CODE, LAST_UPDATE_USER, LAST_UPDATE_DATE, REVISION_NUMBER, "
				+ "SUB_TYPE_CODE, BILL_SYSTEM_LAST_UPDATE_DATE, SEQUENCE_NUMBER, CIRCUIT_ID, SUBMIT_STATUS, REFERENCE_NUMBER,"
				+ " UNIT_ORIGINAL_AMOUNT, UNIT_MONTHLY_AMOUNT, CHARGE_QUANTITY" + " FROM WCOMDBA.IN_CHARGE where CHARGE_ID=?";
		PreparedStatement preparedStatement = getPreparedStatement(ds, sqlString1);
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(ds);

		System.out.println(sqlString);
		preparedStatement.setString(1, chargeId);
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id", chargeId);
		List<ChargePBO> resultList = new ArrayList<ChargePBO>();
		// resultList = jdbcTemplate.query(sqlString, parameterSource, new
		// ChargeRowMapper());
		ResultSet rs = preparedStatement.executeQuery();
		System.out.println("rs==============" + rs);

		while (rs.next()) {
			// Retrieve by column name
			ChargePBO pbo = new ChargePBO();
			pbo.setChargeId(rs.getString("charge_id"));
			pbo.setBillingTnId(rs.getString("billing_tn_id"));
			pbo.setChargeType(rs.getString("charge_type"));
			pbo.setChargeSubType(rs.getString("charge_sub_type"));
			pbo.setChargeDesc(rs.getString("charge_desc"));
			resultList.add(pbo);
		}
		// STEP 6: Clean-up environment
		rs.close();
		preparedStatement.close();
		return resultList.get(0);
	}

	private ChargePBO[] convertListToArray(List theList) {
		int resultCount = theList.size();
		ChargePBO[] foundBOs = new ChargePBO[resultCount];

		// If List contains instances
		if (resultCount > 0) {
			// Convert the Vector to an Array
			foundBOs = (ChargePBO[]) theList.toArray(foundBOs);
		}

		return foundBOs;
	}

	protected String getNextSequenceNumber(DataSource ds, String SEQUENCE_NAME, boolean IS_SEQUENCE_PADDED,
			int SEQUENCE_LENGTH) throws Exception {
		final String METHOD_NAME = "getNextSequenceNumber()";

		String newSequence = null;
		ResultSet theResult = null;
		String theSQL = "Select " + SEQUENCE_NAME + ".nextval from dual";
		PreparedStatement thePreparedStatement = getPreparedStatement(ds, theSQL);

		try {

			theResult = thePreparedStatement.executeQuery();

			// Get sequence value from the ResultSet
			if (theResult.next()) {
				newSequence = theResult.getString(1);
			}

			// If the sequence is a CHAR field, left pad with zeroes.
			if ((newSequence != null) && (IS_SEQUENCE_PADDED)) {
				newSequence = padLeft(newSequence, SEQUENCE_LENGTH, '0');
			}
		} catch (SQLException sqle) {
			throw sqle;
		} finally {
			closeDatabaseResources(theResult);
		}

		return newSequence;
	}

}
