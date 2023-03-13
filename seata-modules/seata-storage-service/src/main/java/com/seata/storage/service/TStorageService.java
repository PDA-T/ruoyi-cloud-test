package com.seata.storage.service;

import com.seata.storage.domain.TStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Date 2023/3/13 15:57
 * @Description 库存
 * @since version-1.0
 */
public interface TStorageService extends IService<TStorage>{

	/**
	 * @Date 2023/3/13 15:59
	 * @Description 减库存
	 * @Param [productId, count]
	 * @return int
	 * @since version-1.0
	 */
	public int decrease(Long productId,Integer count);
}