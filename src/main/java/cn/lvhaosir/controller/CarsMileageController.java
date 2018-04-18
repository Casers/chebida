package cn.lvhaosir.controller;


import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.entity.CarsMileage;
import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.entity.show.CarsMileageShow;
import cn.lvhaosir.service.CarsMileageService;
import cn.lvhaosir.service.CarsService;
import cn.lvhaosir.service.DriversService;
import cn.lvhaosir.utils.Pager;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carsMileage")
public class CarsMileageController {
	
	@Autowired
	private CarsMileageService carsMileageService;
	@Autowired
	private CarsService carsService;
	@Autowired
	private DriversService driversService;
	
	@RequestMapping(value="/saveCarsMileage",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveCarsMileage(CarsMileage carsMileage){
		Integer saveNoNull = carsMileageService.saveNoNull(carsMileage);
		if(saveNoNull>0)
			return "true";
		return "false";
	}
	
	@RequestMapping(value="/queryAllCarsMileage",produces="text/html;charset=UTF-8")
	public ModelAndView queryAllCarsMileage(Integer carId){
		CarsMileage cm=new CarsMileage();
		cm.setCarId(carId);
		List<CarsMileage> queryAllOrderby = carsMileageService.queryAllOrderby(cm);
		return new ModelAndView("carMileageList","CarsMileageList",queryAllOrderby);
	}
	
	/**
	 * 分页查询全部
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryAll(Integer page, Integer rows){
		PageInfo<CarsMileage> queryPageList = carsMileageService.queryPageList(page, rows);
		List<CarsMileage> list = queryPageList.getList();
		List<CarsMileageShow> listShow=new ArrayList<CarsMileageShow>();
		for (CarsMileage carsMileage : list) {
			listShow.add(pingJie(carsMileage));
		}
		Integer countNumber = carsMileageService.queryCount(null);
		return new Pager(countNumber,listShow);
	}
	
	
	@RequestMapping(value="/queryLikeAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryLikeAll(CarsMileageShow carsMileageShow,Integer page,Integer rows){
		Pager queryLikeAll = carsMileageService.queryLikeAll(carsMileageShow,page,rows);
		return queryLikeAll;
	}
	
	@RequestMapping(value="/saveUpdateDeleteCarsMileage",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveUpdateDeleteCarsMileage(CarsMileage carsMileage){
		Integer saveNoNull = null;
		if(carsMileage.getCarsMileageId()==null){
			saveNoNull =carsMileageService.saveNoNull(carsMileage);
		}else{
			if(carsMileage.getCarId()==null){
				saveNoNull = carsMileageService.delete(carsMileage.getCarsMileageId());
			}else{
				saveNoNull = carsMileageService.updateNoNull(carsMileage);
			}
		}
		if(saveNoNull>0)
			return "true";
		return "false";
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
