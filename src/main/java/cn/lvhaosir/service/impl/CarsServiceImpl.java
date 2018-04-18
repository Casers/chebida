package cn.lvhaosir.service.impl;

import cn.lvhaosir.base.BaseServiceImpl;
import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.mapper.CarsMapper;
import cn.lvhaosir.service.CarsService;
import cn.lvhaosir.utils.ChebidaUtil;
import cn.lvhaosir.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("CarsService")
public class CarsServiceImpl extends BaseServiceImpl<Cars> implements CarsService {
	
	@Autowired
	private CarsMapper carsMapper;

	@Override
	public List<Cars> queryList(Cars car) {
		// TODO Auto-generated method stub
		return carsMapper.queryLike(car);
	}

	@Override
	public Pager queryListCars(Cars car, Integer rows, Integer page) {
		//部署到服务器上时，不需要转码。在本机时需要转码
		//changeCharset(car);
		List<Cars> queryList = carsMapper.queryLike(car);
		int countNumber = queryList.size();
		// 起始行数，
		int start = (page - 1) * rows;
		// 结束索引
		int end = start + rows > countNumber ? countNumber : start + rows;
		List<Cars> subList = null;
		if(end<start){
			subList = queryList.subList(0, end);
		}else{
			subList = queryList.subList(start, end);
		}
		return new Pager(countNumber,subList);
	}
	
	private void changeCharset(Cars car){
		try {
			if(car.getCarNumber()!=null){
				car.setCarNumber(ChebidaUtil.changeCharset(car.getCarNumber()));
			}
		} catch (Exception e) {
		}
		
	}
	
}
