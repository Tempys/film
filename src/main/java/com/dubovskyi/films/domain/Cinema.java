package com.dubovskyi.films.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cinema {

    @Id
    private long cinemaId;
    private String name;
    private String address;

    @OneToMany(fetch= FetchType.LAZY)
    private List<Session> sessions;

}
