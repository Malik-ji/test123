package com.blogpost.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HistoricalRepo extends JpaRepository<HistoricalRepo,Integer>{

	
}
