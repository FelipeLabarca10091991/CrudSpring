package com.fl.api.crudSpring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fl.api.crudSpring.Models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel,Long>{

}
