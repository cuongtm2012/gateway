package gateway.wrb.services.impl;

import gateway.wrb.config.HT002Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.HT002Info;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.repositories.HT002Repo;
import gateway.wrb.services.HT002Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class HT002ServiceImpl implements HT002Service {
    @Autowired
    HT002Config ht002Config;
    @Autowired
    HT002Repo ht002Repo;

    @Autowired
    FbkFilesRepo fbkFilesRepo;

    @Override
    public List<HT002Info> getAllHT002() {
        return null;
    }

    @Override
    public HT002Info getHT002(long id) {
        return null;
    }

    @Override
    public void importHT002(FbkFilesInfo fbkFilesInfo) {
        Integer tmsDtLength = ht002Config.getTmsDtLength();
        Integer tmsTmLength = ht002Config.getTmsTmLength();
        Integer coNoLength = ht002Config.getCoNoLength();
        Integer mgscdLength = ht002Config.getMgscdLength();

        Integer msgDscdLength = ht002Config.getMsgDscdLength();
        Integer actNoLength = ht002Config.getActNoLength();
        Integer trnDtLength = ht002Config.getTrnDtLength();
        Integer trnTmLength = ht002Config.getTrnTmLength();
        Integer drCrLength = ht002Config.getDrCrLength();
        Integer trnAmtLength = ht002Config.getTrnAmtLength();
        Integer trnAfBlLength = ht002Config.getTrnAfBlLength();
        Integer brCdLength = ht002Config.getBrCdLength();
        Integer chkAmtLength = ht002Config.getChkAmtLength();
        Integer trnTypeLength = ht002Config.getTrnTypeLength();
        Integer particularLength = ht002Config.getParticularLength();
        Integer depSeqLength = ht002Config.getDepSeqLength();
        Integer statusLength = ht002Config.getStatusLength();
        Integer channelTypeLength = ht002Config.getChannelTypeLength();
        Integer trnSrnoLength = ht002Config.getTrnSrnoLength();
        Integer destAccountLength = ht002Config.getDestAccountLength();
        Integer recieveNameLength = ht002Config.getRecieveNameLength();
        Integer refTxtLength = ht002Config.getRefTxtLength();
        Integer depRmkLength = ht002Config.getDepRmkLength();
        Integer trmPrcSrnoLength = ht002Config.getTrmPrcSrnoLength();
        Integer virActNoLength = ht002Config.getVirActNoLength();

        try (Stream<String> stream = Files.lines(Paths.get(fbkFilesInfo.getFullFbkPath()))) {
            stream.forEach(line -> {
                if (line.startsWith(FileType.PREFIX_START)) {
                    String msgDscdS = line.substring(0, msgDscdLength);
                    line = line.substring(msgDscdLength);
                    String tmsDt = line.substring(0, tmsDtLength);
                    line = line.substring(tmsDtLength);
                    String tmsTm = line.substring(0, tmsTmLength);
                    line = line.substring(tmsTmLength);
                    String coNo = line.substring(0, coNoLength);
                    line = line.substring(coNoLength);
                    String mgsCd = line.substring(0, mgscdLength);
                    line = line.substring(mgscdLength);

                    fbkFilesInfo.setTmsDtS(tmsDt);
                    fbkFilesInfo.setTmsTmS(tmsTm);
                    fbkFilesInfo.setCoNoS(coNo);
                    fbkFilesInfo.setMgscdS(mgsCd);
                    fbkFilesRepo.addFbkFile(fbkFilesInfo);
                } else if (line.startsWith(FileType.PREFIX_CONTENT)) {
                    String msgDscd = line.substring(0, msgDscdLength);
                    line = line.substring(msgDscdLength);
                    String actNo = line.substring(0, actNoLength);
                    line = line.substring(actNoLength);
                    String trnDt = line.substring(0, trnDtLength);
                    line = line.substring(trnDtLength);
                    String trnTm = line.substring(0, trnTmLength);
                    line = line.substring(trnTmLength);
                    String drCr = line.substring(0, drCrLength);
                    line = line.substring(drCrLength);
                    String trnAmt = line.substring(0, trnAmtLength);
                    line = line.substring(trnAmtLength);
                    String trnAfBl = line.substring(0, trnAfBlLength);
                    line = line.substring(trnAfBlLength);
                    String brCd = line.substring(0, brCdLength);
                    line = line.substring(brCdLength);
                    String chkAmt = line.substring(0, chkAmtLength);
                    line = line.substring(chkAmtLength);
                    String trnType = line.substring(0, trnTypeLength);
                    line = line.substring(trnTypeLength);
                    String particular = line.substring(0, particularLength);
                    line = line.substring(particularLength);
                    String depSep = line.substring(0, depSeqLength);
                    line = line.substring(depSeqLength);
                    String status = line.substring(0, statusLength);
                    line = line.substring(statusLength);
                    String channelType = line.substring(0, channelTypeLength);
                    line = line.substring(channelTypeLength);
                    String trnSrno = line.substring(0, trnSrnoLength);
                    line = line.substring(trnSrnoLength);
                    String destAccount = line.substring(0, destAccountLength);
                    line = line.substring(destAccountLength);
                    String recieveName = line.substring(0, recieveNameLength);
                    line = line.substring(recieveNameLength);
                    String refTxt = line.substring(0, refTxtLength);
                    line = line.substring(refTxtLength);
                    String depRmk = line.substring(0, depRmkLength);
                    line = line.substring(depRmkLength);
                    String trmPrcSrno = line.substring(0, trmPrcSrnoLength);
                    line = line.substring(trmPrcSrnoLength);
                    String virActNo = line.substring(0, virActNoLength);
                    line = line.substring(virActNoLength);

                    System.out.println("ht002Path : [" + fbkFilesInfo.getFullFbkPath() + ", msgDscd :" + msgDscd + ", actNo:" + actNo + ", trnDt :" + trnDt + ", trnTm :" + trnTm + ", drCr:" + drCr + ", trnAmt:" + trnAmt
                            + ", trnAfBl:" + trnAfBl + ", brCd:" + brCd + ", chkAmt:" + chkAmt + ", trnType:" + trnType + ", particular:" + particular + ", depSep:" + depSep + ", status:" + status + ", channelType:" + channelType
                            + ", trnSrno:" + trnSrno + ", destAccount:" + destAccount + ", recieveName:" + recieveName + ", refTxt:" + refTxt + ", depRmk:" + depRmk + ", trmPrcSrno:" + trmPrcSrno + ", virActNo:" + virActNo + "]");

                    // save to DB
                    HT002Info ht002Info = new HT002Info();
                    ht002Info.setFbkName(fbkFilesInfo.getFbkName());
                    ht002Info.setMsgDscd(msgDscd);
                    ht002Info.setActNo(actNo);
                    ht002Info.setTrnDt(trnDt);
                    ht002Info.setTrnTm(trnTm);
                    ht002Info.setDrCr(drCr);
                    ht002Info.setTrnAmt(trnAmt);
                    ht002Info.setTrnAfBl(trnAfBl);
                    ht002Info.setBrCd(brCd);
                    ht002Info.setChkAmt(chkAmt);
                    ht002Info.setTrnType(trnType);
                    ht002Info.setParticular(particular);
                    ht002Info.setDepSeq(depSep);
                    ht002Info.setStatus(status);
                    ht002Info.setChannelType(channelType);
                    ht002Info.setTrnSrno(trnSrno);
                    ht002Info.setDestAccount(destAccount);
                    ht002Info.setRecieveName(recieveName);
                    ht002Info.setRefTxt(refTxt);
                    ht002Info.setDepRmk(depRmk);
                    ht002Info.setTrmPrcSrno(trmPrcSrno);
                    ht002Info.setVirActNo(virActNo);
                    ht002Repo.addHT002(ht002Info);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateHT002(HT002Info rv001Info) {

    }

    @Override
    public void deleteHT002(long id) {

    }

    @Override
    public boolean isHT002exist(HT002Info rv001Info) {
        return false;
    }
}
