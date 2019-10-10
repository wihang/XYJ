package com.xiaoyingjie.web.async;

import org.springframework.stereotype.Component;

@Component
public class MockQueue {
	private String placeQrder;
	private String complateOrder;
	public String getPlaceQrder() {
		return placeQrder;
	}
	public void setPlaceQrder(String placeQrder) throws Exception {
		System.out.println("接到下单请求" + placeQrder);
		Thread.sleep(1000);
		this.complateOrder = placeQrder;
		System.out.println("下单请求处理完毕" + placeQrder);
	}
	public String getComplateOrder() {
		return complateOrder;
	}
	public void setComplateOrder(String complateOrder) {
		this.complateOrder = complateOrder;
	}
	
	
}
