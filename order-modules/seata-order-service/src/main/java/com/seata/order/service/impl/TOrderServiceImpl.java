package com.seata.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.seata.order.service.TAccountService;
import com.seata.order.service.TOrderService;
import com.seata.order.service.TStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.order.mapper.TOrderMapper;
import com.seata.order.domain.TOrder;

@Slf4j
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {
	// 库存
	@Autowired
	private TStorageService storageService;

	// 账户
	@Autowired
	private TAccountService accountService;

	/**
	 * @Date 2023/2/18 22:47
	 * @Description 创建订单
	 * @Param [order]
	 * @return int
	 * @since version-1.0
	 */
	@Override
	public int create(TOrder order) {
		log.info("-------->开始新建订单");
		this.save(order);

		log.info("-------->调用库存扣减");
		storageService.decrease(order.getProductId(),order.getCount());
		log.info("-------->调用库存扣减end");

		log.info("-------->调用账户余额扣减");
		accountService.decrease(order.getUserId(),order.getMoney());
		log.info("-------->调用账户余额扣减end");

		log.info("-------->修改订单状态");
		this.update(
				Wrappers.<TOrder>lambdaUpdate()
						.eq(TOrder::getUserId,order.getUserId())
						.set(TOrder::getStatus,0)
		);
		log.info("-------->修改订单状态end");
		return 1;
	}
}
