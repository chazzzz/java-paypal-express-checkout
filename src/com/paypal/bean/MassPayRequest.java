package com.paypal.bean;

import java.util.HashMap;
import java.util.Map;

public class MassPayRequest extends PayPalRequest {
	
	private Map<String, String> payables;
	
	private String receiverType;
	
	public MassPayRequest() {
		super();
		payables = new HashMap<String, String>();
		setMethod(Method.MASS_PAY.toString());
		setVersion("90");
		setReceiverType("EmailAddress");
	}
	
	public void addPayable(String email, String amount){
		payables.put(email, amount);
	}
	
	@Override
	public Map<String, String> toParameterMap() {
		Map<String, String> varsMap = super.toParameterMap();
		int index = 0;
		if(!payables.isEmpty()){
			for(String email: payables.keySet()){
				String amount = payables.get(email);
				varsMap.put("L_EMAIL" + index, email);
				varsMap.put("L_AMT" + index, amount);
				index++;
			}
		}
		
		return varsMap;
	}

	public String getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}
	
	public void setPayables(Map<String, String> payables) {
		this.payables = payables;
	}
}
