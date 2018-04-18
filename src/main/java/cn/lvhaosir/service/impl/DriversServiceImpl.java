package cn.lvhaosir.service.impl;


import cn.lvhaosir.base.BaseServiceImpl;
import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.mapper.DriversMapper;
import cn.lvhaosir.service.DriversService;
import cn.lvhaosir.utils.ChebidaUtil;
import cn.lvhaosir.utils.Pager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DriversService")
public class DriversServiceImpl extends BaseServiceImpl<Drivers> implements DriversService {

	
	private Logger log=Logger.getLogger(DriversServiceImpl.class.getName());
	
	@Autowired
	private DriversMapper driversMapper;
	
	@Override
	public List<Drivers> queryLike(Drivers driver) {
		// TODO Auto-generated method stub
		return driversMapper.queryLike(driver);
	}

	@Override
	public Pager queryLikeDrivers(Drivers driver, Integer rows, Integer page) {
		//部署到服务器上时，不需要转码。在本机时需要转码
		//changeCharset(driver);
		List<Drivers> queryLike = this.queryLike(driver);
		int countNumber = queryLike.size();
		// 起始行数，
		int start = (page - 1) * rows;
		// 结束索引
		int end = start + rows > countNumber ? countNumber : start + rows;
		List<Drivers> subList =null;
		if(end<start){
			subList = queryLike.subList(0, end);
		}else{
			subList = queryLike.subList(start, end);
		}
		return new Pager(countNumber,subList);
	}
	
	
	private void changeCharset(Drivers driver){
		try {
			if(driver.getDriverName()!=null){
				driver.setDriverName(ChebidaUtil.changeCharset(driver.getDriverName()));
			}
		} catch (Exception e) {
		}
		
	}
	

}
