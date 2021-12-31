package com.uj.splititerator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class UserSpliterator implements Spliterator<User> {

	private Spliterator<String> lineSpliterator;
	private String name;
	private Integer userId;
	private String address;

	public UserSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super User> action) {
		if (this.lineSpliterator.tryAdvance(line -> this.userId = Integer.valueOf(line))
				&& this.lineSpliterator.tryAdvance(line -> this.name = line)
				&& this.lineSpliterator.tryAdvance(line -> this.address = line)) {
			User user = new User(userId, name, address);
			action.accept(user);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Spliterator<User> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		// We need to split 3 lines at a time
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}
