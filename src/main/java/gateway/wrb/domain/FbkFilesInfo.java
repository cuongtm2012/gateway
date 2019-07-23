package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="fbkfiles")
@Data
public class FbkFilesInfo implements Serializable {
    @Id
    @GeneratedValue
    private Long fbkid;
    private String fbkname;
    private String fullfbkpath;
    private String filetype;
    private String trndt;

    private String conos;
    private String mgscds;
    private String recmsgcds;
    private String tmsdts;
    private String tmstms;
    private String apldscd;
}