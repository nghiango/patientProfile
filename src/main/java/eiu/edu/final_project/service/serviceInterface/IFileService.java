package eiu.edu.final_project.service.serviceInterface;

import eiu.edu.final_project.domain.File;

import java.util.List;

public interface IFileService {
    File findById(int id);

    List<File> findByFileId(int id);

    void saveFile(File file);

    void updateFile(File file);

    void deleteFileById(int id);

    void deleteAllFile();

    List<File> findAllFiles();

    boolean isFileExist(File file);
}
