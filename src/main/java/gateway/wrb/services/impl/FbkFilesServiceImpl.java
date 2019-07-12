package gateway.wrb.services.impl;

import gateway.wrb.config.FbkConfig;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.services.FbkFilesService;
import gateway.wrb.util.FileUtils;
import gateway.wrb.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FbkFilesServiceImpl implements FbkFilesService {
    @Autowired
    private FbkFilesRepo fbkFilesRepo;

    @Autowired
    private FbkConfig fbkConfig;

    @Override
    public List<Map<String, FbkFilesInfo>> getFbkFiles(String directory) {
        List<Map<String, FbkFilesInfo>> listFbkFiles = new ArrayList<>();
        FileUtils util = new FileUtils();
        List<String> listByName = util.getFilesDirectory(directory);
        for (int i = 0; i < listByName.size(); i++) {
            String fullFileName = listByName.get(i);
            FbkFilesInfo fbkFilesInfo = new FbkFilesInfo();
            fbkFilesInfo.setFullFbkPath(fullFileName);
            String fileName = fullFileName.substring(fullFileName.lastIndexOf('/') + 1);
            if (fileName.startsWith("fbk_snd")) {
                fbkFilesInfo.setFbkName(fileName);
                String dateTime = convertDateTime(fileName);

                if (fileName.contains(FileType.RV001)) {
                    fbkFilesInfo.setFileType(FileType.RV001);
                } else if (fileName.contains(FileType.HT002)) {
                    fbkFilesInfo.setFileType(FileType.HT002);
                }
                fbkFilesInfo.setDateTime(dateTime);
                // saving to DB
                fbkFilesRepo.addFbkFile(fbkFilesInfo);

                // add to list FBK
                Map<String, FbkFilesInfo> fbkFilesInfoMap = new HashMap<>();
                fbkFilesInfoMap.put(fbkFilesInfo.getFileType(), fbkFilesInfo);
                listFbkFiles.add(fbkFilesInfoMap);
            } else {
            }
        }
        return listFbkFiles;
    }


    private String convertDateTime(String fileName) {
        String dateTime;
        try {
            dateTime = fileName.substring(fileName.lastIndexOf("_") - 1, 8);
        } catch (Exception e) {
            return fileName.substring(fileName.lastIndexOf("_") - 8, fileName.lastIndexOf("_"));
        }
        return dateTime;
    }

    @Override
    public FbkFilesInfo getFbkFiles(long id) {
        return null;
    }

    @Override
    public void addFbkFile(FbkFilesInfo fbkFilesInfo) {

    }

    @Override
    public void updateFbkFile(FbkFilesInfo fbkFilesInfo) {

    }

    @Override
    public void deteleFbkFile(long userId) {

    }

    @Override
    public boolean isFbkFileExist(FbkFilesInfo fbkFilesInfo) {
        return false;
    }
}
