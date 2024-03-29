package gateway.wrb.repositories;


import gateway.wrb.domain.HT002Info;
import gateway.wrb.domain.RV001Info;

import java.util.List;

public interface HT002Repo {
    List<HT002Info> getAllHT002();
    HT002Info getHT002byID(long id);
    void addHT002(HT002Info ht002Info);
    void updateHT002(HT002Info ht002Info);
    void deleteHT002(long id);
    boolean isHT002Exist(String msgDscd, String trnDt, String trnTm, String msgNo, String wrdacNo, String rcvacNo, String amount);
}
