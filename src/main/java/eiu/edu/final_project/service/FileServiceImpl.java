package eiu.edu.final_project.service;

import eiu.edu.final_project.domain.File;
import eiu.edu.final_project.domain.Treatment;
import eiu.edu.final_project.repository.IFileRepository;
import eiu.edu.final_project.repository.ITreatmentRepository;
import eiu.edu.final_project.service.serviceInterface.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    IFileRepository fileRepository;

    @Autowired
    TreatmentServiceIplm treatmentServiceIplm;

    @Override
    public File findById(String id) {
        Optional<File> file = fileRepository.findById(id);
        if (file.isPresent()) {
            return file.get();
        }
        return new File();
    }

    @Override
    public List<File> findByFileId(String id) {
        return null;
    }

    @Override
    public void saveFile(File file) {
//		fileRepository.saveAndFlush(file);
    }

    @Override
    public void updateFile(File file) {
        saveFile(file);
    }

    @Override
    public void deleteFileById(String id) {
        fileRepository.deleteById(id);

    }

    @Override
    public void deleteAllFile() {
        fileRepository.deleteAll();
    }

    @Override
    public List<File> findAllFiles() {
        return (List<File>) fileRepository.findAll();
    }

    @Override
    public boolean isFileExist(File file) {
        return false;
    }

    public Treatment findTreatmentById(String id) {
        return treatmentServiceIplm.findById(id);
    }

}
