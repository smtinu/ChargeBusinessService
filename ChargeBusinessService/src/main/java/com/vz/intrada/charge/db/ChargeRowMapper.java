package com.vz.intrada.charge.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vz.intrada.charge.controller.ChargeBO;

public class ChargeRowMapper implements RowMapper<ChargePBO> {

	@Override
	public ChargePBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ChargePBO chargeBO = new ChargePBO();
		chargeBO.setChargeId(rs.getString("charge_id"));
		/*
		 * chargeBO.setBillingTnId("billing_tn_id");
		 * chargeBO.setChargeType("charge_type");
		 * chargeBO.setChargeSubType("charge_sub_type");
		 * chargeBO.setChargeDesc("charge_desc");
		 */
		return chargeBO;
	}

}
