package com.imopan.adv.platform.mongo.dao;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.imopan.adv.platform.mongo.bean.MediaSettingChaping;

@Repository
public class MediaSettingChapingDao extends BasicDAO<MediaSettingChaping, Datastore> {

	private Logger log = LoggerFactory.getLogger(MediaSettingChapingDao.class);

	@Autowired(required = true)
	public MediaSettingChapingDao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}
	public boolean updateMediaSettingChaping(MediaSettingChaping msb) {
		Query<MediaSettingChaping> q = getDs().createQuery(MediaSettingChaping.class);
		q.field("mediaid").equal(msb.getMediaid());
		UpdateOperations<MediaSettingChaping> ops = getDs().createUpdateOperations(MediaSettingChaping.class);
		ops.set("chpPrice", msb.getChpPrice());
		ops.set("chpRequestDiscount", msb.getChpRequestDiscount());
		ops.set("chpClikDiscount", msb.getChpClikDiscount());
		ops.set("chpShowDiscount", msb.getChpShowDiscount());
		ops.set("settlementType", msb.getSettlementType());
		UpdateResults result = getDs().update(q, ops, true); 
		return result.getWriteResult().getN()>0;
	}


}