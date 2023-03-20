package com.streaming.play.service;

import com.streaming.play.domain.StreamRtmpAddress;
import com.baomidou.mybatisplus.extension.service.IService;
public interface StreamRtmpAddressService extends IService<StreamRtmpAddress>{

	/**
	 * @Date 2023/3/20 17:55
	 * @Description 推流视频
	 * @Param [rtmp]
	 * @return com.streaming.play.domain.StreamRtmpAddress
	 * @since version-1.0
	 */
	public StreamRtmpAddress play(StreamRtmpAddress rtmp);
}
