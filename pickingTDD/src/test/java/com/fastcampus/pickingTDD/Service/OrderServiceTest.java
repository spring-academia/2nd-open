package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.Order;
import com.fastcampus.pickingTDD.Entity.OrderDetail;
import com.fastcampus.pickingTDD.Entity.OrderStateEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OrderServiceTest {

  @InjectMocks
  OrderService orderService = new OrderServiceImpl();

  @Mock
  OrderDetailService orderDetailService;

  Order orderSuccess;
  Order orderFail;

  @BeforeEach
  public void orderInit() {
    OrderDetail orderDetail = new OrderDetail();
    orderSuccess = new Order();
    orderSuccess.setOrderId(1L);
    orderSuccess.setState(OrderStateEnum.ORDERED);
    orderSuccess.setOrderDetailList(Arrays.asList(orderDetail));

    orderFail = new Order();
    orderFail.setOrderId(null);
    orderFail.setState(null);
  }

  @Test
  public void testOrderMake_success() {
    Order order = new Order();

    try {
      order = orderService.makeOrder(orderSuccess);
    } catch (Exception e) {
      //donothing
    }
    Assertions.assertEquals(1L, order.getOrderId());
    Assertions.assertEquals(OrderStateEnum.ORDERED, order.getState());
  }

  @Test
  public void testOrderValidation_success() {
    Order order = new Order();
    try {
      order = orderService.makeOrder(orderSuccess);
    } catch (Exception e) {
      fail("should not throw exception");
    }

    Assertions.assertEquals(1L, order.getOrderId());
  }

  @Test
  public void testOrderValidation_fail() {
    Exception e = Assertions.assertThrows(Exception.class, () -> {
      orderService.makeOrder(orderFail);
    });
    Assertions.assertEquals("order validation fail", e.getMessage());
  }

  @Test
  public void testChangeOrderState(){

    orderService.changeOrderState(orderSuccess, OrderStateEnum.LISTMADED);

    Assertions.assertEquals(OrderStateEnum.LISTMADED, orderSuccess.getState());
  }

}

