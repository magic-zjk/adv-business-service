package com.imopan.adv.platform.mongo.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.imopan.adv.platform.mongo.bean.PeriodListBackUp;

@Repository
public class PeriodListBackUpdao extends BasicDAO<PeriodListBackUp, Datastore> {

	private Logger log = LoggerFactory.getLogger(PeriodListBackUpdao.class);

	@Autowired(required = true)
	public PeriodListBackUpdao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}



}