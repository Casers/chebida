package cn.lvhaosir.entity;

import java.util.Date;

import javax.persistence.*;

@Table(name = "cars_mileage")
public class CarsMileage {
    @Id
    @Column(name = "cars_mileage_id")
    private Integer carsMileageId;

    private Integer mileage;

    private Integer sales;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "create_time")
    private String createTime;

    /**
     * @return cars_mileage_id
     */
    public Integer getCarsMileageId() {
        return carsMileageId;
    }

    /**
     * @param carsMileageId
     */
    public void setCarsMileageId(Integer carsMileageId) {
        this.carsMileageId = carsMileageId;
    }

    /**
     * @return mileage
     */
    public Integer getMileage() {
        return mileage;
    }

    /**
     * @param mileage
     */
    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    /**
     * @return sales
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * @param sales
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * @return car_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * @return create_time
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    
    
	public CarsMileage() {
		super();
	}

	public CarsMileage(Integer carsMileageId, Integer mileage, Integer sales,
			Integer carId, String createTime) {
		super();
		this.carsMileageId = carsMileageId;
		this.mileage = mileage;
		this.sales = sales;
		this.carId = carId;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "CarsMileage [carsMileageId=" + carsMileageId + ", mileage="
				+ mileage + ", sales=" + sales + ", carId=" + carId
				+ ", createTime=" + createTime + "]";
	}
    
    
    
}