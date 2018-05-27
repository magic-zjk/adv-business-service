package com.imopan.adv.platform.mongo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.imopan.adv.platform.mongo.bean.CpaGroup;

@Repository
public class CpaGroupDao extends BasicDAO<CpaGroup, Datastore> {

	private Logger log = LoggerFactory.getLogger(CpaGroupDao.class);

	@Autowired(required = true)
	public CpaGroupDao(@Qualifier("mongodataStore") Datastore ds) {
		super(ds);
	}
	public boolean updateCpaGroup(CpaGroup msb) {
		Query<CpaGroup> q = getDs().createQuery(CpaGroup.class);
		q.field("groupid").equal(msb.getGroupid());
		UpdateOperations<CpaGroup> ops = getDs().createUpdateOperations(CpaGroup.class);
		ops.set("campaignid", msb.getCampaignid()); 
		ops.set("keyword", msb.getKeyword());
		ops.set("limit", msb.getLimit()==null?0:msb.getLimit());
		ops.set("isnolimit", msb.getIsnolimit());
		if(msb.getTimeinterval().getValue()!=""){
			String[] hourArr = msb.getTimeinterval().getValue().split(",");
			HashMap<String, ArrayList<String>> buildWeekHourMap = buildWeekHourMap(hourArr);
			msb.getTimeinterval().setValuemap(buildWeekHourMap);
		}
		ops.set("timeinterval", msb.getTimeinterval());
		ops.set("deviceversion", msb.getDeviceversion());
		ops.set("device", msb.getDevice());
		ops.set("landingpage", msb.getLandingpage());
		ops.set("isuseitunesurl", msb.getIsuseitunesurl());
		ops.set("price", msb.getPrice());
		ops.set("thirdstep", msb.getThirdstep());
		ops.set("secondstep", msb.getSecondstep());
		ops.set("updatetime", msb.getUpdatetime());
		ops.set("opuserid", msb.getOpuserid());
		ops.set("opusername", msb.getOpusername());
		UpdateResults result = getDs().update(q, ops, true); 
		return result.getWriteResult().getN()>0;
	}
	
	public List<CpaGroup> getCpaGroupList(ArrayList<String> list) {
		Query<CpaGroup> q = getDs().createQuery(CpaGroup.class);
		q.field("groupid").in(list);
		return q.asList();
		
		
	}
	/**
	 * Desc:(..). <br/>
	 * @author guochangqing
	 * @param hourArr
	 * @return
	 */
	public static HashMap<String, ArrayList<String>> buildWeekHourMap(String [] hourArr){
		HashMap<String, ArrayList<String>> changeMap = new LinkedHashMap<String, ArrayList<String>>();
    	//cornMap  除24 对应的余数对应的星期MAP
        Map<String, String> cornMap = new HashMap<String, String>();
	        cornMap.put("0", "1");
	        cornMap.put("1", "2");
	        cornMap.put("2", "3");
	        cornMap.put("3", "4");
	        cornMap.put("4", "5");
	        cornMap.put("5", "6");
	        cornMap.put("6", "7");
        for (String str : hourArr) {
        	int hourCorn = Integer.valueOf(str) - 1;
        	int week = hourCorn / 24;
        	String hour = String.valueOf(hourCorn - 24 * week);
        	String key = cornMap.get(String.valueOf(week));
        	if (!changeMap.containsKey(key)){
        		ArrayList<String> templist=new ArrayList<String>();
        		templist.add(hour);
        		changeMap.put(key, templist);	
        	} else {
        		ArrayList<String> templist = changeMap.get(key);
        		templist.add(hour);       		
        		changeMap.put(key, templist);
        	}
        }
        return changeMap;
    }
	
	public static void main(String[] args) {
		String [] a={"1","2","4","24","25","49","168"};
		Map<String, ArrayList<String>> buildWeekHourMap = buildWeekHourMap(a);
		System.out.println(buildWeekHourMap);	
	}

}