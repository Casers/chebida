package cn.lvhaosir.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "cars_repair")
public class CarsRepair {
    @Id
    @Column(name = "cars_repair_id")
    private Integer carsRepairId;

    @Column(name = "cars_repair_type")
    private String carsRepairType;

    @Column(name = "cars_repair_text")
    private String carsRepairText;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "create_time")
    private String createTime;

    /**
     * @return cars_repair_id
     */
    public Integer getCarsRepairId() {
        return carsRepairId;
    }

    /**
     * @param carsRepairId
     */
    public void setCarsRepairId(Integer carsRepairId) {
        this.carsRepairId = carsRepairId;
    }

    /**
     * @return cars_repair_type
     */
    public String getCarsRepairType() {
        return carsRepairType;
    }

    /**
     * @param carsRepairType
     */
    public void setCarsRepairType(String carsRepairType) {
        this.carsRepairType = carsRepairType;
    }

    /**
     * @return cars_repair_text
     */
    public String getCarsRepairText() {
        return carsRepairText;
    }

    /**
     * @param carsRepairText
     */
    public void setCarsRepairText(String carsRepairText) {
        this.carsRepairText = carsRepairText;
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

	@Override
	public String toString() {
		return "CarsRepair [carsRepairId=" + carsRepairId + ", carsRepairType="
				+ carsRepairType + ", carsRepairText=" + carsRepairText
				+ ", carId=" + carId + ", createTime=" + createTime + "]";
	}
    
    
}