package com.tbd.phoneadvice.postgre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tbd.phoneadvice.postgre.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(int id);
    User findUserByName(String name);

}

