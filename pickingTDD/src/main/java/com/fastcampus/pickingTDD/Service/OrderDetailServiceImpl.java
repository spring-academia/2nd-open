package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
  @Override
  public OrderDetail makeOrderDetail(OrderDetail orderDetail) throws Exception {
    if(orderDetailValidation(orderDetail)){
      //dosomething
      return orderDetail;
    } else {
      throw new Exception("orderDetail validation fail");
    }

  }

  private boolean orderDetailValidation(OrderDetail orderDetail){
    if(orderDetail.getOrderId() == null){
      return false;
    }
    if(orderDetail.getSku() == null){
      return false;
    }
    if(orderDetail.getAmount() < 1){
      return false;
    }

    return true;
  }
}
