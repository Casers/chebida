package cn.lvhaosir.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "drivers")
public class Drivers {
    @Id
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "driver_name")
    private String driverName;

    private Integer age;

    private String sex;

    @Column(name = "driver_age")
    private Integer driverAge;

    private String phone;

    @Column(name = "id_card")
    private String idCard;

    private String address;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;
    
    @Column(name = "status")
    private String status;
    
    private String photo;

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
     * @return driver_name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return driver_age
     */
    public Integer getDriverAge() {
        return driverAge;
    }

    /**
     * @param driverAge
     */
    public void setDriverAge(Integer driverAge) {
        this.driverAge = driverAge;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return id_card
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
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

    
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Drivers [driverId=" + driverId + ", driverName=" + driverName
				+ ", age=" + age + ", sex=" + sex + ", driverAge=" + driverAge
				+ ", phone=" + phone + ", idCard=" + idCard + ", address="
				+ address + ", createTime=" + createTime + ", status=" + status
				+ ", photo=" + photo + "]";
	}

}