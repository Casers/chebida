package cn.lvhaosir.mapper;



import cn.lvhaosir.base.BaseMapper;
import cn.lvhaosir.entity.Cars;

import java.util.List;

public interface CarsMapper extends BaseMapper<Cars> {
	
	/**
	 * 模糊查询
	 * @param car
	 * @return
	 */
	public List<Cars> queryLike(Cars car);
	
}