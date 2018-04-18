package cn.lvhaosir.service;


import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.utils.Pager;

import java.util.List;

public interface DriversService extends BaseService<Drivers> {

	/**
	 * 模糊查询
	 */
	public List<Drivers> queryLike(Drivers driver);
	
	public Pager queryLikeDrivers(Drivers driver, Integer rows, Integer page);
}
