package biz.r2s.sms.gateway.notificationimport org.smslib.AGatewayimport org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage
class OutboundNotification implements IOutboundMessageNotification{	public void process(AGateway gateway, OutboundMessage msg) {		System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());		System.out.println(msg);	}}
