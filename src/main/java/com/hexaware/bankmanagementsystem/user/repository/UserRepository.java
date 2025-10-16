
package com.hexaware.bankmanagementsystem.user.repository;

import com.hexaware.bankmanagementsystem.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}


// CrudRespository --> Insert Update Delete and select
