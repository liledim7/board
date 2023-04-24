package com.jdbc.model.dto;

import java.sql.Date;
import java.util.Objects;

public class Board {

	private int idx;
	private String idv;
	private String title;
	private String contents;
	private int writer;
	private Date write_date;
	public Board() {
		// TODO Auto-generated constructor stub
	}
	public Board(int idx, String idv, String title, String contents, int writer, Date write_date) {
		super();
		this.idx = idx;
		this.idv = idv;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.write_date = write_date;
	}
	
	public String getIdv() {
		return idv;
	}
	public void setIdv(String idv) {
		this.idv = idv;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	@Override
	public String toString() {
		return "Board [idx=" + idx + ", idv=" + idv + ", title=" + title + ", contents=" + contents + ", writer="
				+ writer + ", write_date=" + write_date + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contents, idv, idx, title, write_date, writer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return Objects.equals(contents, other.contents) && Objects.equals(idv, other.idv) && idx == other.idx
				&& Objects.equals(title, other.title) && Objects.equals(write_date, other.write_date)
				&& writer == other.writer;
	}
	
	
	
}
