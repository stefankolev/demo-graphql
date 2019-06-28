package com.stefan.demographql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import eu.cec.digit.search.dto.admin.DatabaseDto;
import eu.cec.digit.search.model.KeyInformationApplication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphqlApplication.class, args);
	}
	
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void test() { 
		
//		Database db1 = new Database();
//		db1.setField(new Field());
//		db1.getField().setName("name");
//		
//		Database db2 = new Database();
//	
//		List<Database> demo = Arrays.asList(db1, db2);
//		
//		List<String> result = demo.stream()
//				.map(Database::getField)
//				.filter(Objects::nonNull)
//				.map(Field::getName).collect(toList());
//		
//		
//		int breakpoint = 0;
//		breakpoint ++;
//		
//		log.info("alabala {}", breakpoint);
//		
//		
		
		
		
//		
//		
//		Map<String, String> map = new HashMap<>();
//		map.putIfAbsent("x", null);
//		System.out.print(map.getOrDefault("x", "1"));
//		map.putIfAbsent("x", "2");
//		System.out.print(map.getOrDefault("x", "3"));
//		
//		
//	
//		DatabaseDto db = new DatabaseDto();
//		
//
//		List<DatabaseDto> dbs = new ArrayList<>();
//		
//		dbs.stream().flatMap(Stream.of(DatabaseDto::getReceivers));
//		
//		dbs.addAll(dbs.stream().flatMap(Stream.of(DatabaseDto::getReceivers)));
//		
//		KeyInformationApplication keys = new KeyInformationApplication();
//
//		
//		
//		
		
		
		
		
		
		
		
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	class Database { 
		
		private Field field;
		
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	class Field { 
		String name;
	}

}
