package com.seata.order.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Date 2023/2/18 22:42
 * @Description 库存
 * @since version-1.0
 */
@FeignClient(value = "seata-storage-service",contextId = "storage")
public interface TStorageService {

	/**
	 * @Date 2023/2/18 22:55
	 * @Description 减库存
	 * @Param [productId, count]
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@PutMapping(value = "/storage/decrease")
	public AjaxResult decrease(@RequestParam("productId") Long productId,
							   @RequestParam("count") Integer count);
}
