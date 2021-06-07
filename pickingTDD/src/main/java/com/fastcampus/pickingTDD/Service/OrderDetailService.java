package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {

  OrderDetail makeOrderDetail(OrderDetail orderDetail) throws Exception;
}
