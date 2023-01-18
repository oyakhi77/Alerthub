package com.Softworks.GetStarted;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends CrudRepository<User, Integer> {
	User findOneByEmailIgnoreCaseAndPassword(String Email, String Password);

}
