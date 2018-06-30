package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.File;

import java.util.List;

public interface IFileService {
    File findById(String id);

    List<File> findByFileId(String id);

    void saveFile(File file);

    void updateFile(File file);

    void deleteFileById(String id);

    void deleteAllFile();

    List<File> findAllFiles();

    boolean isFileExist(File file);
}
