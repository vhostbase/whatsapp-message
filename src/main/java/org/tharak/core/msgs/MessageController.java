package org.tharak.core.msgs;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	@RequestMapping(method = RequestMethod.POST, path = "/adminMessage")
	public void adminMessage(@RequestBody String msg) {
		System.out.println(msg);
	}
	@RequestMapping(method = RequestMethod.POST, path = "/paramMessage")
	public void paramMessage(@RequestParam String msg) {
		System.out.println(msg);
	}
}
