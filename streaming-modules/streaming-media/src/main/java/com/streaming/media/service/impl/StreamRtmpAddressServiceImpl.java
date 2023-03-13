package com.streaming.media.service.impl;

import com.streaming.media.service.StreamRtmpAddressService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.streaming.media.mapper.StreamRtmpAddressMapper;
import com.streaming.media.domain.StreamRtmpAddress;

@Service
public class StreamRtmpAddressServiceImpl extends ServiceImpl<StreamRtmpAddressMapper, StreamRtmpAddress> implements StreamRtmpAddressService {
}
