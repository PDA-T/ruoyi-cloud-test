package com.streaming.media.service;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.streaming.media.mapper.StreamRtmpAddressMapper;
import com.streaming.media.domain.StreamRtmpAddress;
import com.streaming.media.service.impl.StreamRtmpAddressService;
@Service
public class StreamRtmpAddressServiceImpl extends ServiceImpl<StreamRtmpAddressMapper, StreamRtmpAddress> implements StreamRtmpAddressService{

}
