package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.Order;
import com.fastcampus.pickingTDD.Entity.OrderStateEnum;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

  Order makeOrder(Order order) throws Exception;
  void changeOrderState(Order order, OrderStateEnum state);
}
