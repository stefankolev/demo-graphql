package com.stefan.demographql;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	
	@Value("classpath:books.graphql")
	Resource resource;
	
	private GraphQL graphQL;
	@Autowired
	private AllBooksDataFetcher allBooksDataFetcher;
	@Autowired
	private BookDataFetcher bookDataFetcher;
	@Autowired
	BookRepository bookRepository;
	
	private void loadDataIntoH2() { 
		Arrays.asList(
			Book.builder()
				.isbn("123")
				.title("title1")
				.authors(new String[] {"stefan"})
				.publishDate("today")
				.build(), 
				Book.builder()
				.isbn("234")
				.title("title2")
				.authors(new String[] {"dori"})
				.publishDate("yesterday")
				.build())
			.stream()
			.forEach(bookRepository::save);
	}
	
	//@PostConstruct
	public void loadSchema() throws IOException { 
		
		loadDataIntoH2();
		
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(resource.getFile());
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
	}
	
	private RuntimeWiring buildRuntimeWiring() { 
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", tw -> 
					
					tw.dataFetcher("allBooks", allBooksDataFetcher)
					.dataFetcher("book", bookDataFetcher))
				.build();
				
	}
	
	public GraphQL getGraphQL() { 
		return graphQL;
	}

}
