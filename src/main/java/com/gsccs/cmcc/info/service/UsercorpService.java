package com.gsccs.cmcc.info.service;

import java.util.List;

import com.gsccs.cmcc.info.model.UsercorpT;

public interface UsercorpService {

	public void addUsercorp(UsercorpT ucorp);

	public void updateUsercorp(UsercorpT ucorp);

	public UsercorpT getUsercorp(String id);

	public void delUsercorp(String id);

	public List<UsercorpT> find(UsercorpT ucorp, String order, int currPage,
			int pageSize);
	
	public List<UsercorpT> find(UsercorpT ucorp);

	public int count(UsercorpT ucorp);
}
