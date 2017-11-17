package com.gsccs.plat.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsccs.plat.auth.dao.UserMapper;
import com.gsccs.plat.auth.model.User;
import com.gsccs.plat.auth.model.UserExample;
import com.gsccs.plat.auth.model.UserExample.Criteria;

/**
 * 
 * @author x.d zhang
 * 
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Autowired
	private PasswordHelper passwordHelper;

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user) {
		// 加密密码
		passwordHelper.encryptPassword(user);
		userMapper.insert(user);
		return userMapper.selectByPrimaryKey(user.getId());
	}

	@Override
	public User updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
		return userMapper.selectByPrimaryKey(user.getId());
	}

	@Override
	public void deleteUser(Long userId) {
		userMapper.deleteByPrimaryKey(userId);
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword) {
		User user = userMapper.selectByPrimaryKey(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public User find(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> findAll() {
		UserExample uExample = new UserExample();
		return userMapper.selectByExample(uExample);
	}

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByAccount(String username) {

		UserExample uExample = new UserExample();
		Criteria criteria = uExample.createCriteria();
		criteria.andAccountEqualTo(username);
		List<User> users = userMapper.selectByExample(uExample);
		if (null != users && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> find(User user, String order, int currPage, int pageSize) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(user, criteria);
		example.setCurrPage(currPage);
		example.setPageSize(pageSize);
		return userMapper.selectPageByExample(example);
	}

	@Override
	public int count(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(user, criteria);
		return userMapper.countByExample(example);
	}

	public void proSearchParam(User param, UserExample.Criteria criteria) {
		if (null != param) {
			if (StringUtils.isNotEmpty(param.getTitle())) {
				criteria.andTitleLike("%" + param.getTitle() + "%");
			}

			if (StringUtils.isNotEmpty(param.getAccount())) {
				criteria.andAccountEqualTo(param.getAccount());
			}

			if (null != param.getOrgid()) {
				criteria.andOrganizationIdEqualTo(param.getOrgid());
			}
			
			if (null != param.getAreaid()) {
				criteria.andAreaidEqualTo(param.getAreaid());
			}
		}
	}

	@Override
	public List<User> find(User user) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		proSearchParam(user, criteria);
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> findByRoleCode(String rolecode) {
		return userMapper.selectByRoleCode(rolecode);
	}

}
