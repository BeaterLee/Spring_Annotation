package com.beater.springannotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beater.springannotation.dao.BookDao;

@Service
public class BookService {
	//指定注入
	//@Qualifier("bookDao2")
	@Autowired(required=false)
	private BookDao bookDao;

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
}
