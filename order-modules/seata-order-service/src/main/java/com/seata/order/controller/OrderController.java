package com.seata.order.controller;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.seata.order.domain.TOrder;
import com.seata.order.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Date 2023/2/18 23:06
 * @Description 订单Controller
 * @since version-1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	// 订单
	@Autowired
	private TOrderService orderService;

	/**
	 * @Date 2023/2/18 23:08
	 * @Description 创建订单
	 * @Param [order]
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@ResponseBody
	@GetMapping("/create")
	public AjaxResult create(TOrder order){
		return AjaxResult.success(orderService.create(order));
	}
}
