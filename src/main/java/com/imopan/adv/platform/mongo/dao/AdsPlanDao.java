package com.imopan.adv.platform.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.imopan.adv.platform.mongo.bean.AdsPlan;

@Repository
public class AdsPlanDao extends BasicDAO<AdsPlan, Datastore> {

	private Logger log = LoggerFactory.getLogger(AdsPlanDao.class);

	@Autowired(required = true)
	public AdsPlanDao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}

	public List<AdsPlan> findByIds(List<String> ids) {
		Query<AdsPlan> q = getDs().createQuery(AdsPlan.class);
		List<ObjectId> oids = new ArrayList<ObjectId>();
		for (String id : ids) {
			if (StringUtils.isBlank(id)){
				continue;
			}
			oids.add(new ObjectId(id));
		}
		q.field("_id").in(oids);
		QueryResults<AdsPlan> results = find(q);
		return results.asList();
	}

	public AdsPlan findById(String id) {

		if (ObjectId.isValid(id)) {
			return findOne("_id", new ObjectId(id));
		}
		return null;

	}

}