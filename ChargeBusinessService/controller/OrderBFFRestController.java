package com.ibm.intrada.order.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eds.intrada.IntradaServer.BusinessObject.Common.OrderViewRBO;
import com.ibm.intada.order.service.OrderServiceImpl;

@RestController
public class OrderBFFRestController {

	@Autowired
	private OrderServiceImpl serv;

	@RequestMapping(value = "/verizon/poc/orderbyTn/{tnNo}", method = RequestMethod.GET, produces = {
			"application/json" }, consumes = { "application/json" })
	public ResponseEntity<List<OrderViewJSON>> findByTN(@PathVariable("tnNo") String tnNo) throws Exception {
		try {
			long stTime = System.currentTimeMillis();
			System.out.println("controller tnNo-----------------------------------------------------------" + tnNo);
			System.out.println(
					"rest endpoint start time-----------------------------------------------------------" + stTime);
			OrderViewRBO[] rboArr = serv.findByTN(tnNo);
			
			System.out.println("rboArr=="+rboArr);
			List list = new ArrayList();
        	for(OrderViewRBO orderViewRBO : rboArr){
        		System.out.println(orderViewRBO.getOrderNumber());
        		list.add(orderViewRBO);
        	}
			List<OrderViewJSON> jsonObjList= populateJsonReturnList(list);
			long endTime = System.currentTimeMillis();
			System.out.println(
					"rest endpoint end  time-----------------------------------------------------------" + endTime);
			System.out.println("rest endpoint Time Taken-----------------------------------------------------------"
					+ (endTime - stTime));
			return new ResponseEntity<List<OrderViewJSON>>(jsonObjList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	private List<OrderViewJSON> populateJsonReturnList(List<OrderViewRBO> list) {
		List<OrderViewJSON> jsonObjList = new ArrayList<OrderViewJSON>();
		for(OrderViewRBO rbo : list){
			OrderViewJSON  orderViewJSON = new OrderViewJSON();
			orderViewJSON.setAccountNumber(rbo.getAccountNumber());
			orderViewJSON.setOrderNumber(rbo.getOrderNumber());
			jsonObjList.add(orderViewJSON);
		}
		return jsonObjList;
		
	}
}
