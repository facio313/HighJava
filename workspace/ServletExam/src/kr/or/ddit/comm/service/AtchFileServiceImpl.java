package kr.or.ddit.comm.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import kr.or.ddit.comm.dao.AtchFileDaoImpl;
import kr.or.ddit.comm.dao.IAtchFileDao;
import kr.or.ddit.comm.vo.AtchFileVO;

public class AtchFileServiceImpl implements IAtchFileService {
	
	private static IAtchFileService fileService;
	
	private IAtchFileDao fileDao;
	
	private AtchFileServiceImpl() {
		fileDao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		if (fileService == null) {
			fileService = new AtchFileServiceImpl();
		}
		return fileService;
	}

	private static final String UPLOAD_DIR = "upload_files";

	@Override
	public AtchFileVO saveAtchFileList(HttpServletRequest req) {
		
		// 업로드 경로 설정하기
		String uploadPath = "d:/D_Other/" + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		AtchFileVO atchFileVO = null;
		
		try {
			String fileName = "";
			
			boolean isFirstFile = true; // 첫 번째 파일 여부
			
			for (Part part : req.getParts()) {
				
				fileName = getFileName(part);
				
				if (fileName != null && !fileName.equals("")) {
					// 파일인 경우...
					if (isFirstFile) { // 첫 번째 파일이 맞다면...
						isFirstFile = false;
						
						// 기본 파일 정보 저장하기
						atchFileVO = new AtchFileVO();
						
						// 기본 파일 정보 저장(VO에 atchFileId가 저장된다.)
						fileDao.insertAtchFile(atchFileVO);
					}
					
					String orignFileName = fileName; // 원본 파일명
					long fileSize = part.getSize(); // 파일 크기
					String saveFileName = ""; // 저장 파일명 --> 중복 가능성 때문에 원본 파일명과 구분하여 저장함
					String saveFilePath = ""; // 저장 파일 경로

					saveFileName = UUID.randomUUID().toString().replace("-", "");
					saveFilePath = uploadPath + File.separator + saveFileName;
					
					// 확장자명 추출
					String fileExtension = orignFileName.lastIndexOf(".") < 0 ? "" : orignFileName.substring(orignFileName.lastIndexOf(".") + 1);
					
					// 업로드 파일(원본 파일) 정보 저장
					part.write(saveFilePath);
					
					atchFileVO.setStreFileNm(saveFileName);
					atchFileVO.setFileSize(fileSize);
					atchFileVO.setOrignlFileNm(orignFileName);
					atchFileVO.setFileStreCours(saveFilePath);
					atchFileVO.setFileExtsn(fileExtension);
					
					// 파일 세부 정보 저장
					fileDao.insertAtchFileDetail(atchFileVO);
					
					part.delete(); // 임시 업로드 파일 삭제하기
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return atchFileVO;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO atchFileVO) {
		return fileDao.getAtchFileList(atchFileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO atchFileVO) {
		return fileDao.getAtchFileDetail(atchFileVO);
	}


	/**
	 * Part 객체를 파싱하여 파일 이름 추출하기
	 * @param part 파싱할 Part 객체
	 * @return 파일명: 존재하지 않으면 NULL(폼 필드인 경우)
	 */
	private String getFileName(Part part) {
		
		/*
		 Content-Disposition 헤더에 대하여...
		 
		 multipart body를 위해 사용되는 경우 ex) 파일 업로드
		 
		 Content-Disposition: form-data
		 Content-Disposition: form-data; name="fieldName"
		 Content-Disposition: form-data; name="fieldName"; filename;
		 
		 */
		for (String content : part.getHeader("Content-Disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
			}
		}
		return null; // filename이 존재하지 않을 경우..(폼 필드)
	}
}
