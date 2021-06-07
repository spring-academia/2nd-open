package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.Order;
import com.fastcampus.pickingTDD.Entity.Picker;
import com.fastcampus.pickingTDD.Entity.PickerStateEnum;
import com.fastcampus.pickingTDD.Entity.PickingList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PickerServiceTest {

  @Autowired
  PickerService pickerService ;

  @Test
  public void testAssignPickingList(){
    Picker picker = new Picker();
    picker.setPickerId(1L);
    picker.setState(PickerStateEnum.REST);

    PickingList pickingList = new PickingList();
    pickingList.setOrder(new Order());
    picker = pickerService.assignPickingList(picker, pickingList);

    Assertions.assertEquals(PickerStateEnum.ASSIGNED, picker.getState());
    Assertions.assertNotNull(picker.getAssignedOrder());
    Assertions.assertNotNull(picker.getAssignedPickingList());
    Assertions.assertNotNull(picker.getAssignedPickingList().getPicker());

  }
}
