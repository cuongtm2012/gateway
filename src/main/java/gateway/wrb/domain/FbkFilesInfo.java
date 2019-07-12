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
    private Long fbkId;
    private String fbkName;
    private String fullFbkPath;
    private String fileType;
    private String dateTime;
}