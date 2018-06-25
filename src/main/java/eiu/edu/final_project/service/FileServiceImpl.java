package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.File;
import eiu.edu.final_project.repository.IFileRepository;
import eiu.edu.final_project.service.serviceInterface.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements IFileService {
	
	@Autowired
	IFileRepository iFileRepository;

	@Override
	public File findById(int id) {
		return iFileRepository.findOne(id);
	}

	@Override
	public List<File> findByFileId(int id) {
		return null;
	}

	@Override
	public void saveFile(File file) {
		iFileRepository.saveAndFlush(file);
		
	}

	@Override
	public void updateFile(File file) {
		saveFile(file);
		
	}

	@Override
	public void deleteFileById(int id) {
		iFileRepository.delete(id);
		
	}

	@Override
	public void deleteAllFile() {
		iFileRepository.deleteAll();
	}

	@Override
	public List<File> findAllFiles() {
		return (List<File>)iFileRepository.findAll();
	}

	@Override
	public boolean isFileExist(File file) {
		return false;
	}

}
