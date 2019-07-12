package gateway.wrb.services;

import gateway.wrb.domain.FbkFilesInfo;

import java.util.List;
import java.util.Map;

public interface FbkFilesService {
    List<Map<String, FbkFilesInfo>> getFbkFiles(String directory);
    FbkFilesInfo getFbkFiles(long id);
    void addFbkFile(FbkFilesInfo fbkFilesInfo);
    void updateFbkFile(FbkFilesInfo fbkFilesInfo);
    void deteleFbkFile(long userId);
    boolean isFbkFileExist(FbkFilesInfo fbkFilesInfo);
}
