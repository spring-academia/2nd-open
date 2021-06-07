package com.fastcampus.pickingTDD.Service;

import com.fastcampus.pickingTDD.Entity.PickingList;
import com.fastcampus.pickingTDD.Entity.Sku;

public interface PickingService {

  void pick(PickingList pickingList, Sku sku) throws Exception;
}
