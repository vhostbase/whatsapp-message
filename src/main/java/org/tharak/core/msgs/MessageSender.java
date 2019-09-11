package org.tharak.core.msgs;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class MessageSender {
    public static final String ACCOUNT_SID = "ACe99a5a3f0724897a9d9faac05b3b672c";
    public static final String AUTH_TOKEN = "4a7848f0ab633d9a2eb8a1081acd8ca0";
    public static void sendMsg(String mobileNum, String txtMessage) {
    	System.out.println("sendMsg called..");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(mobileNum),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                txtMessage)
            .create();

        System.out.println(message.getSid());    	
    }
}
