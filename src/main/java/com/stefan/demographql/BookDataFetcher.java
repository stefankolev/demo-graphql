package com.stefan.demographql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Service
public class BookDataFetcher implements DataFetcher<Book> {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book get(DataFetchingEnvironment environment) {

		return bookRepository.findById(environment.getArgument("id")).orElse(null);
	}

}
