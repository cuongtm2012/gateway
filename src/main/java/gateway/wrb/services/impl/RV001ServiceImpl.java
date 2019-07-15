package gateway.wrb.services.impl;

import gateway.wrb.config.FbkConfig;
import gateway.wrb.config.RV001Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.RV001Info;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.repositories.RV001Repo;
import gateway.wrb.services.FbkFilesService;
import gateway.wrb.services.RV001Service;
import gateway.wrb.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class RV001ServiceImpl implements RV001Service {
    @Autowired
    private FbkFilesRepo fbkFilesRepo;
    @Autowired
    private RV001Repo rv001Repo;
    @Autowired
    private FbkFilesService fbkFilesService;
    @Autowired
    private RV001Config rv001Config;
    @Autowired
    private FbkConfig fbkConfig;

    @Override
    public List<RV001Info> getAllRV001() {
        return rv001Repo.getAllRV001();
    }

    @Override
    public RV001Info getRV001(long id) {
        RV001Info obj = rv001Repo.getRV001byID(id);
        return obj;
    }

    @Override
    public void updateRV001(RV001Info rv001) {
        rv001Repo.updateRV001(rv001);
    }

    @Override
    public void deleteRV001(long userId) {
        rv001Repo.deleteRV001(userId);
    }

    @Override
    public boolean isRV001exist(RV001Info rv001) {
        return rv001Repo.isRV001Exist(rv001.getMsgDscd(), rv001.getTrnDt(), rv001.getTrnTm(), rv001.getMsgNo(), rv001.getWdracNo(), rv001.getRcvacNo(), rv001.getWdrAm());
    }

    @Override
    public void importRV001(FbkFilesInfo fbkFilesInfo) {
        Integer coNoLength = rv001Config.getCoNoLength();
        Integer mgscdLength = rv001Config.getMgscdLength();
        Integer recMsgcdLength = rv001Config.getRecMsgcdLength();
        Integer tmsDtLength = rv001Config.getTmsDtLength();
        Integer tmsTmLength = rv001Config.getTmsTmLength();

        Integer msgDscdLength = rv001Config.getMsgDscdLength();
        Integer trnDtLength = rv001Config.getTrnDtLength();
        Integer trnTmLength = rv001Config.getTrnTmLength();
        Integer msgNoLength = rv001Config.getMsgNoLength();
        Integer wdracNoLength = rv001Config.getWdracNoLength();
        Integer wdrViracNoLength = rv001Config.getWdrViracNoLength();
        Integer rcvacNoLength = rv001Config.getRcvacNoLength();
        Integer rcvViracNoLength = rv001Config.getRcvViracNoLength();
        Integer rcvacDeppeNmLength = rv001Config.getRcvacDppeNmLength();
        Integer curCdLength = rv001Config.getCurCdLength();
        Integer wdrAmLength = rv001Config.getWdrAmLength();
        Integer tobkDscdLength = rv001Config.getTobkDscdLength();
        Integer istDscdLength = rv001Config.getIstDscdLength();
        Integer inCdAccGbLength = rv001Config.getInCdAccGbLength();
        Integer rcvbk1CdLength = rv001Config.getRcvbk1CdLength();
        Integer rcvbk2CdLength = rv001Config.getRcvbk2CdLength();
        Integer regModCdLength = rv001Config.getRegModCdLength();
        Integer trnStatLength = rv001Config.getTrnStatLength();
        Integer trnSrnoLength = rv001Config.getTrnSrnoLength();
        Integer refNoLength = rv001Config.getRefNoLength();
        Integer vractCusNmLength = rv001Config.getVractCusNmLength();
        Integer stsDscdLength = rv001Config.getStsDscdLength();

        try (Stream<String> stream = Files.lines(Paths.get(fbkFilesInfo.getFullFbkPath()))) {
            stream.forEach(line -> {
                if (line.startsWith(FileType.PREFIX_START)){
                    String msgDscdS = line.substring(0, msgDscdLength);
                    line = line.substring(msgDscdLength);
                    String coNo = line.substring(0, coNoLength);
                    line = line.substring(coNoLength);
                    String mgscd = line.substring(0, mgscdLength);
                    line = line.substring(mgscdLength);
                    String recMsgcd = line.substring(0, recMsgcdLength);
                    line = line.substring(recMsgcdLength);
                    String tmsDt = line.substring(0, tmsDtLength);
                    line = line.substring(tmsDtLength);
                    String tmsTm = line.substring(0, tmsTmLength);
                    line = line.substring(tmsTmLength);

                    fbkFilesInfo.setCoNoS(coNo);
                    fbkFilesInfo.setMgscdS(mgscd);
                    fbkFilesInfo.setRecMsgcdS(recMsgcd);
                    fbkFilesInfo.setTmsDtS(tmsDt);
                    fbkFilesInfo.setTmsTmS(tmsTm);
                    fbkFilesRepo.addFbkFile(fbkFilesInfo);
                } else if (line.startsWith(FileType.PREFIX_CONTENT)) {

                    String msgDscd = line.substring(0, msgDscdLength);
                    line = line.substring(msgDscdLength);
                    String trnDt = line.substring(0, trnDtLength);
                    line = line.substring(trnDtLength);
                    String trnTm = line.substring(0, trnTmLength);
                    line = line.substring(trnTmLength);
                    String msgNo = line.substring(0, msgNoLength);
                    line = line.substring(msgNoLength);
                    String wdracNo = line.substring(0, wdracNoLength);
                    line = line.substring(wdracNoLength);
                    String wdrViracNo = line.substring(0, wdrViracNoLength);
                    line = line.substring(wdrViracNoLength);
                    String rcvacNo = line.substring(0, rcvacNoLength);
                    line = line.substring(rcvacNoLength);
                    String rcvViracNo = line.substring(0, rcvViracNoLength);
                    line = line.substring(rcvViracNoLength);
                    String rcvacDppeNm = line.substring(0, rcvacDeppeNmLength);
                    line = line.substring(rcvacDeppeNmLength);
                    String curCd = line.substring(0, curCdLength);
                    line = line.substring(curCdLength);
                    String wdrAm = line.substring(0, wdrAmLength);
                    line = line.substring(wdrAmLength);
                    String tobkDscd = line.substring(0, tobkDscdLength);
                    line = line.substring(tobkDscdLength);
                    String istDscd = line.substring(0, istDscdLength);
                    line = line.substring(istDscdLength);
                    String inCdAccGb = line.substring(0, inCdAccGbLength);
                    line = line.substring(inCdAccGbLength);
                    String rcvbk1Cd = line.substring(0, rcvbk1CdLength);
                    line = line.substring(rcvbk1CdLength);
                    String rcvbk2Cd = line.substring(0, rcvbk2CdLength);
                    line = line.substring(rcvbk2CdLength);
                    String regModCd = line.substring(0, regModCdLength);
                    line = line.substring(regModCdLength);
                    String trnStat = line.substring(0, trnStatLength);
                    line = line.substring(trnStatLength);
                    String trnSrno = line.substring(0, trnSrnoLength);
                    line = line.substring(trnSrnoLength);
                    String refNo = line.substring(0, refNoLength);
                    line = line.substring(refNoLength);
                    String vractCusNm = line.substring(0, vractCusNmLength);
                    line = line.substring(vractCusNmLength);
                    String stsDscd = line.substring(0, stsDscdLength);
                    line = line.substring(stsDscdLength);

                    System.out.println("rv001Path : [" + fbkFilesInfo.getFullFbkPath() + ", msgDscd :" + msgDscd + ", trnDt:" + trnDt + ", trnTm :" + trnTm + ", msgNo :" + msgNo + ", wdracNo:" + wdracNo + ", wdrViracNo:" + wdrViracNo
                            + ", rcvacNo:" + rcvacNo + ", rcvViracNo:" + rcvViracNo + ", rcvacDppeNm:" + rcvacDppeNm + ", curCd:" + curCd + ", wdrAm:" + wdrAm + ", tobkDscd:" + tobkDscd + ", istDscd:" + istDscd
                            + ", inCdAccGb:" + inCdAccGb + ", rcvbk1Cd:" + rcvbk1Cd + ", rcvbk2Cd:" + rcvbk2Cd + ", regModCd:" + regModCd + ", trnStat:" + trnStat + ", trnSrno:" + trnSrno + ", refNo:" + refNo
                            + ", vractCusNm:" + vractCusNm + ", stsDscd:" + stsDscd +"]");

                    // save to DB
                    RV001Info rv001Info = new RV001Info();
                    rv001Info.setFbkName(fbkFilesInfo.getFbkName());
                    rv001Info.setMsgDscd(msgDscd);
                    rv001Info.setTrnDt(trnDt);
                    rv001Info.setTrnTm(trnTm);
                    rv001Info.setMsgNo(msgNo);
                    rv001Info.setWdracNo(wdracNo);
                    rv001Info.setWdrViracNo(wdrViracNo);
                    rv001Info.setRcvacNo(rcvacNo);
                    rv001Info.setRcvViracNo(rcvViracNo);
                    rv001Info.setRcvacDppeNm(rcvacDppeNm);
                    rv001Info.setCurCd(curCd);
                    rv001Info.setWdrAm(wdrAm);
                    rv001Info.setTobkDscd(tobkDscd);
                    rv001Info.setIstDscd(istDscd);
                    rv001Info.setInCdAccGb(inCdAccGb);
                    rv001Info.setRcvbk1Cd(rcvbk1Cd);
                    rv001Info.setRcvbk2Cd(rcvbk2Cd);
                    rv001Info.setRegModCd(regModCd);
                    rv001Info.setTrnStat(trnStat);
                    rv001Info.setTrnSrno(trnSrno);
                    rv001Info.setRefNo(refNo);
                    rv001Info.setVractCusNm(vractCusNm);
                    rv001Info.setStsDscd(stsDscd);
                    rv001Repo.addRV001(rv001Info);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
