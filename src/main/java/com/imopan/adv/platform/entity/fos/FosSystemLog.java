package com.imopan.adv.platform.entity.fos;

import com.imopan.adv.platform.common.BaseBean;
import java.io.Serializable;
import java.util.Date;

public class FosSystemLog extends BaseBean implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.ID
	 * @mbggenerated
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.USER_ID
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.USER_NAME
	 * @mbggenerated
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.EMAIL
	 * @mbggenerated
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.PHONE
	 * @mbggenerated
	 */
	private String phone;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.TRUE_NAME
	 * @mbggenerated
	 */
	private String trueName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.ROLE_ID
	 * @mbggenerated
	 */
	private Integer roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.ROLE_NAME
	 * @mbggenerated
	 */
	private String roleName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.DATE_TIME
	 * @mbggenerated
	 */
	private Date dateTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.TABLE_NAME
	 * @mbggenerated
	 */
	private String tableName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.TABLE_COLUMN
	 * @mbggenerated
	 */
	private String tableColumn;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.TABLE_VALUE
	 * @mbggenerated
	 */
	private String tableValue;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column fos_system_log.CONTENT
	 * @mbggenerated
	 */
	private String content;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table fos_system_log
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.ID
	 * @return  the value of fos_system_log.ID
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.ID
	 * @param id  the value for fos_system_log.ID
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.USER_ID
	 * @return  the value of fos_system_log.USER_ID
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.USER_ID
	 * @param userId  the value for fos_system_log.USER_ID
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.USER_NAME
	 * @return  the value of fos_system_log.USER_NAME
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.USER_NAME
	 * @param userName  the value for fos_system_log.USER_NAME
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.EMAIL
	 * @return  the value of fos_system_log.EMAIL
	 * @mbggenerated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.EMAIL
	 * @param email  the value for fos_system_log.EMAIL
	 * @mbggenerated
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.PHONE
	 * @return  the value of fos_system_log.PHONE
	 * @mbggenerated
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.PHONE
	 * @param phone  the value for fos_system_log.PHONE
	 * @mbggenerated
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.TRUE_NAME
	 * @return  the value of fos_system_log.TRUE_NAME
	 * @mbggenerated
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.TRUE_NAME
	 * @param trueName  the value for fos_system_log.TRUE_NAME
	 * @mbggenerated
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName == null ? null : trueName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.ROLE_ID
	 * @return  the value of fos_system_log.ROLE_ID
	 * @mbggenerated
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.ROLE_ID
	 * @param roleId  the value for fos_system_log.ROLE_ID
	 * @mbggenerated
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.ROLE_NAME
	 * @return  the value of fos_system_log.ROLE_NAME
	 * @mbggenerated
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.ROLE_NAME
	 * @param roleName  the value for fos_system_log.ROLE_NAME
	 * @mbggenerated
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.DATE_TIME
	 * @return  the value of fos_system_log.DATE_TIME
	 * @mbggenerated
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.DATE_TIME
	 * @param dateTime  the value for fos_system_log.DATE_TIME
	 * @mbggenerated
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.TABLE_NAME
	 * @return  the value of fos_system_log.TABLE_NAME
	 * @mbggenerated
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.TABLE_NAME
	 * @param tableName  the value for fos_system_log.TABLE_NAME
	 * @mbggenerated
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.TABLE_COLUMN
	 * @return  the value of fos_system_log.TABLE_COLUMN
	 * @mbggenerated
	 */
	public String getTableColumn() {
		return tableColumn;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.TABLE_COLUMN
	 * @param tableColumn  the value for fos_system_log.TABLE_COLUMN
	 * @mbggenerated
	 */
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn == null ? null : tableColumn.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.TABLE_VALUE
	 * @return  the value of fos_system_log.TABLE_VALUE
	 * @mbggenerated
	 */
	public String getTableValue() {
		return tableValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.TABLE_VALUE
	 * @param tableValue  the value for fos_system_log.TABLE_VALUE
	 * @mbggenerated
	 */
	public void setTableValue(String tableValue) {
		this.tableValue = tableValue == null ? null : tableValue.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column fos_system_log.CONTENT
	 * @return  the value of fos_system_log.CONTENT
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column fos_system_log.CONTENT
	 * @param content  the value for fos_system_log.CONTENT
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table fos_system_log
	 * @mbggenerated
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", userName=").append(userName);
		sb.append(", email=").append(email);
		sb.append(", phone=").append(phone);
		sb.append(", trueName=").append(trueName);
		sb.append(", roleId=").append(roleId);
		sb.append(", roleName=").append(roleName);
		sb.append(", dateTime=").append(dateTime);
		sb.append(", tableName=").append(tableName);
		sb.append(", tableColumn=").append(tableColumn);
		sb.append(", tableValue=").append(tableValue);
		sb.append(", content=").append(content);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}