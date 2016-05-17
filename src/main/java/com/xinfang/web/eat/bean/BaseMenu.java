package com.xinfang.web.eat.bean;

import java.io.Serializable;

/**
 * 菜单表
 * 
 * @author hk
 *
 */
public class BaseMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String menuUuid;

	protected String foodCode;

	protected String foodName;

	protected String foodDayNumber;

	protected String foodPrice;

	protected String foodType;

	
	public String getMenuUuid() {
		return menuUuid;
	}

	public void setMenuUuid(String menuUuid) {
		this.menuUuid = menuUuid;
	}

	public String getFoodCode() {
		return foodCode;
	}

	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodDayNumber() {
		return foodDayNumber;
	}

	public void setFoodDayNumber(String foodDayNumber) {
		this.foodDayNumber = foodDayNumber;
	}

	public String getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
