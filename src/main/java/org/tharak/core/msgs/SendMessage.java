package org.tharak.core.msgs;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SendMessage {
    // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACe99a5a3f0724897a9d9faac05b3b672c";
    public static final String AUTH_TOKEN = "4a7848f0ab633d9a2eb8a1081acd8ca0";

    public static void main(String[] args) {
    	sendMsg("+919573725223");

    }
    public static void sendMsg(String mobileNum) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:"+mobileNum),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Hello This is Tharaka Venu!")
            .create();

        System.out.println(message.getSid());    	
    }
    public static void sendMsg(String mobileNum, String txtMessage) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(mobileNum),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                txtMessage)
            .create();

        System.out.println(message.getSid());    	
    }
}
