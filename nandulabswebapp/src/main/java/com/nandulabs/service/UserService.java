package com.nandulabs.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nandulabs.model.SiteUser;

public interface UserService extends UserDetailsService {

	void register(SiteUser user);

}
