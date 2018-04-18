package cn.lvhaosir.mapper;

import cn.lvhaosir.base.BaseMapper;
import cn.lvhaosir.entity.Drivers;

import java.util.List;



public interface DriversMapper extends BaseMapper<Drivers> {
	
	/**
	 * 模糊查询
	 */
	public List<Drivers> queryLike(Drivers driver);
}