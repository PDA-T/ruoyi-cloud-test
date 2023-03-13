package com.seata.account.service;

import com.seata.account.domain.TAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * @Date 2023/3/13 18:16
 * @Description 账户
 * @since version-1.0
 */
public interface TAccountService extends IService<TAccount>{

	/**
	 * @Date 2023/3/13 18:17
	 * @Description 减余额
	 * @Param [userId, money]
	 * @return int
	 * @since version-1.0
	 */
	public int decrease(Long userId, BigDecimal money);
}