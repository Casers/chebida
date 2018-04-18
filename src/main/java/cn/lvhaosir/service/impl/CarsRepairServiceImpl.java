package cn.lvhaosir.service.impl;


import cn.lvhaosir.base.BaseServiceImpl;
import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.entity.CarsRepair;
import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.entity.show.CarsRepairShow;
import cn.lvhaosir.mapper.CarsMapper;
import cn.lvhaosir.mapper.CarsRepairMapper;
import cn.lvhaosir.mapper.DriversMapper;
import cn.lvhaosir.service.CarsRepairService;
import cn.lvhaosir.service.CarsService;
import cn.lvhaosir.service.DriversService;
import cn.lvhaosir.utils.ChebidaUtil;
import cn.lvhaosir.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CarsRepairService")
public class CarsRepairServiceImpl extends BaseServiceImpl<CarsRepair>
		implements CarsRepairService {

	@Autowired
	private CarsRepairMapper carsRepairMapper;
	@Autowired
	private CarsMapper carsMapper;
	@Autowired
	private DriversMapper driversMapper;
	@Autowired
	private CarsService carsService;
	@Autowired
	private DriversService driversService;

	@Override
	public List<CarsRepair> queryAllOrderby(CarsRepair carsRepair) {
		// TODO Auto-generated method stub
		return carsRepairMapper.queryAllOrderby(carsRepair);
	}


	@Override
	public Pager queryLikeAll(CarsRepairShow carsRepairShow, Integer page,
							  Integer rows) {
		try {
			CarsRepair cr=new CarsRepair();
			List<CarsRepair> queryParamList=new ArrayList<CarsRepair>();
			String carNumber = carsRepairShow.getCarNumber();
			if(carNumber!=null){
				//部署到服务器上时，不需要转码。在本机时需要转码
				//String changeCharset = ChebidaUtil.changeCharset(carNumber);
				//改一下
				//List<Cars> queryLike = carsMapper.queryLike(new Cars(changeCharset));
				List<Cars> queryLike = carsMapper.queryLike(new Cars(carNumber));
				for (Cars cars : queryLike) {
					cr.setCarId(cars.getCarId());
					queryParamList.addAll(queryParamList(cr));
				}
			}
			String driverName = carsRepairShow.getDriverName();
			if(driverName!=null){
				//部署到服务器上时，不需要转码。在本机时需要转码
				String changeCharset = ChebidaUtil.changeCharset(driverName);
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
						cr.setCarId(cars.getCarId());
						queryParamList.addAll(queryParamList(cr));
					}
				}
			}
			int countNumber = queryParamList.size();
			//起始行数，
			int start=(page-1)*rows;
			// 结束索引  
			int end=start+rows>countNumber?countNumber :start+rows; 
			List<CarsRepair> subList = null;
			if(end<start){
				subList = queryParamList.subList(0, end);
			}else{
				subList = queryParamList.subList(start, end);
			}
			
			List<CarsRepairShow> list=new ArrayList<CarsRepairShow>();
			for (CarsRepair carsRepair : subList) {
				list.add(pinJie(carsRepair));
			}
			return new Pager(countNumber,list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	private CarsRepairShow pinJie(CarsRepair carsRepair) {
		Integer carId = carsRepair.getCarId();
		CarsRepairShow crs = new CarsRepairShow();
		if(carId==null){
			crs = new CarsRepairShow(carsRepair.getCarsRepairId(),
					carsRepair.getCarsRepairType(),
					carsRepair.getCarsRepairText(), carsRepair.getCarId(),
					carsRepair.getCreateTime(), "信息失踪了", "信息失踪了");
		}else{
			Cars queryById = carsService.queryById(carId);
			if(queryById==null){
				crs = new CarsRepairShow(carsRepair.getCarsRepairId(),
						carsRepair.getCarsRepairType(),
						carsRepair.getCarsRepairText(), carsRepair.getCarId(),
						carsRepair.getCreateTime(), "信息失踪了", "信息失踪了");
			}else{
				Integer driverId = queryById.getDriverId();
				if(driverId==null){
					crs = new CarsRepairShow(carsRepair.getCarsRepairId(),
							carsRepair.getCarsRepairType(),
							carsRepair.getCarsRepairText(), carsRepair.getCarId(),
							carsRepair.getCreateTime(), queryById.getCarNumber(),
							"信息失踪了");
				}else{
					Drivers queryById2 = driversService.queryById(driverId);
					if(queryById2==null){
						crs = new CarsRepairShow(carsRepair.getCarsRepairId(),
								carsRepair.getCarsRepairType(),
								carsRepair.getCarsRepairText(), carsRepair.getCarId(),
								carsRepair.getCreateTime(), queryById.getCarNumber(),
								"信息失踪了");
					}else{
						crs = new CarsRepairShow(carsRepair.getCarsRepairId(),
								carsRepair.getCarsRepairType(),
								carsRepair.getCarsRepairText(), carsRepair.getCarId(),
								carsRepair.getCreateTime(), queryById.getCarNumber(),
								queryById2.getDriverName());
					}
				}
			}
		}
		return crs;
	}

}
