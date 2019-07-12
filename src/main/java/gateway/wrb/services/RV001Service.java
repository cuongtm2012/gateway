package gateway.wrb.services;


import gateway.wrb.domain.RV001Info;

import java.util.List;

public interface RV001Service {
    List<RV001Info> getAllRV001();
    RV001Info getRV001(long id);
    void importRV001(String fullPath);
    void updateRV001(RV001Info rv001Info);
    void deleteRV001(long userId);
    boolean isRV001exist(RV001Info rv001Info);
}
