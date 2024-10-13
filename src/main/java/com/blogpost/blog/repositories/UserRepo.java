package com.blogpost.blog.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.blogpost.blog.entities.Loginmaster;
import com.blogpost.blog.entities.User;

@Repository
public interface UserRepo  extends JpaRepository<Loginmaster, Integer> {

	
    	Optional<Loginmaster> findByUsername(String username);
    	void deleteByUsername(String username);
    	

        @Query("SELECT u FROM Loginmaster u WHERE u.username = :username AND u.password = :password")
        Optional<Loginmaster> findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
