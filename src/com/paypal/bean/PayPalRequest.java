package com.paypal.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.StringUtil;

/**
 * @see <a href="https://developer.paypal.com/docs/classic/express-checkout/ht_ec-refTrans-SetEC-DoRefTrans-curl-etc/">PayPal API Documentation</a>
 * @author chazz
 *
 */
public class PayPalRequest {
	
	public static enum Method {
		SET_EXPRESS_CHECKOUT
		("SetExpressCheckout"),
		
		CREATE_BILLING_AGREEMENT
		("CreateBillingAgreement"),
		
		DO_REFERENCE_TRANSACTION
		("DoReferenceTransaction"),
		
		MASS_PAY
		("MassPay");
		
		private String value;
		
		private Method(String value){
			this.value = value;
		}
		
		@Override
		public String toString() {
			return this.value;
		}
	};
	
	private String signature;
	
	private String username;
	
	private String password;
	
	private String method;
	
	private String version;
	
	private List<PaymentRequest> paymentRequests;
	
	private List<Billing> billings;
	
	private String cancelUrl;
	
	private String returnUrl;
	
	private String token;
	
	private String paymentAction;
	
	private String referenceId;
	
	private String amount;
	
	private String url;
	
	private String currencyCode;
	
	public PayPalRequest() {
		billings = new ArrayList<Billing>();
		paymentRequests = new ArrayList<PaymentRequest>();
	}
	
	public void addPaymentRequest(String action, String amount, String currencyCode) {
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.action = action;
		paymentRequest.amount = amount;
		paymentRequest.currencyCode = currencyCode;
		paymentRequests.add(paymentRequest);
	}
	
	public void addBilling(String type, String agreementDescription){
		Billing billing = new Billing();
		billing.type = type;
		billing.agreementDescription = agreementDescription;
		billings.add(billing);
	}
	
	public Map<String, String> toParameterMap(){
		Map<String, String> varsMap = new HashMap<String, String>();
		if(!StringUtil.isEmpty(this.username)){
			varsMap.put("USER", this.username);
		}
		
		if(!StringUtil.isEmpty(this.password)){
			varsMap.put("PWD", this.password);
		}
		
		if(!StringUtil.isEmpty(this.signature)) {
			varsMap.put("SIGNATURE", this.signature);
		}
		
		if(!StringUtil.isEmpty(this.method)){
			varsMap.put("METHOD", this.method);
		}
		
		if(!StringUtil.isEmpty(this.version)){
			varsMap.put("VERSION", this.version);
		}
		
		if(!StringUtil.isEmpty(this.paymentAction)){
			varsMap.put("PAYMENTACTION", this.paymentAction);
		}
		
		if(!StringUtil.isEmpty(this.referenceId)){
			varsMap.put("REFERENCEID", this.referenceId);
		}
		
		if(!StringUtil.isEmpty(this.amount)){
			varsMap.put("AMT", this.amount);
		}
		
		if(!StringUtil.isEmpty(this.currencyCode)){
			varsMap.put("CURRENCYCODE", this.currencyCode);
		}
		
		if(!StringUtil.isEmpty(this.cancelUrl)){
			varsMap.put("cancelUrl", this.cancelUrl);
		}
		
		if(!StringUtil.isEmpty(this.returnUrl)){
			varsMap.put("returnUrl", this.returnUrl);
		}
		
		if(!StringUtil.isEmpty(this.token)){
			varsMap.put("token", this.token);
		}
		
		if(!this.paymentRequests.isEmpty()){
			int index = 0;
			for(PaymentRequest paymentRequest: paymentRequests){
				varsMap.put("PAYMENTREQUEST_"+ index +"_PAYMENTACTION", paymentRequest.action);
				varsMap.put("PAYMENTREQUEST_"+ index +"_AMT", paymentRequest.amount);
				varsMap.put("PAYMENTREQUEST_"+ index +"_CURRENCYCODE", paymentRequest.currencyCode);
				
				index++;
			}
		}
		
		if(!this.billings.isEmpty()){
			int index = 0;
			for(Billing billing: billings){
				varsMap.put("L_BILLINGTYPE"+index, billing.type);
				varsMap.put("L_BILLINGAGREEMENTDESCRIPTION"+index, billing.agreementDescription);
				
				index++;
			}
		}
		
		return varsMap;
	}
	
	public static class PaymentRequest {
		
		private String action;
		
		private String amount;
		
		/**
		 * @see <a href="https://developer.paypal.com/docs/classic/api/currency_codes/">Supported Currency Codes</a>
		 */
		private String currencyCode;

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getCurrencyCode() {
			return currencyCode;
		}

		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}
		
	}

	public static class Billing {
		
		private String type;
		
		private String agreementDescription;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getAgreementDescription() {
			return agreementDescription;
		}

		public void setAgreementDescription(String agreementDescription) {
			this.agreementDescription = agreementDescription;
		}
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<PaymentRequest> getPaymentRequests() {
		return paymentRequests;
	}

	public List<Billing> getBillings() {
		return billings;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPaymentAction() {
		return paymentAction;
	}

	public void setPaymentAction(String paymentAction) {
		this.paymentAction = paymentAction;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
