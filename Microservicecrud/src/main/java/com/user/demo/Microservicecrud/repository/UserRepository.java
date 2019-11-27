package com.user.demo.Microservicecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.demo.Microservicecrud.entity.Userdtls;

@Repository
public interface UserRepository extends JpaRepository<Userdtls, Long>{

}
