package cn.lvhaosir.service;


import cn.lvhaosir.base.BaseService;
import cn.lvhaosir.entity.CarsMileage;
import cn.lvhaosir.entity.show.CarsMileageShow;
import cn.lvhaosir.utils.Pager;

import java.util.List;

public interface CarsMileageService extends BaseService<CarsMileage> {
	/**
	 * 根据 时间排序
	 * @param CarsMileage
	 * @return
	 */
	public List<CarsMileage> queryAllOrderby(CarsMileage carsMileage);
	
	
	public Pager queryLikeAll(CarsMileageShow carsMileageShow, Integer page, Integer rows);
}
