package com.babify.infra.productorders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductOrdersController {

	@Autowired
	ProductOrdersService service;
}
