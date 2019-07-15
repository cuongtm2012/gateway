package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ht002")
@Data
public class HT002Info implements Serializable {
    @Id
    @GeneratedValue
    private Long ht002Id;

    @Column(name="fbkName")
    private String fbkName;
    @Column(name="msgDscd")
    private String msgDscd;
    @Column(name="actNo")
    private String actNo;
    @Column(name="trnDt")
    private String trnDt;
    @Column(name="trnTm")
    private String trnTm;
    @Column(name="drCr")
    private String drCr;
    @Column(name="trnAmt")
    private String trnAmt;
    @Column(name="trnAfBl")
    private String trnAfBl;
    @Column(name="brCd")
    private String brCd;
    @Column(name="chkAmt")
    private String chkAmt;
    @Column(name="trnType")
    private String trnType;
    @Column(name="particular")
    private String particular;
    @Column(name="depSeq")
    private String depSeq;
    @Column(name="status")
    private String status;
    @Column(name="channelType")
    private String channelType;
    @Column(name="trnSrno")
    private String trnSrno;
    @Column(name="destAccount")
    private String destAccount;
    @Column(name="recieveName")
    private String recieveName;
    @Column(name="refTxt")
    private String refTxt;
    @Column(name="depRmk")
    private String depRmk;
    @Column(name="trmPrcSrno")
    private String trmPrcSrno;
    @Column(name="virActNo")
    private String virActNo;

    private String msgDscdE;
    private String totCntE;
}