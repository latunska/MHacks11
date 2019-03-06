package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.*;

public class MyService {



	public String someRestCall(String name) {
		return name;
	}

}
