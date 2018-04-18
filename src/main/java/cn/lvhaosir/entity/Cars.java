package cn.lvhaosir.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "cars")
public class Cars {
    @Id
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "engine_number")
    private String engineNumber;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "create_time")
    private Date createTime;

    private String photo;
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
     * @return car_number
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * @param carNumber
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * @return engine_number
     */
    public String getEngineNumber() {
        return engineNumber;
    }

    /**
     * @param engineNumber
     */
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    /**
     * @return start_time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return end_time
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return driver_id
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * @param driverId
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Cars() {
		super();
	}

	public Cars(String carNumber) {
		super();
		this.carNumber = carNumber;
	}

	@Override
	public String toString() {
		return "Cars [carId=" + carId + ", carNumber=" + carNumber
				+ ", engineNumber=" + engineNumber + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", driverId=" + driverId
				+ ", createTime=" + createTime + ", photo=" + photo + "]";
	}

	
    
}