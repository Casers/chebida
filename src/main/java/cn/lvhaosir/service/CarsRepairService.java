package cn.lvhaosir.service;


import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.CarsRepair;
import cn.lvhaosir.entity.show.CarsRepairShow;
import cn.lvhaosir.utils.Pager;

import java.util.List;

public interface CarsRepairService extends BaseService<CarsRepair> {

	/**
	 * 
	 * @param carsRepair
	 * @return
	 */
	public List<CarsRepair> queryAllOrderby(CarsRepair carsRepair);
	
	
	public Pager queryLikeAll(CarsRepairShow carsRepairShow, Integer page, Integer rows);
}
