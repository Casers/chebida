package cn.lvhaosir.mapper;



import cn.lvhaosir.base.BaseMapper;
import cn.lvhaosir.entity.CarsMileage;

import java.util.List;

public interface CarsMileageMapper extends BaseMapper<CarsMileage> {
	
	/**
	 * 根据 时间排序
	 * @param CarsMileage
	 * @return
	 */
	public List<CarsMileage> queryAllOrderby(CarsMileage carsMileage);
	
	
}