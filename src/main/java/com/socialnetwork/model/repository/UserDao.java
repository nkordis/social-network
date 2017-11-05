package com.socialnetwork.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialnetwork.model.entity.SiteUser;

@Repository
public interface UserDao extends CrudRepository<SiteUser, Long> {

	SiteUser findByEmail(String email);
}
