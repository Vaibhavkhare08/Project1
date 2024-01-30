package com.newproject.project1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproject.project1.model.Book;

public interface Bookrepository extends JpaRepository<Book, Long> {

}
