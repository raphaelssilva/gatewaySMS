package biz.r2s.sms.gateway.notification

import org.smslib.AGateway
import org.smslib.IGatewayStatusNotification;
import org.smslib.AGateway.GatewayStatuses

class GatewayStatusNotification implements IGatewayStatusNotification{

	public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus)
	{
		System.out.println(">>> Gateway Status change for " + gateway.getGatewayId() + ", OLD: " + oldStatus + " -> NEW: " + newStatus);
	}
}
