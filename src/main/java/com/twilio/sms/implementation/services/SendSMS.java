/**
 * 
 */
package com.twilio.sms.implementation.services;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

/**
 * @author vamsir
 *
 */
@RestController
@RequestMapping("/sms")
public class SendSMS {

	@RequestMapping(value = "send", method = RequestMethod.POST)
	public ResponseEntity<String> sendMessage(@RequestBody JSONObject customer) {

		String ACCOUNT_SID = (String) customer.get("accountsid");
		String AUTH_TOKEN = (String) customer.get("authtoken");
		String FROM_PHONE = (String) customer.get("from");
		String TO_PHONE = (String) customer.get("to");
		String MESSAGE_TO_SEND = (String) customer.get("message");

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new com.twilio.type.PhoneNumber(TO_PHONE),
				new com.twilio.type.PhoneNumber(FROM_PHONE), MESSAGE_TO_SEND).create();

		return ResponseEntity.ok().body(message.getSid());

	}

}
