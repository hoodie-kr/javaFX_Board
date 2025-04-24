package com.team3.DAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.team3.DTO.Board;

public class BoardDAO extends JDBConnection {

    // 날짜 형식
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
	 * 데이터 목록 조회
	 * @return List<Board> 게시글 목록
	 */
	public List<Board> list() {
		// 게시글 목록을 담을 컬렉션 객체 생성
		List<Board> boardList = new ArrayList<Board>();
		
		// SQL 작성
		String sql = " SELECT * "
				   + " FROM board ";		// 세미콜론 X
		
		try {
			
			// 1. SQL 실행 객체 생성 - Statement (stmt)
			stmt = con.createStatement();
			
			// 2. SQL 실행 요청 -> 결과 ResultSet (rs)
			rs = stmt.executeQuery(sql);
			
			// 3. 조회된 결과를 리스트(boardList)에 추가
			while (rs.next()) {			// next() : 조회 결과의 다음 데이터로 이동
				Board board = new Board();
				
				// 결과 데이터 가져오기
				// rs.getXXX("컬럼명")  : 해당 컬럼의 데이터를 반환
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setCreatedAt(dateFormat.format(rs.getTimestamp("created_at")));
				board.setUpdatedAt(dateFormat.format(rs.getTimestamp("updated_at")));
				
				// 게시글 목록 추가
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			System.err.println("게시글 목록 조회 시, 예외 발생");
			e.printStackTrace();
		}
		// 4. 게시글 목록 반환
		return boardList;
	}

    /**
	 * 데이터 조회
	 * @param no
	 * @return
	 */
	public Board select(int no) {
		
		// 게시글 정보 객체 생성
		Board board = new Board();
		
		// SQL 작성
		String sql = " SELECT * "
				   + " FROM board "
				   + " WHERE no = ? "; 	// no 가 ? 인 데이터만 조회
		
		// 데이터 조회 : SQL 실행 객체 생성 -> SQL 실행 요청 -> 조회 결과 -> 반환
		try {
			// SQL 실행 객체 생성 - PreparedStatement (psmt)
			psmt = con.prepareStatement(sql);
			
			// ? 동적 파라미터 바인딩
			// * psmt.setXXX( 순서번호, 매핑할 값 );
			psmt.setInt( 1, no );		// 1번째 ? 파라미터에 매핑
			
			// SQL 실행 요청
			rs = psmt.executeQuery();
			
			// 조회 결과 1건 가져오기
			if (rs.next()) {
				// 결과 데이터 가져오기
				// rs.getXXX("컬럼명")  : 해당 컬럼의 데이터를 반환
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setCreatedAt(dateFormat.format(rs.getTimestamp("created_at")));
				board.setUpdatedAt(dateFormat.format(rs.getTimestamp("updated_at")));
			}
			
		} catch (SQLException e) {
			System.err.println("게시글 조회 시, 예외 발생");
			e.printStackTrace();
		}
		// 게시글 정보 1건 반환
		return board;
	}


    // 게시글 등록
    public int insert(Board board) {
        int result = 0;

        String sql = " INSERT INTO board ( title, writer, content ) "
                   + " VALUES( ?, ?, ?) ";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, board.getTitle());
            psmt.setString(2, board.getWriter());
            psmt.setString(3, board.getContent());
            result = psmt.executeUpdate();
        } catch (Exception e) {
            System.err.println("게시글 등록 시, 예외 발생");
            e.printStackTrace();
        }
        return result;
    }
    
}