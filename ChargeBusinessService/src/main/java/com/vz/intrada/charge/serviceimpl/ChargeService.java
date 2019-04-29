package com.vz.intrada.charge.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.intrada.charge.controller.ChargeBO;
import com.vz.intrada.charge.db.ChargeMapper;
import com.vz.intrada.charge.db.ChargePBO;

@Service
public class ChargeService {

	@Autowired
	ChargeMapper chargeMapper;

	public ChargePBO save(ChargeBO theBO) throws Exception {

		boolean successFlag = false;
		ChargePBO chargePBO = new ChargePBO();
		mapBOTOPBO(chargePBO, theBO);

		try {
			persist(chargePBO);
			successFlag = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return chargePBO;
	}

	private void persist(ChargePBO myBO) throws Exception {

		if (myBO.getSequenceNumber() == null) {
			myBO.setSequenceNumber(new Integer(0));
		}
		// check the SubmitStatus and ensure set first time
		if (myBO.getSubmitStatus() == null) {
			myBO.setSubmitStatus("N");
		}

		String myChargeDesc = myBO.getChargeDesc();
		if (myChargeDesc != null) {
			if (myChargeDesc.length() > 40) {
				myBO.setChargeDesc(myChargeDesc.substring(0, 40));
			}
		}
		ChargeMapper chargeMapper = new ChargeMapper();

		chargeMapper.persist(myBO);

		return;
	}

	public ChargeBO findByPrimaryKey(String theChargeId) throws Exception {
		boolean successFlag = false;

		System.out.println("service start - findByPrimaryKey");
		// Initialize return data
		ChargePBO foundBO = null;
		ChargeBO chargeBO = new ChargeBO();

		try {

			foundBO = chargeMapper.findByChargeId(theChargeId);
			System.out.println("foundBO===" + foundBO);
			mapPBOToBO(foundBO, chargeBO);

			successFlag = true;
		}

		catch (Exception e) {
			throw e;
		}
		System.out.println("service end - findByPrimaryKey" + chargeBO);
		return chargeBO;
	}

	private void mapPBOToBO(ChargePBO foundBO, ChargeBO chargeBO) {
		chargeBO.setChargeId(foundBO.getChargeId());
		chargeBO.setBillingTnId(foundBO.getBillingTnId());
		chargeBO.setChargeType(foundBO.getChargeType());
		chargeBO.setChargeSubType(foundBO.getChargeSubType());
		chargeBO.setChargeDesc(chargeBO.getChargeDesc());
	}

	private void mapBOTOPBO(ChargePBO pbo, ChargeBO chargeBO) {
		pbo.setBillingTnId(chargeBO.getBillingTnId());
		pbo.setChargeType(chargeBO.getChargeType());
		pbo.setChargeSubType(chargeBO.getChargeSubType());
		pbo.setChargeDesc(chargeBO.getChargeDesc());
	}

}
