package cn.lvhaosir.entity.show;

import javax.persistence.Column;

public class CarsMileageShow {

	private Integer carsMileageId;

	private Integer mileage;

	private Integer sales;

	private Integer carId;

	private String createTime;

	private String carNumber;
	
	private String driverName;

	public Integer getCarsMileageId() {
		return carsMileageId;
	}

	public void setCarsMileageId(Integer carsMileageId) {
		this.carsMileageId = carsMileageId;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
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
	
	public CarsMileageShow() {
		super();
	}

	public CarsMileageShow(Integer carsMileageId, Integer mileage,
			Integer sales, Integer carId, String createTime, String carNumber,
			String driverName) {
		super();
		this.carsMileageId = carsMileageId;
		this.mileage = mileage;
		this.sales = sales;
		this.carId = carId;
		this.createTime = createTime;
		this.carNumber = carNumber;
		this.driverName = driverName;
	}

	@Override
	public String toString() {
		return "CarsMileageShow [carsMileageId=" + carsMileageId + ", mileage="
				+ mileage + ", sales=" + sales + ", carId=" + carId
				+ ", createTime=" + createTime + ", carNumber=" + carNumber
				+ ", driverName=" + driverName + "]";
	}
	
	
	
}
