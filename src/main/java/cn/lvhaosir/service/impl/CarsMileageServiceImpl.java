package cn.lvhaosir.service.impl;


import cn.lvhaosir.base.BaseServiceImpl;
import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.entity.CarsMileage;
import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.entity.show.CarsMileageShow;
import cn.lvhaosir.mapper.CarsMapper;
import cn.lvhaosir.mapper.CarsMileageMapper;
import cn.lvhaosir.mapper.DriversMapper;
import cn.lvhaosir.service.CarsMileageService;
import cn.lvhaosir.service.CarsService;
import cn.lvhaosir.service.DriversService;
import cn.lvhaosir.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CarsMileageService")
public class CarsMileageServiceImpl extends BaseServiceImpl<CarsMileage> implements CarsMileageService {

	
	@Autowired
	private CarsMileageMapper carsMileageMapper;
	@Autowired
	private CarsMapper carsMapper;
	@Autowired
	private DriversMapper driversMapper;
	@Autowired
	private CarsService carsService;
	@Autowired
	private DriversService driversService;
	
	
	@Override
	public List<CarsMileage> queryAllOrderby(CarsMileage carsMileage) {
		return carsMileageMapper.queryAllOrderby(carsMileage);
	}

	@Override
	public Pager queryLikeAll(CarsMileageShow carsMileageShow, Integer page,
							  Integer rows) {
		try {
			CarsMileage cm=new CarsMileage();
			List<CarsMileage> queryParamList =new ArrayList<CarsMileage>();
			String carNumber = carsMileageShow.getCarNumber();
			if(carNumber!=null ){
				//部署到服务器上时，不需要转码。在本机时需要转码
				//String changeCharset = ChebidaUtil.changeCharset(carNumber);
				//改一下
				//List<Cars> queryLike = carsMapper.queryLike(new Cars(changeCharset));
				List<Cars> queryLike = carsMapper.queryLike(new Cars(carNumber));
				for (Cars cars : queryLike) {
					cm.setCarId(cars.getCarId());
					queryParamList.addAll(queryParamList(cm));
				}
			}
			String driverName = carsMileageShow.getDriverName();
			if(driverName!=null ){
				//部署到服务器上时，不需要转码。在本机时需要转码
				//String changeCharset = ChebidaUtil.changeCharset(driverName);
				Drivers drivers = new Drivers();
				//改一下
				//drivers.setDriverName(changeCharset);
				drivers.setDriverName(driverName);
				List<Drivers> queryLike = driversMapper.queryLike(drivers);
				for (Drivers drivers2 : queryLike) {
					Integer driverId = drivers2.getDriverId();
					Cars cs=new Cars();
					cs.setDriverId(driverId);
					List<Cars> queryParamList2 = carsService.queryParamList(cs);
					for (Cars cars : queryParamList2) {
						cm.setCarId(cars.getCarId());
						queryParamList.addAll(queryParamList(cm));
					}
				}
			}
			if(carNumber==null && driverName==null){
				queryParamList=queryAllList();
			}
			int countNumber = queryParamList.size();
			//起始行数，
			int start=(page-1)*rows;
			// 结束索引  
			int end=start+rows>countNumber?countNumber :start+rows; 
			List<CarsMileage> subList = null;
			if(end<start){
				subList = queryParamList.subList(0, end);
			}else{
				subList = queryParamList.subList(start, end);
			}
			List<CarsMileageShow> list=new ArrayList<CarsMileageShow>();
			for (CarsMileage carsMileage : subList) {
				list.add(pingJie(carsMileage));
			}
			return new Pager(countNumber,list);
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	private CarsMileageShow pingJie(CarsMileage carsMileage) {
		CarsMileageShow cms = new CarsMileageShow();
		Integer carId = carsMileage.getCarId();
		if(carId==null){
			cms = new CarsMileageShow(
					carsMileage.getCarsMileageId(), carsMileage.getMileage(),
					carsMileage.getSales(), carsMileage.getCarId(),
					carsMileage.getCreateTime(), "信息失踪了", "信息失踪了");
		}else{
			Cars queryById = carsService.queryById(carId);
			if(queryById==null){
				cms = new CarsMileageShow(
						carsMileage.getCarsMileageId(), carsMileage.getMileage(),
						carsMileage.getSales(), carsMileage.getCarId(),
						carsMileage.getCreateTime(), "信息失踪了", "信息失踪了");
			}else{
				Integer driverId = queryById.getDriverId();
				if(driverId==null){
					cms = new CarsMileageShow(
							carsMileage.getCarsMileageId(), carsMileage.getMileage(),
							carsMileage.getSales(), carsMileage.getCarId(),
							carsMileage.getCreateTime(), queryById.getCarNumber(),
							"信息失踪了");
				}else{
					Drivers queryById2 = driversService.queryById(driverId);
					if(queryById2==null){
						cms = new CarsMileageShow(
								carsMileage.getCarsMileageId(), carsMileage.getMileage(),
								carsMileage.getSales(), carsMileage.getCarId(),
								carsMileage.getCreateTime(), queryById.getCarNumber(),
								"信息失踪了");
					}else{
						cms = new CarsMileageShow(
								carsMileage.getCarsMileageId(), carsMileage.getMileage(),
								carsMileage.getSales(), carsMileage.getCarId(),
								carsMileage.getCreateTime(), queryById.getCarNumber(),
								queryById2.getDriverName());
					}
				}
				
			}
		}
		return cms;
	}
}
