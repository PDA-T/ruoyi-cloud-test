package com.seata.storage.controller;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.seata.storage.service.TStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2023/3/13 16:08
 * @Description 库存控制器
 * @since version-1.0
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
	// 库存
	@Autowired
	private TStorageService storageService;

	/**
	 * @Date 2023/3/13 16:11
	 * @Description 减库存
	 * @Param [productId, count]
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@RequestMapping(value = "/decrease",method = RequestMethod.PUT)
	public AjaxResult decrease(Long productId,Integer count){
		return AjaxResult.success(storageService.decrease(productId,count));
	}
}
