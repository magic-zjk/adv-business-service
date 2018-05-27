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

import com.imopan.adv.platform.mongo.bean.CpaCampaign;

@Repository
public class CpaCampaignDao extends BasicDAO<CpaCampaign, Datastore> {

	private Logger log = LoggerFactory.getLogger(CpaCampaignDao.class);

	@Autowired(required = true)
	public CpaCampaignDao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}
	public boolean updateCpaCampaign(CpaCampaign msb) {
		Query<CpaCampaign> q = getDs().createQuery(CpaCampaign.class);
		q.field("campaignid").equal(msb.getCampaignid());
		UpdateOperations<CpaCampaign> ops = getDs().createUpdateOperations(CpaCampaign.class);
		ops.set("efftime", msb.getEfftime()); 
		ops.set("exptime", msb.getExptime());
		UpdateResults result = getDs().update(q, ops, true); 
		return result.getWriteResult().getN()>0;
	}
	
	
	


}