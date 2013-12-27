package com.gm.ofi.mongo.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class MongoFactoryBean extends AbstractFactoryBean<MongoClient> {
	// 表示服务器列表(主从复制或者分片)的字符串数组
	private String[] serverStrings;
	// mongoDB配置对象
	private MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().build();
	// 是否主从分离(读取从库)，默认读写都在主库
	private boolean readSecondary = false;
	// 设定写策略(出错时是否抛异常)，默认采用SAFE模式(需要抛异常)
	private WriteConcern writeConcern = WriteConcern.SAFE;
	
	public void setMongoClientOptions(MongoClientOptions mongoClientOptions) {
		this.mongoClientOptions = mongoClientOptions;
	}
	
	public void setServerStrings(String[] serverStrings) {
		this.serverStrings = serverStrings;
	}

	public void setReadSecondary(boolean readSecondary) {
		this.readSecondary = readSecondary;
	}

	public void setWriteConcern(WriteConcern writeConcern) {
		this.writeConcern = writeConcern;
	}

	@Override
	public Class<?> getObjectType() {
		return MongoClient.class;
	}

	@Override
	protected MongoClient createInstance() throws Exception {
		
		MongoClient mongo = initMongoClient();

		// 设定主从分离
		if (readSecondary) {
			mongo.setReadPreference(ReadPreference.secondaryPreferred());
		}

		// 设定写策略
		mongo.setWriteConcern(writeConcern);
		return mongo;
	}

	/**
	 * 初始化mongo实例
	 * 
	 * @return
	 * @throws Exception
	 */
	private MongoClient initMongoClient() throws Exception {
		// 根据条件创建Mongo实例
		MongoClient mongo = null;
		List<ServerAddress> serverList = getServerList();

		if (serverList.size() == 0) {
			mongo = new MongoClient();
		} else if (serverList.size() == 1) {
			if (mongoClientOptions != null) {
				mongo = new MongoClient(serverList.get(0), mongoClientOptions);
			} else {
				mongo = new MongoClient(serverList.get(0));
			}
		} else {
			if (mongoClientOptions != null) {
				mongo = new MongoClient(serverList, mongoClientOptions);
			} else {
				mongo = new MongoClient(serverList);
			}
		}
		return mongo;
	}

	/**
	 * 根据服务器字符串列表，解析出服务器对象列表
	 * <p>
	 * 
	 * @Title: getServerList
	 *         </p>
	 * 
	 * @return
	 * @throws Exception
	 */
	private List<ServerAddress> getServerList() throws Exception {
		List<ServerAddress> serverList = new ArrayList<ServerAddress>();
		try {
			for (String serverString : serverStrings) {
				String[] temp = serverString.split(":");
				String host = temp[0];
				if (temp.length > 2) {
					throw new IllegalArgumentException(
							"Invalid server address string: " + serverString);
				}
				if (temp.length == 2) {
					serverList.add(new ServerAddress(host, Integer
							.parseInt(temp[1])));
				} else {
					serverList.add(new ServerAddress(host));
				}
			}
			return serverList;
		} catch (Exception e) {
			throw new Exception(
					"Error while converting serverString to ServerAddressList",
					e);
		}
	}
}
