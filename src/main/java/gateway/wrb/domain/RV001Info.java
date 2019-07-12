package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rv001")
@Data
public class RV001Info implements Serializable {
    @Id
    @GeneratedValue
    private Long rv001Id;

    private String msgDscdS;
    private String coNoS;
    private String mgscdS;
    private String recMsgcdS;
    private String tmsDtS;
    private String tmsTmS;
    private String etcS;

    @Column(name="msgDscd")
    private String msgDscd;
    @Column(name="trnDt")
    private String trnDt;
    @Column(name="trnTm")
    private String trnTm;
    @Column(name="msgNo")
    private String msgNo;
    @Column(name="wdracNo")
    private String wdracNo;
    @Column(name="wdrViracNo")
    private String wdrViracNo;
    @Column(name="rcvacNo")
    private String rcvacNo;
    @Column(name="rcvViracNo")
    private String rcvViracNo;
    @Column(name="rcvacDppeNm")
    private String rcvacDppeNm;
    @Column(name="curCd")
    private String curCd;
    @Column(name="wdrAm")
    private String wdrAm;
    @Column(name="tobkDscd")
    private String tobkDscd;
    @Column(name="istDscd")
    private String istDscd;
    @Column(name="inCdAccGb")
    private String inCdAccGb;
    @Column(name="rcvbk1Cd")
    private String rcvbk1Cd;
    @Column(name="rcvbk2Cd")
    private String rcvbk2Cd;
    @Column(name="regModCd")
    private String regModCd;
    @Column(name="trnStat")
    private String trnStat;
    @Column(name="trnSrno")
    private String trnSrno;
    @Column(name="refNo")
    private String refNo;
    @Column(name="vractCusNm")
    private String vractCusNm;
    @Column(name="stsDscd")
    private String stsDscd;

    private String msgDscdE;
    private String NorTranCntE;
    private String NorTranTotAmtE;
    private String OrgCanTranCntE;
    private String OrgCanTranTotAmtE;
    private String CanTranCntE;
    private String CanTranTotAmtE;
}