package cn.lvhaosir.controller;


import cn.lvhaosir.entity.Drivers;
import cn.lvhaosir.service.DriversService;
import cn.lvhaosir.utils.Pager;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/drivers")
public class DriversController {
	
	
	private Logger log=Logger.getLogger(DriversController.class.getName());
	
	@Autowired
	private DriversService driversService;
	
	/**
	 * 分页查询，所有司机信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryAllDrivers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryAllDrivers(Integer page, Integer rows){
		PageInfo<Drivers> queryPageList = driversService.queryPageList(page, rows);
		List<Drivers> list = queryPageList.getList();
		Integer queryCount = driversService.queryCount(null);
		return new Pager(queryCount,list);
	}
	
	/**
	 * 模糊查询
	 * @param driver
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryLikeDrivers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryLikeDrivers(Drivers driver,Integer page,Integer rows){
		return driversService.queryLikeDrivers(driver, rows, page);
	}
	
	/**
	 * 添加司机信息与更新司机信息
	 * @param driver
	 * @return
	 */
	@RequestMapping(value="/saveUpdateDrivers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveUpdateDrivers(Drivers driver, @RequestParam MultipartFile filePhoto, HttpServletRequest request){
		Integer saveNoNull =null;
		String uploadFile = uploadFile(filePhoto,request,driver.getIdCard());
		driver.setPhoto(uploadFile);
		if(driver.getDriverId()==null){
			driver.setCreateTime(new Date());
			saveNoNull = driversService.saveNoNull(driver);
		}else{
			saveNoNull =driversService.updateNoNull(driver);
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
	@RequestMapping(value="/deleteDrivers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String deleteDrivers(Integer driverId){
		//首先去查询是否在使用
		driversService.delete(driverId);
		return "true";
	}
	
	/**
	 * 为下拉列表提供数据
	 * @return
	 */
	@RequestMapping(value="/allDrivers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public List<Drivers> allDriver(){
		return driversService.queryAllList();
	}
	
	/**
	 * 展示  司机个人信息
	 * @param driverId
	 * @return
	 */
	@RequestMapping(value="/queryDriver",produces="text/html;charset=UTF-8")
	public ModelAndView queryDrivers(Integer driverId){
		Drivers queryById = driversService.queryById(driverId);
		return new ModelAndView("driver","driver",queryById);
	}
	
	
	/**
	 * 文件上传
	 * @param file
	 * @param request
	 * @param sellerId
	 * @return
	 */
	private String uploadFile(MultipartFile file, HttpServletRequest request, String idCard){
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
			targetFile = new File(path, idCard+substring);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			file.transferTo(targetFile);
			// request.setAttribute("filePath",targetFile.getAbsolutePath());
		} catch (Exception e) {
		}
		return idCard+substring;
	}
}
