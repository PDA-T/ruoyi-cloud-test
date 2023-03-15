package com.seata.order.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Date 2023/2/18 22:41
 * @Description 账户
 * @since version-1.0
 */
@FeignClient(value = "seata-account-service",contextId = "account")
public interface TAccountService {

	/**
	 * @Date 2023/2/18 23:00
	 * @Description 账户减余额
	 * @Param [userId, money]
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@PostMapping(value = "/account/decrease")
	public AjaxResult decrease(@RequestParam("userId") Long userId,
							   @RequestParam("money") BigDecimal money);
}
