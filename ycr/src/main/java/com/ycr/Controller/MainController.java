package com.ycr.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


	@GetMapping(value="/index")
	public String toIndex() {
		return "index";
    }

    @GetMapping(value="/create")
	public String toCreate() {
		return "create";
    }
    

	

}