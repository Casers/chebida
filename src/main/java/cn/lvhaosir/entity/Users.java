package cn.lvhaosir.entity;

import javax.persistence.*;

@Table(name = "users")
public class Users {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    private String pwd;

    @Column(name = "nick_name")
    private String nickName;
    
    @Column(name = "user_admin")
    private String userAdmin;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    
	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", pwd="
				+ pwd + ", nickName=" + nickName + ", userAdmin=" + userAdmin
				+ "]";
	}

    
}