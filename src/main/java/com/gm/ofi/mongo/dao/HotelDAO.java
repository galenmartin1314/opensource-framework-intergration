package com.gm.ofi.mongo.dao;

import org.bson.types.ObjectId;

import com.github.jmkgreen.morphia.Datastore;
import com.github.jmkgreen.morphia.dao.BasicDAO;
import com.gm.ofi.mongo.model.Hotel;

public class HotelDAO extends BasicDAO<Hotel, ObjectId> {

	protected HotelDAO(Datastore ds) {
		super(ds);
	}
	
}
