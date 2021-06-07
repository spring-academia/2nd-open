package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.Order;
import com.fastcampus.pickingTDD.Entity.Picker;
import com.fastcampus.pickingTDD.Entity.PickingList;

public interface PickingListService {

  PickingList makePickingList(Order order);

  PickingList assignPicker(PickingList pickingList, Picker picker);
}
