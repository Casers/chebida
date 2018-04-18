package cn.lvhaosir.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


public class BaseServiceImpl<T> implements BaseService<T>{

	@Autowired
	private BaseMapper<T> baseMapper;
	
	
	@Override
	public PageInfo<T> queryPageList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list=baseMapper.selectAll();
		// 用PageInfo对结果进行包装
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}
	
	

	@Override
	public PageInfo<T> queryPageList(Integer pageNum) {
		PageHelper.startPage(pageNum, 5);
		List<T> list=baseMapper.selectAll();
		// 用PageInfo对结果进行包装
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}

	
	@Override
	public PageInfo<T> queryPageListByParam(Integer pageNum, Integer pageSize,T model) {
		PageHelper.startPage(pageNum, pageSize);
		List<T> list=baseMapper.select(model);
		// 用PageInfo对结果进行包装
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}

	@Override
	public PageInfo<T> queryPageListByParam(Integer pageNum,T model) {
		PageHelper.startPage(pageNum, 5);
		List<T> list=baseMapper.select(model);
		// 用PageInfo对结果进行包装
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		return pageInfo;
	}

	@Override
	public List<T> queryAllList() {
		return baseMapper.selectAll();
	}
	
	@Override
	public List<T> queryParamList(Integer pageNum, T model) {
		PageHelper.startPage(pageNum, 5);
		List<T> list=baseMapper.select(model);
		return list;
	}

	@Override
	public List<T> queryParamList(T model) {
		return baseMapper.select(model);
	}

	@Override
	public T queryById(Object id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public T queryByParam(T model) {
		return baseMapper.selectOne(model);
	}

	@Override
	public Integer queryCount(T model) {
		return baseMapper.selectCount(model);
	}

	@Override
	public Integer save(T model) {
		return baseMapper.insert(model);
	}

	@Override
	public Integer saveNoNull(T model) {
		return baseMapper.insertSelective(model);
	}

	@Override
	public Integer deleteByParam(T model) {
		return baseMapper.delete(model);
	}

	@Override
	public Integer delete(Object id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer update(T model) {
		return baseMapper.updateByPrimaryKey(model);
	}

	@Override
	public Integer updateNoNull(T model) {
		return baseMapper.updateByPrimaryKeySelective(model);
	}



	@Override
	public Integer countNumber(T model) {
		// TODO Auto-generated method stub
		return baseMapper.selectCount(model);
	}



	

}
