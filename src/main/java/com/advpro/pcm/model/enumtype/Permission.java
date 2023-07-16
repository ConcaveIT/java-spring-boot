package com.advpro.pcm.model.enumtype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    PROJECT_READ("project:read"),
    PROJECT_CREATE("project:create"),
    PROJECT_UPDATE("project:update"),
    PROJECT_DELETE("project:delete"),

    COST_CATEGORY_READ("cost_category:read"),
    COST_CATEGORY_CREATE("cost_category:create"),
    COST_CATEGORY_UPDATE("cost_category:update"),
    COST_CATEGORY_DELETE("cost_category:delete"),

    COST_ITEM_READ("cost_item:read"),
    COST_ITEM_CREATE("cost_item:create"),
    COST_ITEM_UPDATE("cost_item:update"),
    COST_ITEM_DELETE("cost_item:delete"),

    MEMBER_READ("member:read"),
    MEMBER_CREATE("member:create"),
    MEMBER_UPDATE("member:update"),
    MEMBER_DELETE("member:delete");

    @Getter
    private final String permission;
    
}
