package cn.lvhaosir.controller;


import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.entity.CarsRepair;
import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.entity.show.CarsRepairShow;
import cn.lvhaosir.service.CarsRepairService;
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
@RequestMapping("/carsRepair")
public class CarsRepairController {

	@Autowired
	private CarsRepairService carsRepairService;
	@Autowired
	private CarsService carsService;
	@Autowired
	private DriversService driversService;

	/**
	 * 根据条件查询所有的 车辆维修保养记录
	 * 
	 * @param carId
	 * @return
	 */
	@RequestMapping(value = "/allCarsRepair", produces = "text/html;charset=UTF-8")
	public ModelAndView queryAllCarsRepair(Integer carId) {
		CarsRepair cr = new CarsRepair();
		cr.setCarId(carId);
		List<CarsRepair> queryParamList = carsRepairService.queryAllOrderby(cr);
		return new ModelAndView("carsRepairList", "CarsRepairList",
				queryParamList);
	}

	/**
	 * 新增 车辆维修保养记录
	 * 
	 * @param carsRepair
	 * @return
	 */
	@RequestMapping(value = "/saveCarsRepair", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveCarsRepair(CarsRepair carsRepair) {
		Integer saveNoNull = carsRepairService.saveNoNull(carsRepair);
		if (saveNoNull > 0)
			return "true";
		return "false";
	}

	/**
	 * 分页查询全部
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/queryAllCarsRepair", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryAllAdvice(Integer page, Integer rows) {
		PageInfo<CarsRepair> queryPageList = carsRepairService.queryPageList(
				page, rows);
		List<CarsRepair> list = queryPageList.getList();
		List<CarsRepairShow> listShow = new ArrayList<CarsRepairShow>();
		for (CarsRepair carsRepair : list) {
			listShow.add(pinJie(carsRepair));
		}
		Integer countNumber = carsRepairService.queryCount(null);
		return new Pager(countNumber, listShow);
	}

	@RequestMapping(value = "/queryLikeAll", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryLikeAll(CarsRepairShow carsRepairShow, Integer page,
			Integer rows) {
		Pager queryLikeAll = carsRepairService.queryLikeAll(carsRepairShow,
				page, rows);
		return queryLikeAll;
	}

	@RequestMapping(value = "/saveUpdateDeleteCarsRepair", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveUpdateDeleteAdvice(CarsRepair carsRepair) {
		Integer saveNoNull = null;
		if (carsRepair.getCarsRepairId() == null) {
			saveNoNull = carsRepairService.saveNoNull(carsRepair);
		} else {
			if (carsRepair.getCarsRepairType() == null) {
				saveNoNull = carsRepairService.delete(carsRepair
						.getCarsRepairId());
			} else {
				saveNoNull = carsRepairService.updateNoNull(carsRepair);
			}
		}
		if (saveNoNull > 0)
			return "true";
		return "false";
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
