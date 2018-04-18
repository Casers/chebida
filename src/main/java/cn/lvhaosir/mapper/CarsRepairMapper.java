package cn.lvhaosir.mapper;

import cn.lvhaosir.base.BaseMapper;
import cn.lvhaosir.entity.CarsRepair;

import java.util.List;



public interface CarsRepairMapper extends BaseMapper<CarsRepair> {
	
	/**
	 * 根据 时间排序
	 * @param carsRepair
	 * @return
	 */
	public List<CarsRepair> queryAllOrderby(CarsRepair carsRepair);
	
}