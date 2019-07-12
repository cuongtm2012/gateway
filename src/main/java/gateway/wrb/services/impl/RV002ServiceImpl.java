package gateway.wrb.services.impl;

import gateway.wrb.config.RV002Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.RV002Info;
import gateway.wrb.repositories.RV002Repo;
import gateway.wrb.services.RV002Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class RV002ServiceImpl implements RV002Service {
    @Autowired
    RV002Config rv002Config;

    @Autowired
    RV002Repo rv002Repo;

    @Override
    public List<RV002Info> getAllRV002() {
        return null;
    }

    @Override
    public RV002Info getRV002(long id) {
        return null;
    }

    @Override
    public void importRV002(String fullPath) {
        Integer outActNoLength = rv002Config.getOutActNoLength();
        Integer virActNoLength = rv002Config.getVirActNoLength();
        Integer virAcNmLength = rv002Config.getVirAcNmLength();
        Integer refNoLength = rv002Config.getRefNoLength();
        Integer recCodCdLength = rv002Config.getRecCodCdLength();
        Integer trnAmLength = rv002Config.getTrnAmLength();
        Integer trnAvlSdtLength = rv002Config.getTrnAvlSdtLength();
        Integer trnAvlEdtLength = rv002Config.getTrnAvlEdtLength();
        Integer trnAvlStmLength = rv002Config.getTrnAvlStmLength();
        Integer trnAvlEtmLength = rv002Config.getTrnAvlEtmLength();
        Integer trnAvlYnLength = rv002Config.getTrnAvlYnLength();
        Integer corpRecCompCodeLength = rv002Config.getCorpRecCompCodeLength();
        Integer fillerLength = rv002Config.getFillerLength();

        try (Stream<String> stream = Files.lines(Paths.get(fullPath))) {
            stream.forEach(line -> {
                if (!line.startsWith(FileType.PREFIX_START) && !line.startsWith(FileType.PREFIX_END)) {
                    String outActNo = line.substring(0, outActNoLength);
                    line = line.substring(outActNoLength);
                    String virActNo = line.substring(0, virActNoLength);
                    line = line.substring(virActNoLength);
                    String virAcNm = line.substring(0, virAcNmLength);
                    line = line.substring(virAcNmLength);
                    String refNo = line.substring(0, refNoLength);
                    line = line.substring(refNoLength);
                    String recCodCd = line.substring(0, recCodCdLength);
                    line = line.substring(recCodCdLength);
                    String trnAm = line.substring(0, trnAmLength);
                    line = line.substring(trnAmLength);
                    String trnAvlSdt = line.substring(0, trnAvlSdtLength);
                    line = line.substring(trnAvlSdtLength);
                    String trnAvlEdt = line.substring(0, trnAvlEdtLength);
                    line = line.substring(trnAvlEdtLength);
                    String trnAvlStm = line.substring(0, trnAvlStmLength);
                    line = line.substring(trnAvlStmLength);
                    String trnAvlEtm = line.substring(0, trnAvlEtmLength);
                    line = line.substring(trnAvlEtmLength);
                    String trnAvlYn = line.substring(0, trnAvlYnLength);
                    line = line.substring(trnAvlYnLength);
                    String corpRecCompCode = line.substring(0, corpRecCompCodeLength);
                    line = line.substring(corpRecCompCodeLength);
                    String filler = line.substring(0, fillerLength);
                    line = line.substring(fillerLength);

                    System.out.println("rv002Path : [" + fullPath + ", outActNo :" + outActNo + ", virActNo:" + virActNo + ", virAcNm :" + virAcNm + ", refNo :" + refNo + ", recCodCd:" + recCodCd + ", trnAm:" + trnAm
                            + ", trnAvlSdt:" + trnAvlSdt + ", trnAvlEdt:" + trnAvlEdt + ", trnAvlStm:" + trnAvlStm + ", trnAvlEtm:" + trnAvlEtm + ", trnAvlYn:" + trnAvlYn + ", corpRecCompCode:" + corpRecCompCode + ", filter:" + filler +"]");

                    // save to DB
                    RV002Info rv002Info = new RV002Info();
                    rv002Info.setOutActNo(outActNo);
                    rv002Info.setVirActNo(virActNo);
                    rv002Info.setVirAcNm(virAcNm);
                    rv002Info.setRefNo(refNo);
                    rv002Info.setRecCodCd(recCodCd);
                    rv002Info.setTrnAm(trnAm);
                    rv002Info.setTrnAvlSdt(trnAvlSdt);
                    rv002Info.setTrnAvlEdt(trnAvlEdt);
                    rv002Info.setTrnAvlStm(trnAvlStm);
                    rv002Info.setTrnAvlEtm(trnAvlEtm);
                    rv002Info.setTrnAvlyn(trnAvlYn);
                    rv002Info.setCorpRecCompCode(corpRecCompCode);
                    rv002Info.setFilter(filler);
                    rv002Repo.addRV002(rv002Info);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRV002(RV002Info rv002Info) {

    }

    @Override
    public void deleteRV002(long userId) {

    }

    @Override
    public boolean isRV002exist(RV002Info rv002Info) {
        return false;
    }
}
