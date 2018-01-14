package com.nandulabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nandulabs.dao.UserDao;
import com.nandulabs.model.SiteUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void register(SiteUser user) {
		user.setRole("ROLE_USER");
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		SiteUser user = userDao.findByEmail(email);
		if(user == null) {
			return null;
		}
		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		String password = user.getPassword();
		
		return new User(email, password, auth);
	}
}
