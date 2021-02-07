package com.alphalog.geocoder.security.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alphalog.geocoder.security.domain.Users;

//@Repository
//public interface UserRepository extends CrudRepository<User, String> {
public interface UserRepository extends MongoRepository<Users, String> {
	Users findByUsername(String username);

}
