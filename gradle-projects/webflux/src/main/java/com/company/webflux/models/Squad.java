package com.company.webflux.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Squad {
    private String squadName;
    private String homeTown;
    private String formed;
    private String secretBase;
    private boolean active;
    private List<Member> members;
}
