java-paypal-express-checkout
============================

Wrapper classes for integrating with PayPal Express Checkout API

### Currently Supported PayPal API's
- Reference Transaction thru ExpressCheckout
- MassPay API


## How to Use?
1. Prepare the request
```java
  
PayPalRequest request = new PayPalRequest();

//set the credentials
request.setUsername(<username>);
request.setPassword(<password>);
request.setSignature(<signature>);

//set the method
request.setMethod(<PayPalRequest.Method.*>);

//TODO set the remaining things needed
```

2. Send the request to PayPal. 

```java
PayPalResponse response = PayPalService.sendRequest(request);

if(response.isSuccessful()){
  System.out.println("Cool ryt!?");
} else {
  System.out.println("Failed to send request to paypal");
  
  //response.getErrorCode();
  System.out.println("Error code: " + response.getErrorCode());
  
  //response.getShortErrorMessage();
  System.out.println("Message: " + response.getShortErrorMessage());
}
```

