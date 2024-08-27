package tech.green_egypt.domain.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @Document(collection = "Tips")
public class Tip {
    @Id
    private ObjectId id;
    private String tipContent;
    private byte[] tipIcon;
    
}
