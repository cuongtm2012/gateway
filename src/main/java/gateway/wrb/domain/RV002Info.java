package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rv002")
@Data
public class RV002Info implements Serializable {
    @Id
    @GeneratedValue
    private Long rv002Id;

    private String msgDscdS;
    private String coNoS;
    private String aplDscdS;
    private String fillerS;

    @Column(name="msgDscd")
    private String msgDscd;
    @Column(name="outActNo")
    private String outActNo;
    @Column(name="virActNo")
    private String virActNo;
    @Column(name="virAcNm")
    private String virAcNm;
    @Column(name="refNo")
    private String refNo;
    @Column(name="recCodCd")
    private String recCodCd;
    @Column(name="trnAm")
    private String trnAm;
    @Column(name="trnAvlSdt")
    private String trnAvlSdt;
    @Column(name="trnAvlEdt")
    private String trnAvlEdt;
    @Column(name="trnAvlStm")
    private String trnAvlStm;
    @Column(name="trnAvlEtm")
    private String trnAvlEtm;
    @Column(name="trnAvlyn")
    private String trnAvlyn;
    @Column(name="corpRecCompCode")
    private String corpRecCompCode;
    @Column(name="filter")
    private String filter;

    private String msgDscdE;
    private String totCntE;
    private String totReqCntE;
    private String totReqAmtE;
    private String fillerE;
}