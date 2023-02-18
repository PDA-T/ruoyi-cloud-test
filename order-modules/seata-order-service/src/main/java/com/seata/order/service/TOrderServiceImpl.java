package com.seata.order.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seata.order.mapper.TOrderMapper;
import com.seata.order.domain.TOrder;
import com.seata.order.service.impl.TOrderService;
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService{

}
