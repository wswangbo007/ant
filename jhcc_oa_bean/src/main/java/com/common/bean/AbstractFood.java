package com.common.bean;

import java.io.IOException;
import java.io.Serializable;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/** 
 * ClassName:AbstractFood <br/> 
 * Date:     2017年1月31日 下午3:06:42 <br/> 
 * @author   神经刀
 * @version  0.1 : 提供食物ID,食物名称,食物大小.
 * @since    JDK 1.8
 * @see      AbstractFood
 * Copyright (c) 2017, wswangbo007@163.com All Rights Reserved. 
 */
public class AbstractFood implements Serializable, IFood<AbstractFood> {
	
	private static final long serialVersionUID = 1L;

	/**食物ID*/
	protected String id;
	
	/**食物名称*/
	protected String foodName;
	
	/**食物大小*/
	protected Double size;

	public AbstractFood() {
		super();
	}

	public AbstractFood(String id, String foodName, Double size) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.size = size;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}
	
	/**
	  * toJSON(转换JSON数据)
	  * @Title: toJSON
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return String    返回类型
	 */
	@Override
	public String toJSON() {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        try {
			json = mapper.writeValueAsString(this);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@Override
	public String toString() {
		return "AbstractFood [id=" + id + ", foodName=" + foodName + ", size=" + size + "]";
	}

	/**
	 * JSON转对象
	  * <p>Title: toThis</p>
	  * <p>Description: </p>
	  * @return AbstractFood
	  * @see com.common.bean.IFood#toThis()
	  */
	@Override
	public AbstractFood toThis(String jsonParams) {
		AbstractFood abstractFood = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        try {
        	abstractFood = mapper.readValue(jsonParams,this.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return abstractFood;
	}
}