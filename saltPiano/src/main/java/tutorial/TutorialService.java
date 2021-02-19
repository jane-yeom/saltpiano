package tutorial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialDao tutorialDao;
	
	// 총갯수와 총페이지수를 구하는 메서드
		
		public int[] getRowPageCount(TutorialVo vo) {
			int totCount = tutorialDao.count(vo); // 총갯수
			// 총페이지 수 = 총갯수/페이지당갯수, 만약 총갯수에서 페이지당갯수로 나눈 나머지가 있으면 +1
			int totPage = totCount / vo.getPageRow();
			if (totCount % vo.getPageRow() > 0) totPage++;
			
			// 목록하단에 노출되는 페이지 범위 구하기
			// 시작페이지값 = (사용자가요청한페이지-1)/페이지당갯수*페이지당갯수+1
			int startpage = (vo.getReqPage()-1)/5*5+1;
			// 마지막페이지값 = 시작페이지-1+페이지당갯수
			int endpage = startpage-1+5;
			if (endpage > totPage) endpage = totPage;
			
			int[] rowPageCount = new int[4];
			rowPageCount[0] = totCount;
			rowPageCount[1] = totPage;
			rowPageCount[2] = startpage;
			rowPageCount[3] = endpage;
			return rowPageCount;
		}
		// 목록을 구하는 메서드
		public List<TutorialVo> getList(TutorialVo vo) {
			return tutorialDao.selectList(vo);
		}
		
		public TutorialVo selectOne(TutorialVo uv) {
			return tutorialDao.selectOne(uv);
		}
		
		public boolean insert(TutorialVo vo) {
			int r = tutorialDao.insert(vo);
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		}

		public boolean delete(TutorialVo vo) {
			int r = tutorialDao.delete(vo);
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean update(TutorialVo vo) {
			int r = tutorialDao.update(vo);
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean update_hits(int no) {
			int r = tutorialDao.update_hits(no);
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		}
		
		
		
		
		
		
		
		
		
	}


