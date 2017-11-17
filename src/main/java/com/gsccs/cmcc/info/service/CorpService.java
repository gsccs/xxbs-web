package com.gsccs.cmcc.info.service;

import java.util.List;

import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.plat.auth.model.User;

public interface CorpService {

	public void addCorp(CorpT corp);

	public void updateCorp(CorpT corp);

	public CorpT getCorp(String id);

	public void delCorp(String id);
	
	public List<CorpT> find(CorpT corpT, String order, int currPage,
			int pageSize);
	
	public List<CorpT> findCorpByUser(CorpT corp,String order, int page,
			int pageSize);
			
	public List<CorpT> find(CorpT corpT);
	
	public int count(CorpT param);
	
	public int countByRole(CorpT corpT,User user);
}
