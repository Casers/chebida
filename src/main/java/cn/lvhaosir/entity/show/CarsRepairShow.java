package cn.lvhaosir.entity.show;

import javax.persistence.Column;

public class CarsRepairShow {
	private Integer carsRepairId;

	private String carsRepairType;

	private String carsRepairText;

	private Integer carId;

	private String createTime;

	private String carNumber;

	private String driverName;

	public Integer getCarsRepairId() {
		return carsRepairId;
	}

	public void setCarsRepairId(Integer carsRepairId) {
		this.carsRepairId = carsRepairId;
	}

	public String getCarsRepairType() {
		return carsRepairType;
	}

	public void setCarsRepairType(String carsRepairType) {
		this.carsRepairType = carsRepairType;
	}

	public String getCarsRepairText() {
		return carsRepairText;
	}

	public void setCarsRepairText(String carsRepairText) {
		this.carsRepairText = carsRepairText;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public CarsRepairShow(Integer carsRepairId, String carsRepairType,
			String carsRepairText, Integer carId, String createTime,
			String carNumber, String driverName) {
		super();
		this.carsRepairId = carsRepairId;
		this.carsRepairType = carsRepairType;
		this.carsRepairText = carsRepairText;
		this.carId = carId;
		this.createTime = createTime;
		this.carNumber = carNumber;
		this.driverName = driverName;
	}

	public CarsRepairShow() {
		super();
	}

	@Override
	public String toString() {
		return "CarsRepairShow [carsRepairId=" + carsRepairId
				+ ", carsRepairType=" + carsRepairType + ", carsRepairText="
				+ carsRepairText + ", carId=" + carId + ", createTime="
				+ createTime + ", carNumber=" + carNumber + ", driverName="
				+ driverName + "]";
	}
	
	
}
