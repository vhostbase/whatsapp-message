package org.tharak.core.msgs;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	private final static String TEMPLATE = "{0} :\n{1}";
	@RequestMapping(method = RequestMethod.POST, path = "/adminMessage")
	public void adminMessage(@RequestBody String msg) {
		System.out.println("adminMessage called..");
		try {
			Map<String, String> result = splitQuery(msg);
			String SmsStatus = result.get("SmsStatus");
			System.out.println("SmsStatus :: "+SmsStatus);
			if("received".equalsIgnoreCase(SmsStatus)) {
				String fromAddr = result.get("From");
				fromAddr = fromAddr.replace("whatsapp:", "");
				String message = MessageFormat.format(TEMPLATE, new Object[] {fromAddr, result.get("Body")});
				String MediaContentType0 = result.get("MediaContentType0");
				if(MediaContentType0 != null && MediaContentType0.trim().length() > 0) {
					ArrayList<URI> mediaUris = new ArrayList<URI>();
					mediaUris.add(URI.create(result.get("MediaUrl0")));
					MessageSender.sendImageMsg("whatsapp:+919573725223", message, mediaUris);
				}else {
					MessageSender.sendMsg("whatsapp:+919573725223", message);
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println(msg);
	}
	@RequestMapping(method = RequestMethod.POST, path = "/inComingMessage")
	public void inComingMessage(@RequestBody String msg) {
		System.out.println("inComingMessage called..");
		/*
		 * try { Map<String, String> result = splitQuery(msg); String SmsStatus =
		 * result.get("SmsStatus"); System.out.println("SmsStatus :: "+SmsStatus);
		 * if("received".equalsIgnoreCase(SmsStatus)) { String fromAddr =
		 * result.get("From"); fromAddr = fromAddr.replace("whatsapp:", ""); String
		 * message = MessageFormat.format(TEMPLATE, new Object[] {fromAddr,
		 * result.get("Body")}); String MediaContentType0 =
		 * result.get("MediaContentType0"); if(MediaContentType0 != null &&
		 * MediaContentType0.trim().length() > 0) { ArrayList<URI> mediaUris = new
		 * ArrayList<URI>(); mediaUris.add(URI.create(result.get("MediaUrl0")));
		 * MessageSender.sendImageMsg("whatsapp:+919573725223", message, mediaUris);
		 * }else { MessageSender.sendMsg("whatsapp:+919573725223", message); } }
		 * 
		 * }catch(Exception ex) { ex.printStackTrace(); }
		 */
		System.out.println(msg);
	}
	@RequestMapping(method = RequestMethod.POST, path = "/statusOfMessage")
	public void statusOfMessage(@RequestBody String msg) {
		System.out.println("statusOfMessage called..");
		/*
		 * try { Map<String, String> result = splitQuery(msg); String SmsStatus =
		 * result.get("SmsStatus"); System.out.println("SmsStatus :: "+SmsStatus);
		 * if("received".equalsIgnoreCase(SmsStatus)) { String fromAddr =
		 * result.get("From"); fromAddr = fromAddr.replace("whatsapp:", ""); String
		 * message = MessageFormat.format(TEMPLATE, new Object[] {fromAddr,
		 * result.get("Body")}); String MediaContentType0 =
		 * result.get("MediaContentType0"); if(MediaContentType0 != null &&
		 * MediaContentType0.trim().length() > 0) { ArrayList<URI> mediaUris = new
		 * ArrayList<URI>(); mediaUris.add(URI.create(result.get("MediaUrl0")));
		 * MessageSender.sendImageMsg("whatsapp:+919573725223", message, mediaUris);
		 * }else { MessageSender.sendMsg("whatsapp:+919573725223", message); } }
		 * 
		 * }catch(Exception ex) { ex.printStackTrace(); }
		 */
		System.out.println(msg);
	}
	@RequestMapping(method = RequestMethod.POST, path = "/paramMessage")
	public void paramMessage(@RequestParam String msg) {
		System.out.println(msg);
	}
	public static Map<String, String> splitQuery(String query) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	    }
	    return query_pairs;
	}
}
