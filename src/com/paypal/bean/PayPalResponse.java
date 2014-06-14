package com.paypal.bean;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class PayPalResponse {
	
	private String rawResponse;

	private Boolean successful;
	
	private String transactionId;
	
	private String transactionType;
	
	private String paymentType;
	
	private String amount;
	
	private String paymentStatus;
	
	private String billingAgreementId;
	
	private String token;
	
	private String errorCode;
	
	private String shortErrorMessage;
	
	public PayPalResponse(String responseStr) {
		
		this.rawResponse = responseStr;
		
		String[] valuePairs = responseStr.split("&");
		
		for(String valuePair : valuePairs){
			if(valuePair.contains("=")){
				String[] pair = valuePair.split("=");
				if(pair.length == 2){
					try {
						String attribute = pair[0];
						String value = URLDecoder.decode(pair[1], "UTF-8");
						
						switch(attribute){
							case "ACK": {
								if("Success".equals(value)){
									this.successful = true;
								} else {
									this.successful = false;
								}
							}break;
							
							case "TRANSACTIONID": {
								this.transactionId = value;
							}break;
							
							case "TRANSACTIONTYPE": {
								this.transactionType = value;
							}break;
							
							case "PAYMENTTYPE": {
								this.paymentType = value;
							}break;
							
							case "AMT": {
								this.amount = value;
							}break;
							
							case "PAYMENTSTATUS": {
								this.paymentStatus = value;
							}break;
							
							case "BILLINGAGREEMENTID": {
								this.billingAgreementId = value;
							}break;
							
							case "TOKEN": {
								this.token = value;
							}break;
							
							case "L_ERRORCODE0": {
								this.errorCode = value;
							}break;
							
							case "L_SHORTMESSAGE0":{
								this.shortErrorMessage = value;
							}break;
							default: break;
						}
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			} else {
				
			}
		}
	}
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getBillingAgreementId() {
		return billingAgreementId;
	}

	public void setBillingAgreementId(String billingAgreementId) {
		this.billingAgreementId = billingAgreementId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getSuccessful() {
		return successful;
	}

	public Boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getShortErrorMessage() {
		return shortErrorMessage;
	}

	public void setShortErrorMessage(String shortErrorMessage) {
		this.shortErrorMessage = shortErrorMessage;
	}

	public String getRawResponse() {
		return rawResponse;
	}

	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}
	
	@Override
	public String toString() {
		try {
			return URLDecoder.decode(this.rawResponse, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "error";
		}
	}
}
