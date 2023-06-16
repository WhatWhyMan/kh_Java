package kh.lclass.openapi.controller;

import kh.lclass.openapi.model.service.EvInfoService;

public class EvInfoController {
	public void getEvInfoAll() {
		EvInfoService service = new EvInfoService();
		service.start();
	}
}
