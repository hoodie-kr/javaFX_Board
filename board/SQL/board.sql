-- 게시판 테이블 생성
CREATE TABLE `board` (
	`no` 			    INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 번호',
  `title` 		  VARCHAR(100) NOT NULL COMMENT '제목',
	`writer`		  VARCHAR(100) NOT NULL COMMENT '작성자',
  `content`		  TEXT NULL COMMENT '내용',
  `created_at`	TIMESTAMP NOT NULL DEFAULT now() COMMENT '등록일자',
  `updated_at` 	TIMESTAMP NOT NULL DEFAULT now() COMMENT '수정일자'
) COMMENT = '게시판';