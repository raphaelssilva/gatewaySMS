package biz.r2s.sms.gateway.notification

import org.smslib.AGateway
import org.smslib.ICallNotification;

class CallNotification implements ICallNotification {
	public void process(AGateway gateway, String callerId)
	{
		System.out.println(">>> New call detected from Gateway: " + gateway.getGatewayId() + " : " + callerId);
	}
}
