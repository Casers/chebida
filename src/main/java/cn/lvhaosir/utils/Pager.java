package cn.lvhaosir.utils;
/**
 * 为了完成easyui datagrid 的分页
 *
 */
public class Pager {
	private int total;  
    private Object rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}
	public void setRows(Object rows) {
		this.rows = rows;
	}
	public Pager(int total, Object rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public Pager() {
		super();
	}
	@Override
	public String toString() {
		return "Pager [total=" + total + ", rows=" + rows + "]";
	}
    
}
