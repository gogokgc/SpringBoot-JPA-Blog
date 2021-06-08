package com.kgc.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply {
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne  // Many = Reply, One = board 여려 답글을 하나의 게시물에 작성 가능하다.
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne  // Many = Reply, One = User 여러개의 답글을 하나의 유저가 작성가능하다.
	@JoinColumn(name = "userId")
	private BlogUser user;
	
	@CreationTimestamp
	private Timestamp createDate;

}
