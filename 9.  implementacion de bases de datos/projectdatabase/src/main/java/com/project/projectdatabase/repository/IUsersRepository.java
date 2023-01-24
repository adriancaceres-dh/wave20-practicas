package com.project.projectdatabase.repository;

import com.project.projectdatabase.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer>{

}
