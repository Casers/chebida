package cn.lvhaosir.service;


import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.utils.Pager;

import java.util.List;

public interface CarsService extends BaseService<Cars> {

	/**
	 * 模糊查询
	 * @param car
	 * @return
	 */
	public List<Cars> queryList(Cars car);
	
	/**
	 * 模糊查询 ，分页
	 * @param car
	 * @param rows
	 * @param page
	 * @return
	 */
	public Pager queryListCars(Cars car, Integer rows, Integer page);
}
