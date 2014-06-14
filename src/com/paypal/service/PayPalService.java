package com.paypal.service;

import java.io.IOException;

import util.StringUtil;
import util.WebUtil;

import com.paypal.bean.PayPalRequest;
import com.paypal.bean.PayPalResponse;

/**
 * 
 * @author chazz
 *
 */
public class PayPalService {

	/**
	 * Sends the request to paypal with the specified url and parameters <br/>
	 * 
	 * @param request
	 * @return 
	 * @throws IOException
	 */
	public static PayPalResponse sendRequest(PayPalRequest request) {
		String responseStr = null;
		try{
			responseStr = WebUtil.post(request.getUrl(), request.toParameterMap());
			if(!StringUtil.isEmpty(responseStr)){
				return new PayPalResponse(responseStr);
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
