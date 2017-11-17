package com.gsccs.cmcc.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.cmcc.info.dao.CorpTMapper;
import com.gsccs.cmcc.info.model.CorpT;
import com.gsccs.cmcc.info.model.CorpTExample;
import com.gsccs.plat.auth.dao.UserMapper;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.model.UserExample;
import com.gsccs.plat.auth.model.UserExample.Criteria;
import com.gsccs.plat.auth.service.AreaService;
import com.gsccs.plat.auth.service.UserService;
import com.gsccs.plat.bass.Constants;

@Service
public class CorpServiceImpl implements CorpService {

	@Autowired
	private CorpTMapper corpTMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private UserMapper userMapper;

	@Override
	public void addCorp(CorpT corp) {
		if (null != corp) {
			if (StringUtils.isEmpty(corp.getIspcode())) {
				corp.setIspcode(UUID.randomUUID().toString());
			}
			corpTMapper.insert(corp);
		}
	}

	@Override
	public List<CorpT> find(CorpT corp, String order, int currPage, int pageSize) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria c = example.createCriteria();
		proSearchParam(corp, c);
		example.setPageSize(pageSize);
		example.setCurrPage(currPage);
		return corpTMapper.selectPageByExample(example);
	}

	private void proSearchParamByAuth(CorpT corp, CorpTExample.Criteria criteria) {
		if (corp != null) {
			if (corp.getIspcode() != null) {
				criteria.andIspcodeEqualTo(corp.getIspcode());
			}

			if (StringUtils.isNotEmpty(corp.getTitle())) {
				criteria.andTitleLike("%" + corp.getTitle() + "%");
			}
			if (null != corp.getAmuserid()) {
				criteria.andAmuseridEqualTo(corp.getAmuserid());
			}

			if (null != corp.getAcode()) {
				String areaids = areaService.findAllSubAreaIds(corp.getAcode());
				if (StringUtils.isNotEmpty(areaids)) {
					criteria.andAcodeIn(areaids);
				}
			}
		}

	}

	
	private void proSearchParam(CorpT corp, CorpTExample.Criteria criteria) {
		if (corp != null) {
			if (corp.getIspcode() != null) {
				criteria.andIspcodeEqualTo(corp.getIspcode());
			}

			if (StringUtils.isNotEmpty(corp.getTitle())) {
				criteria.andTitleLike("%" + corp.getTitle() + "%");
			}
			if (null != corp.getAmuserid()) {
				criteria.andAmuseridEqualTo(corp.getAmuserid());
			}

			if (null != corp.getAcode()) {
				criteria.andAcodeEqualTo(corp.getAcode());
			}
		}

	}

	
	@Override
	public int countByRole(CorpT corp, User user) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria c = example.createCriteria();
		proSearchParam(corp, c);
		return corpTMapper.countByExample(example);
	}

	
	@Override
	public int count(CorpT corp) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria c = example.createCriteria();
		proSearchParam(corp, c);
		return corpTMapper.countByExample(example);
	}

	@Override
	public CorpT getCorp(String id) {
		return corpTMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateCorp(CorpT corp) {
		if (null != corp) {
			corpTMapper.updateByPrimaryKeySelective(corp);
		}
	}

	@Override
	public void delCorp(String id) {
		corpTMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<CorpT> find(CorpT corp) {
		CorpTExample example = new CorpTExample();
		CorpTExample.Criteria c = example.createCriteria();
		proSearchParam(corp, c);
		return corpTMapper.selectByExample(example);
	}

	@Override
	public List<CorpT> findCorpByUser(CorpT corp, String order, int page,
			int pageSize) {
		List<CorpT> corpList = null;
		Subject subject = SecurityUtils.getSubject();
		String account = (String) subject.getPrincipal();
		User user = userService.findByAccount(account);

		if (subject.hasRole(Constants.ROLE_ADMIN)) { // 系统管理员
			corpList = this.find(corp, order, page, pageSize);
		} else if (subject.hasRole(Constants.ROLE_YY_QA_C)) { // 县级业务主管
			// 县级业务主管
			corp.setAcode(user.getAreaid());
			corpList = this.find(corp, order, page, pageSize);
		} else if (subject.hasRole(Constants.ROLE_YY_QA_A)) {
			// 县级业务主管
			corp.setAcode(user.getAreaid());
			corpList = this.find(corp, order, page, pageSize);
		} else if (subject.hasRole(Constants.ROLE_YY_AM)) { // 客户经理
			corp.setAmuserid(user.getId());
			corpList = this.find(corp, order, page, pageSize);
		} else {
			corp.setAcode(user.getAreaid());
			corp.setAmuserid(user.getId());
			corpList = this.find(corp, order, page, pageSize);
		}
		return corpList;
	}

	public List<Long> getUsers(User user) {
		UserExample uexample = new UserExample();
		Criteria ucriteria = uexample.createCriteria();
		if (null != user && user.getOrgid() != null
				&& !user.getOrgid().equals("")) {
			ucriteria.andOrganizationIdEqualTo(user.getOrgid());
		}
		List<User> userList = userMapper.selectByExample(uexample);

		List<Long> uList = new ArrayList<>();
		for (User u : userList) {
			uList.add(u.getId());
		}
		return uList;
	}

	public String getUserids(User user) {
		String userids = "";
		List<User> uList = null;
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (null != user && user.getOrgid() != null
				&& !user.getOrgid().equals("")) {
			criteria.andOrganizationIdEqualTo(user.getOrgid());
		}
		uList = userMapper.selectByExample(example);
		if (null != uList) {
			for (User u : uList) {
				userids += u.getId() + ",";
			}
			if (userids.length() > 0) {
				userids = userids.substring(0, userids.length() - 1);
			}
			userids = "(" + userids + ")";
		}
		System.out.println("userids = " + userids);
		return userids;
	}
}
