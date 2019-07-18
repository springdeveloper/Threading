package com.app.navneet.callable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Worker implements Callable<List<ReadFiles>> {

	private final String folderNaame;
    private final String workerName;
	public Worker(String folder,String workerName) {
		this.folderNaame = folder;
		this.workerName=workerName;
	}

	@Override
	public List<ReadFiles> call() throws Exception {
		System.out.println("Start Worker "+this.workerName);
		Optional<List<ReadFiles>> results = Optional.empty();

		List<ReadFiles> result = getFileDetails(this.folderNaame);
		System.out.println("Thread Sleep");
		Thread.sleep(1000);
		System.out.println("Thread Sleep End");

		Optional<List<ReadFiles>> isData = Optional.ofNullable(result);
		System.out.println("complete Worker "+this.workerName);

		if (isData.isPresent()) {
			return isData.get();
		}
		return results.get();
	}

	public static List<ReadFiles> getFileDetails(String folder) throws IOException {
		List<ReadFiles> data = Files.list(Paths.get(folder)).filter(Files::isReadable).map(it -> {
			ReadFiles rd = new ReadFiles(readByLine(it.toString()), LocalDateTime.now().toString(),
					it.toAbsolutePath().toString());
			return rd;
		}).collect(Collectors.toList());
		return data;
	}

	private static String readByLine(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}
}
