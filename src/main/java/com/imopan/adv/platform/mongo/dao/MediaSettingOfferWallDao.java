package com.imopan.adv.platform.mongo.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.imopan.adv.platform.mongo.bean.MediaSettingOfferWall;

@Repository
public class MediaSettingOfferWallDao extends BasicDAO<MediaSettingOfferWall, Datastore> {

	private Logger log = LoggerFactory.getLogger(MediaSettingOfferWallDao.class);

	@Autowired(required = true)
	public MediaSettingOfferWallDao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}



}