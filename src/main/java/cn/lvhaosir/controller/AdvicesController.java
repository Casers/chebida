package cn.lvhaosir.controller;


import cn.lvhaosir.entity.Advices;
import cn.lvhaosir.service.AdvicesService;
import cn.lvhaosir.utils.Pager;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/advices")
public class AdvicesController {

	@Autowired
	private AdvicesService advicesService;
	
	/**
	 * 查询全部
	 * @return
	 */
	@RequestMapping(value="/queryAll",produces="text/html;charset=UTF-8")
	public List<Advices> queryAll(){
		return advicesService.queryAllList();
	}
	
	/**
	 * 分页查询全部
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryAllAdvice",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryAllAdvice(Integer page, Integer rows){
		PageInfo<Advices> queryPageList = advicesService.queryPageList(page, rows);
		List<Advices> list = queryPageList.getList();
		Integer countNumber = advicesService.queryCount(null);
		return new Pager(countNumber,list);
	}
	
	
	@RequestMapping(value="/saveUpdateDeleteAdvice",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveUpdateDeleteAdvice(Advices advice){
		Integer saveNoNull =null;
		if(advice.getId()==null){
			advice.setCreateTime(new Date());
			saveNoNull = advicesService.saveNoNull(advice);
		}else{
			if(advice.getTitle()==null){
				saveNoNull =advicesService.delete(advice.getId());
			}else{
				saveNoNull =advicesService.updateNoNull(advice);
			}
		}
		if(saveNoNull >0)
			return "true";
		return "false";
	}
}
