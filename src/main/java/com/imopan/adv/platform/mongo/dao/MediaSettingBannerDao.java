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

import com.imopan.adv.platform.mongo.bean.MediaSettingBanner;

@Repository
public class MediaSettingBannerDao extends BasicDAO<MediaSettingBanner, Datastore> {

	private Logger log = LoggerFactory.getLogger(MediaSettingBannerDao.class);

	@Autowired(required = true)
	public MediaSettingBannerDao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}
	public boolean updateMediaSettingBanner(MediaSettingBanner msb) {
		Query<MediaSettingBanner> q = getDs().createQuery(MediaSettingBanner.class);
		q.field("mediaid").equal(msb.getMediaid());
		UpdateOperations<MediaSettingBanner> ops = getDs().createUpdateOperations(MediaSettingBanner.class);
		ops.set("bannerPrice", msb.getBannerPrice());
		ops.set("bannerRequestDiscount", msb.getBannerRequestDiscount());
		ops.set("bannerShowDiscount", msb.getBannerShowDiscount());
		ops.set("bannerClikDiscount", msb.getBannerClikDiscount());
		ops.set("settlementType", msb.getSettlementType());
		UpdateResults result = getDs().update(q, ops, true); 
		return result.getWriteResult().getN()>0;
	}


}