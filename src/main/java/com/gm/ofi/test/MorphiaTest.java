package com.gm.ofi.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.github.jmkgreen.morphia.Key;
import com.github.jmkgreen.morphia.query.Query;
import com.github.jmkgreen.morphia.query.UpdateOperations;
import com.github.jmkgreen.morphia.query.UpdateResults;
import com.gm.ofi.mongo.dao.HotelDAO;
import com.gm.ofi.mongo.model.Address;
import com.gm.ofi.mongo.model.Hotel;

public class MorphiaTest {
	private static HotelDAO hotelDAO;

	/**
	 * 测试Morphia的DAO层
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	    // 初始化DAO
	    initDAO();

	    // 插入测试
	    //saveTest();

	    // 更新测试
	    // updateTest();

	    // 删除测试
	    // deleteTest();

	    // 查询测试
	    queryHotel();

	    System.out.println("done!");
	}

	/**
	 * 初始化DAO
	 * <p>
	 * @Title: initDAO
	 * </p>
	 */
	private static void initDAO() {
	    ApplicationContext context = new FileSystemXmlApplicationContext("D:\\workspace\\osoa\\src\\main\\resources\\osoa-context.xml");
	    hotelDAO = (HotelDAO) context.getBean("hotelDAO");
	}

	/**
	 * 生成指定个数的hotelList
	 * <p>
	 * @Title: getHotelList
	 * </p>
	 * 
	 * @param num
	 * @return
	 */
	private static List<Hotel> getHotelList(int num) {
	    List<Hotel> list = new ArrayList<Hotel>();
	    for (int i = 0; i < num; i++) {
	        Hotel hotel = new Hotel();
	        hotel.setName("编号为[" + i + "]的旅店");
	        hotel.setStars(i % 10);
	        Address address = new Address();
	        address.setCountry("中国");
	        address.setCity("北京");
	        address.setStreet("上帝南路");
	        address.setPostCode("10000" + (i % 10));
	        hotel.setAddress(address);
	        list.add(hotel);
	    }
	    return list;
	}

	/**
	 * 将hotelList插入数据库
	 * <p>
	 * @Title: saveHotelList
	 * </p>
	 * 
	 * @param hotelDAO
	 * @param hotelList
	 */
	private static void saveTest() {
	    List<Hotel> hotelList = getHotelList(100);
	    for (Hotel hotel : hotelList) {
	        // Key<Hotel> key=hotelDAO.save(hotel,WriteConcern.SAFE);
	        Key<Hotel> key = hotelDAO.save(hotel);
	        System.out.println("id为[" + key.getId() + "]的记录已被插入");
	    }
	}

	/**
	 * 更新操作测试
	 * <p>
	 * @Title: updateTest
	 * </p>
	 * 
	 * @throws Exception
	 */
	private static void updateTest() throws Exception {
	    //生成查询条件
	    Query<Hotel> q = hotelDAO.createQuery().field("stars")
	            .greaterThanOrEq(9);
	    //生成更新操作
	    UpdateOperations<Hotel> ops = hotelDAO.createUpdateOperations()
	            .set("address.city", "shanghai").inc("stars");
	    // UpdateResults<Hotel> ur=hotelDAO.update(q, ops);
	    UpdateResults<Hotel> ur = hotelDAO.updateFirst(q, ops);
	    if (ur.getHadError()) {
	        System.out.println(ur.getError());
	        throw new Exception("更新时发生错误");
	    }
	    if (ur.getUpdatedExisting()) {
	        System.out.println("更新成功，更新条数为[" + ur.getUpdatedCount()
	                + "]，插入条数为[" + ur.getInsertedCount() + "]");
	    } else {
	        System.out.println("没有记录符合更新条件");
	    }
	}

	/**
	 * 删除操作测试
	 * <p>
	 * @Title: deleteTest
	 * </p>
	 */
	private static void deleteTest() {
	    ObjectId id = hotelDAO.findIds().get(0);
	    hotelDAO.deleteById(id);

	    Query<Hotel> q = hotelDAO.createQuery().field("stars")
	            .greaterThanOrEq(100);
	    hotelDAO.deleteByQuery(q);
	}

	/**
	 * 查询测试
	 * <p>
	 * @Title: queryHotel
	 * </p>
	 */
	private static void queryHotel() {
	    // 显示所有记录
	    System.out.println("\nhotelDAO.find()=");
	    for (Hotel hotel : hotelDAO.find()) {
	        System.out.println(hotel);
	    }

	    // 统计star大于等于9的数目
	    System.out
	            .println("\nhotelDAO.count(hotelDAO.createQuery().field(\"stars\").greaterThanOrEq(9))="
	                    + hotelDAO.count(hotelDAO.createQuery().field("stars")
	                            .greaterThanOrEq(9)));

	    // 显示符合条件的记录ID
	    List<ObjectId> ids = hotelDAO.findIds("stars", 8);
	    System.out.println("\nhotelDAO.findIds(\"stars\", 8)=");
	    for (ObjectId id : ids) {
	        System.out.println(id);
	    }
	}
}
