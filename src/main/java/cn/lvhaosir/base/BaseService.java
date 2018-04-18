package cn.lvhaosir.base;

import java.util.List;

import com.github.pagehelper.PageInfo;

public interface BaseService<T> {
	/**
	 * @功能:分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<T> queryPageList(Integer pageNum, Integer pageSize);
	
	/**
	 * @功能:分页查询（默认pageSize）
	 * @param pageNum
	 * @return
	 */
	public PageInfo<T> queryPageList(Integer pageNum);
	
	/**
	 * @功能:条件参数分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param model
	 * @return
	 */
	public PageInfo<T> queryPageListByParam(Integer pageNum, Integer pageSize, T model);
	/**
	 * @功能:条件参数分页查询（默认pageSize）
	 * @param pageNum
	 * @param model
	 * @return
	 */
	public PageInfo<T> queryPageListByParam(Integer pageNum, T model);
	/**
	 * @功能:查询所有
	 * @return
	 */
	public List<T> queryAllList();
	
	/**
	 * @功能:带有条件参数的数据查询
	 * @param pageNum
	 * @param model
	 * @return
	 */
	public List<T> queryParamList(Integer pageNum, T model);
	/**
	 * @功能:带有条件参数的查询
	 * @param model
	 * @return
	 */
	public List<T> queryParamList(T model);

	/**
	 * @功能:查询单个实体类
	 * @param id
	 * @return
	 */
	public T queryById(Object id);
	
	/**
	 * @功能:带有条件参数单个实体类的查询
	 * @param model
	 * @return
	 */
	public T queryByParam(T model);
	/**
	 * @功能:根据实体中的属性查询总数
	 * @param model
	 * @return
	 */
	public Integer queryCount(T model);
	/**
	 * @功能:保存 null的属性也会保存，不会使用数据库默认值
	 * @param model
	 * @return
	 */
	public Integer save(T model);
	/**
	 * @功能:保存一个实体，null的属性不会保存，会使用数据库默认值
	 * @param model
	 * @return
	 */
	public Integer saveNoNull(T model);
	/**
	 * @功能:根据实体属性作为条件进行删除
	 * @param model
	 * @return
	 */
	public Integer deleteByParam(T model);
	
	/**
	 * @功能:根据主键字段进行删除
	 * @param key
	 * @return
	 */
	public Integer delete(Object id);
	/**
	 * @功能:根据主键更新实体全部字段，null值会被更新
	 * @param model
	 * @return
	 */
	public Integer update(T model);
	/**
	 * @功能:根据主键更新属性不为null的值
	 * @param model
	 * @return
	 */
	public Integer updateNoNull(T model);
	
	public Integer countNumber(T model);
}
