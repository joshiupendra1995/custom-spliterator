package com.uj.splititerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class TestSplitIterator {

	public static void main(String[] args) {
		Path path = Paths.get("user.csv");
		try (Stream<String> lines = Files.lines(path)) {
			Spliterator<String> lineSpliterator = lines.spliterator();
			Spliterator<User> userSpliterator = new UserSpliterator(lineSpliterator);
			Stream<User> user = StreamSupport.stream(userSpliterator, false);
			user.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
