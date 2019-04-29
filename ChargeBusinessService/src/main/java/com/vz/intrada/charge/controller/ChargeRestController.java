package com.vz.intrada.charge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vz.intrada.charge.serviceimpl.ChargeService;

@RestController
public class ChargeRestController {

	@Autowired
	ChargeService chargeService;

	@RequestMapping(value = "/charge/{chargeId}", method = RequestMethod.GET)
	public ChargeBO getCharge(@PathVariable("chargeId") String chargeId) throws Exception {
		ChargeBO chargeBO = null;
		try {
			System.out.println("Rest--getCharge");

			chargeBO = chargeService.findByPrimaryKey(chargeId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return chargeBO;

	}

}
