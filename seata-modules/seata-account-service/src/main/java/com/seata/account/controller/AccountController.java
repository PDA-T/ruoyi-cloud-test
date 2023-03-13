package com.seata.account.controller;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.seata.account.service.TAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Date 2023/3/13 18:31
 * @Description 账户控制器
 * @since version-1.0
 */
@RestController
@RequestMapping("/account")
public class AccountController {
	// 账户
	@Autowired
	private TAccountService accountService;

	/**
	 * @Date 2023/3/13 18:32
	 * @Description 减余额
	 * @Param [userId, money]
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@RequestMapping(value = "/decrease",method = RequestMethod.PUT)
	public AjaxResult decrease(Long userId, BigDecimal money){
		return AjaxResult.success(accountService.decrease(userId,money));
	}
}
