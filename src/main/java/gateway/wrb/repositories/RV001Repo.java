package gateway.wrb.repositories;


import gateway.wrb.domain.RV001Info;

import java.util.List;

public interface RV001Repo {
    List<RV001Info> getAllRV001();
    RV001Info getRV001byID(long id);
    void addRV001(RV001Info rv001Info);
    void updateRV001(RV001Info rv001Info);
    void deleteRV001(long id);
    boolean isRV001Exist(String msgDscd, String trnDt, String trnTm, String msgNo, String wrdacNo, String rcvacNo, String amount);
}
