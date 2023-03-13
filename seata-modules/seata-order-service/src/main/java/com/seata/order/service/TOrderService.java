package com.seata.order.service;

import com.seata.order.domain.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Date 2023/3/13 10:32
 * @Description 订单
 * @since version-1.0
 */
public interface TOrderService extends IService<TOrder>{

	/**
	 * @Date 2023/2/18 22:47
	 * @Description 创建订单
	 * @Param [order]
	 * @return int
	 * @since version-1.0
	 */
	public int create(TOrder order);
}
