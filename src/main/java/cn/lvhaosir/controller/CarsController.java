package cn.lvhaosir.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.lvhaosir.entity.Cars;
import cn.lvhaosir.service.CarsService;
import cn.lvhaosir.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/cars")
public class CarsController {

	@Autowired
	private CarsService carsService;
	
	/**
	 * 分页查询所有车辆信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryAllCars",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryAllCars(Integer page, Integer rows){
		PageInfo<Cars> queryPageList = carsService.queryPageList(page, rows);
		List<Cars> list = queryPageList.getList();
		Integer countNumber = carsService.countNumber(null);
		return new Pager(countNumber,list);
	}
	/**
	 * 分页，模糊查询
	 * @param car
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryLikeCars",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryLikeCars(Cars car,Integer page,Integer rows){
		return carsService.queryListCars(car, rows, page);
	}
	
	/**
	 * 新增或修改车辆信息
	 * @param car
	 * @return
	 */
	@RequestMapping(value="/saveUpdateCars",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveUpdateCars(Cars car,@RequestParam MultipartFile carPhoto,HttpServletRequest request){
		String uploadFile = uploadFile(carPhoto,request,car.getEngineNumber());
		car.setPhoto(uploadFile);
		Integer saveNoNull =null;
		if(car.getCarId()==null){
			
			//添加
			car.setCreateTime(new Date());
			saveNoNull=carsService.saveNoNull(car);
		}else{
			//修改
			saveNoNull = carsService.updateNoNull(car);
		}
		if(saveNoNull>0)
			return "true";
		return "false";
	}
	
	/**
	 * 删除司机信息
	 * @param driverId
	 * @return
	 */
	@RequestMapping(value="/deleteCars",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteDrivers(Integer carId){
		//首先去查询是否在使用
		carsService.delete(carId);
		return "true";
	}
	
	@RequestMapping(value="/queryCars",produces="text/html;charset=UTF-8")
	public ModelAndView queryCars(Integer driverId){
		Cars c=new Cars();
		c.setDriverId(driverId);
		Cars queryById=carsService.queryByParam(c);
		return new ModelAndView("car","car",queryById);
	}
	@RequestMapping(value="/queryCarsById",produces="text/html;charset=UTF-8")
	public ModelAndView queryCarsById(Integer carId){
		Cars queryById=carsService.queryById(carId);
		return new ModelAndView("car","car",queryById);
	}
	
	
	@RequestMapping(value="/queryAll",produces="text/html;charset=UTF-8")
	@ResponseBody
	public List<Cars> queryAll(){
		return carsService.queryAllList();
	}
	
	/**
	 * 文件上传
	 * @param file
	 * @param request
	 * @param sellerId
	 * @return
	 */
	private String uploadFile(MultipartFile file, HttpServletRequest request,String engineNumber){
		//传入的是身份证号
		File targetFile = null;
		String substring=null;
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("upload");
			if(path==null){
				path="/yjdata/www/www/chebida/upload";
			}
			String fileName = file.getOriginalFilename();
			int lastIndexOf = fileName.lastIndexOf(".");
			substring = fileName.substring(lastIndexOf);
			targetFile = new File(path, engineNumber+substring);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			file.transferTo(targetFile);
			// request.setAttribute("filePath",targetFile.getAbsolutePath());
		} catch (Exception e) {
		}
		return engineNumber+substring;
	}
	
}
