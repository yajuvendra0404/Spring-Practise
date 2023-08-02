package com.Learn.TestCases.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Learn.TestCases.Entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{}
