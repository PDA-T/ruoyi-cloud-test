package com.streaming.media.controller;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.streaming.media.domain.StreamRtmpAddress;
import com.streaming.media.service.StreamRtmpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Date 2023/2/10 14:41
 * @Description 地址控制器
 * @since version-1.0
 */
@Controller
@RequestMapping("/stream/rtmpAddress")
public class StreamRtmpAddressController {
	// 视频地址
	@Autowired
	private StreamRtmpAddressService streamRtmpAddressService;

	/**
	 * @Date 2023/2/10 14:50
	 * @Description 获取全部地址
	 * @return com.ruoyi.common.core.web.domain.AjaxResult
	 * @since version-1.0
	 */
	@ResponseBody
	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public AjaxResult getAll(){
		List<StreamRtmpAddress> list = streamRtmpAddressService.list();
		return AjaxResult.success(list);
	}
}
