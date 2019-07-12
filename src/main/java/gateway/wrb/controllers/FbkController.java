package gateway.wrb.controllers;

import gateway.wrb.config.FbkConfig;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.services.FbkFilesService;
import gateway.wrb.services.HT002Service;
import gateway.wrb.services.RV001Service;
import gateway.wrb.services.RV002Service;
import gateway.wrb.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gateway")
public class FbkController {
    public static final Logger logger = LoggerFactory.getLogger(FbkController.class);
    @Autowired
    private FbkFilesService fbkFilesService;

    @Autowired
    private RV001Service rv001Service;

    @Autowired
    private RV002Service rv002Service;

    @Autowired
    private HT002Service ht002Service;

    @Autowired
    private FbkConfig fbkConfig;

    @GetMapping(value = "/all")
    public ResponseEntity<?> readFiles() {
        System.out.println("--------- START ---------- ::" + System.currentTimeMillis());
        List<FbkFilesInfo> fbkList = importFiles();
        if (fbkList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        System.out.println("--------- END ---------- ::" + System.currentTimeMillis());
        return new ResponseEntity<List<FbkFilesInfo>>(fbkList, HttpStatus.OK);
    }

    @GetMapping(value = "/rv001")
    public ResponseEntity<?> importrv001() {
        System.out.println("--------- START ---------- ::" + System.currentTimeMillis());
        List<FbkFilesInfo> rv001Files = new ArrayList<>();
        String directory = fbkConfig.getFbkPath();
        List<Map<String, FbkFilesInfo>> fbkFiles = fbkFilesService.getFbkFiles(directory);
        for (int i = 0; i < fbkFiles.size(); i++) {
            Map<String, FbkFilesInfo> filesInfoMap = fbkFiles.get(i);
            FbkFilesInfo rv001Info = filesInfoMap.get(FileType.RV001);
            if(Validator.validateObject(rv001Info)){
                rv001Service.importRV001(rv001Info.getFullFbkPath());
                rv001Files.add(rv001Info);
            }
        }
        if (rv001Files.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        System.out.println("--------- END ---------- ::" + System.currentTimeMillis());
        return new ResponseEntity<List<FbkFilesInfo>>(rv001Files, HttpStatus.OK);
    }

    @GetMapping(value = "/rv002")
    public ResponseEntity<?> importrv002() {
        System.out.println("--------- START ---------- ::" + System.currentTimeMillis());
        List<FbkFilesInfo> rv002Files = new ArrayList<>();
        String directory = fbkConfig.getFbkPath();
        List<Map<String, FbkFilesInfo>> fbkFiles = fbkFilesService.getFbkFiles(directory);
        for (int i = 0; i < fbkFiles.size(); i++) {
            Map<String, FbkFilesInfo> filesInfoMap = fbkFiles.get(i);
            FbkFilesInfo rv002Info = filesInfoMap.get(FileType.RV002);
            if(Validator.validateObject(rv002Info)){
                rv002Service.importRV002(rv002Info.getFullFbkPath());
                rv002Files.add(rv002Info);
            }
        }
        if (rv002Files.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        System.out.println("--------- END ---------- ::" + System.currentTimeMillis());
        return new ResponseEntity<List<FbkFilesInfo>>(rv002Files, HttpStatus.OK);
    }

    @GetMapping(value = "/ht002")
    public ResponseEntity<?> importht002() {
        System.out.println("--------- START ---------- ::" + System.currentTimeMillis());
        List<FbkFilesInfo> ht002Files = new ArrayList<>();
        String directory = fbkConfig.getFbkPath();
        List<Map<String, FbkFilesInfo>> fbkFiles = fbkFilesService.getFbkFiles(directory);

        for (int i = 0; i < fbkFiles.size(); i++) {
            Map<String, FbkFilesInfo> filesInfoMap = fbkFiles.get(i);
            FbkFilesInfo ht002FilesInfo = filesInfoMap.get(FileType.HT002);
            if(Validator.validateObject(ht002FilesInfo)){
                ht002Service.importHT002(ht002FilesInfo.getFullFbkPath());
                ht002Files.add(ht002FilesInfo);
            }
        }

        if (ht002Files.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        System.out.println("--------- END ---------- ::" + System.currentTimeMillis());
        return new ResponseEntity<List<FbkFilesInfo>>(ht002Files, HttpStatus.OK);
    }

    public List<FbkFilesInfo> importFiles() {
        List<FbkFilesInfo> totalFiles = new ArrayList<>();
        List<FbkFilesInfo> rv001Files = new ArrayList<>();
        List<FbkFilesInfo> rv002Files = new ArrayList<>();
        List<FbkFilesInfo> ht002Files = new ArrayList<>();
        String directory = fbkConfig.getFbkPath();
        List<Map<String, FbkFilesInfo>> fbkFiles = fbkFilesService.getFbkFiles(directory);

        for (int i = 0; i < fbkFiles.size(); i++) {
            Map<String, FbkFilesInfo> filesInfoMap = fbkFiles.get(i);

            FbkFilesInfo rv001FilesInfo = filesInfoMap.get(FileType.RV001);
            if (Validator.validateObject(rv001FilesInfo)){
                totalFiles.add(rv001FilesInfo);
                rv001Service.importRV001(rv001FilesInfo.getFullFbkPath());
                rv001Files.add(rv001FilesInfo);
            }

            FbkFilesInfo rv002FilesInfo = filesInfoMap.get(FileType.RV002);
            if(Validator.validateObject(rv002FilesInfo)){
                totalFiles.add(rv002FilesInfo);
                rv002Service.importRV002(rv002FilesInfo.getFullFbkPath());
                rv002Files.add(rv002FilesInfo);
            }

            FbkFilesInfo ht002FilesInfo = filesInfoMap.get(FileType.HT002);
            if(Validator.validateObject(ht002FilesInfo)){
                totalFiles.add(ht002FilesInfo);
                ht002Service.importHT002(ht002FilesInfo.getFullFbkPath());
                ht002Files.add(ht002FilesInfo);
            }
        }
        return totalFiles;
    }
}
