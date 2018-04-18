package cn.lvhaosir.entity.show;

import java.util.Date;

import javax.persistence.Column;

public class CarsShow {

	private Integer carId;
	/**
	 * 车牌号
	 */
	private String carNumber;
	/**
	 * 发动机号码
	 */
	private String engineNumber;
	/**
	 * 出场时间
	 */
	private String startTime;
	/**
	 * 检修时间
	 */
	private String endTime;
	/**
	 * 
	 */
	private Integer driverId;

	private String createTime;
	
	

}
