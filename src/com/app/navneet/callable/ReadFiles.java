package com.app.navneet.callable;

import java.util.ArrayList;

public class ReadFiles {

	private String fileName;
	private String  fileDate;
	private String directoryName;
	
	public ReadFiles(String fileName, String fileDate, String directoryName) {
		super();
		this.fileName = fileName;
		this.fileDate = fileDate;
		this.directoryName = directoryName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getDirectoryName() {
		return directoryName;
	}
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}
	@Override
	public String toString() {
		return "ReadFiles [fileName=" + fileName + ", fileDate=" + fileDate + ", directoryName=" + directoryName + "]";
	}
	
	
	
	
}
