package com.seata.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.storage.mapper.TStorageMapper;
import com.seata.storage.domain.TStorage;
import com.seata.storage.service.TStorageService;
@Slf4j
@Service
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements TStorageService{

	/**
	 * @Date 2023/3/13 16:00
	 * @Description 减库存
	 * @Param [productId, count]
	 * @return int
	 * @since version-1.0
	 */
	@Override
	public int decrease(Long productId, Integer count) {
		// 当前商品
		LambdaQueryWrapper<TStorage> storageQuery = Wrappers.<TStorage>lambdaQuery()
				.eq(TStorage::getProductId, productId);
		TStorage storage = this.getOne(storageQuery);
		// 修改库存
		log.info("-------->扣减库存");
		LambdaUpdateWrapper<TStorage> storageUpdate = Wrappers.<TStorage>lambdaUpdate()
				.eq(TStorage::getProductId, productId)
				.set(TStorage::getUsed, storage.getUsed() + count)
				.set(TStorage::getResidue, storage.getResidue() - count);
		log.info("-------->扣减库存结束");
		return this.update(storageUpdate) ? 1 : 0;
	}
}
