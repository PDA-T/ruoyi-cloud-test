package com.seata.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.account.domain.TAccount;
import com.seata.account.mapper.TAccountMapper;
import com.seata.account.service.TAccountService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService{

	/**
	 * @Date 2023/3/13 18:18
	 * @Description 减余额
	 * @Param [userId, money]
	 * @return int
	 * @since version-1.0
	 */
	@Override
	@Transactional
	public int decrease(Long userId, BigDecimal money) {
		// 查找用户
		LambdaQueryWrapper<TAccount> accountQuery = Wrappers.<TAccount>lambdaQuery()
				.eq(TAccount::getUserId, userId);
		TAccount account = this.getOne(accountQuery);
		BigDecimal used = BigDecimal.valueOf(account.getUsed());
		BigDecimal residue = BigDecimal.valueOf(account.getResidue());
		// 修改余额
		log.info("-------->修改余额");
		LambdaUpdateWrapper<TAccount> accountUpdate = Wrappers.<TAccount>lambdaUpdate()
				.eq(TAccount::getUserId, userId)
				.set(TAccount::getResidue, residue.subtract(money))
				.set(TAccount::getUsed, used.add(money));
		log.info("-------->修改余额结束");
		return this.update(accountUpdate) ? 1: 0;
	}
}
