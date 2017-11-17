package com.gsccs.cmcc.sem.service;

import java.util.List;

import com.gsccs.cmcc.sem.model.SemrecomdT;

/**
 * 日常推荐业务接口
 * @author x.j niu
 *
 */
public interface RecomdService {

	public Integer add(SemrecomdT recomd);

	public void update(SemrecomdT recomd);

	public SemrecomdT getSemrecomdT(String id);

	public void del(String id);
	
	public List<SemrecomdT> find(SemrecomdT semreport, String order, int currPage,
			int pageSize);
	
	public int count(SemrecomdT semitem);
}
