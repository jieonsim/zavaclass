package record.localLog;

import java.sql.Date;
import java.sql.Timestamp;

public class LocalLogVO {
	private int localLogIdx;
	private int userIdx;
	private int placeIdx;
	private String content;
	private String fileName;
	private String fileSystemName;
	private String coverPhoto;
	private long fileSize;
	private Date visitDate;
	private String community;
	private String visibility;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private String hostIp;

	public int getLocalLogIdx() {
		return localLogIdx;
	}

	public void setLocalLogIdx(int localLogIdx) {
		this.localLogIdx = localLogIdx;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSystemName() {
		return fileSystemName;
	}

	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	@Override
	public String toString() {
		return "LocalLogVO [localLogIdx=" + localLogIdx + ", userIdx=" + userIdx + ", placeIdx=" + placeIdx + ", content=" + content + ", fileName=" + fileName + ", fileSystemName=" + fileSystemName
				+ ", coverPhoto=" + coverPhoto + ", fileSize=" + fileSize + ", visitDate=" + visitDate + ", community=" + community + ", visibility=" + visibility + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", hostIp=" + hostIp + "]";
	}
}