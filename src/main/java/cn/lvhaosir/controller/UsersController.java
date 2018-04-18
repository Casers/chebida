package cn.lvhaosir.controller;


import cn.lvhaosir.entity.Users;
import cn.lvhaosir.service.UsersService;
import cn.lvhaosir.utils.Pager;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	/**
	 * 分页查询全部
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/queryAllUsers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public Pager queryAllUsers(Integer page,Integer rows){
		PageInfo<Users> queryPageList = usersService.queryPageList(page, rows);
		List<Users> list = queryPageList.getList();
		Integer countNumber = usersService.queryCount(null);
		return new Pager(countNumber,list);
	}
	
	@RequestMapping(value="/saveUpdateDeleteUsers",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String saveUpdateDeleteUsers(Users user){
		Integer saveNoNull =null;
		if(user.getUserId()==null){
			Users u=new Users();
			u.setUserName(user.getUserName());
			Users queryByParam = usersService.queryByParam(u);
			if(queryByParam==null){
				saveNoNull = usersService.saveNoNull(user);
			}else{
				return "yicunzai";
			}
		}else{
			if(user.getUserName()==null){
				saveNoNull =usersService.delete(user.getUserId());
			}else{
				Users u=new Users();
				u.setUserName(user.getUserName());
				Users queryByParam = usersService.queryByParam(u);
				if(queryByParam==null || queryByParam.getUserId()==user.getUserId() ){
					saveNoNull =usersService.updateNoNull(user);
				}else{
					return "yicunzai";
				}
			}
		}
		if(saveNoNull >0)
			return "true";
		return "false";
	}
	
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(Users user,HttpSession session){
		Users queryByParam = usersService.queryByParam(user);
		if(queryByParam==null){
			return "false";
		}else{
			session.setAttribute("loginNickName", queryByParam.getNickName());
			session.setAttribute("userAdmin", queryByParam.getUserAdmin());
			return "true";
		}
	}
	@RequestMapping(value="/outLogin",produces="text/html;charset=UTF-8")
	public String outLogin(HttpSession session){
		session.removeAttribute("loginNickName");
		return "redirect:/login.action";
	}
}
