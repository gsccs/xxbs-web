package com.gsccs.cmcc.info.service;

import java.util.List;

import com.gsccs.cmcc.data.model.Specline;
import com.gsccs.cmcc.info.model.Specattachs;

public interface SpeclineService {

	public void addSpecline(Specline specline);

	public void addSpecAttach(Specline specline);

	public void updateSpecline(Specline specline);

	public Specline getSpecline(Long id);

	public void delSpecline(Long id);

	public List<Specline> find(Specline specline, String order, int currPage,
			int pageSize);

	public int count(Specline specline);

	public boolean isExist(String ispcode);

	public List<Specattachs> find(Long speclineid);
}
