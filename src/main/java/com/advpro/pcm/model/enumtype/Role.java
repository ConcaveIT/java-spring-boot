package com.advpro.pcm.model.enumtype;

import static com.advpro.pcm.model.enumtype.Permission.PROJECT_READ;
import static com.advpro.pcm.model.enumtype.Permission.PROJECT_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.PROJECT_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.PROJECT_DELETE;

import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_READ;
import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_CATEGORY_DELETE;

import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_READ;
import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.COST_ITEM_DELETE;

import static com.advpro.pcm.model.enumtype.Permission.MEMBER_READ;
import static com.advpro.pcm.model.enumtype.Permission.MEMBER_CREATE;
import static com.advpro.pcm.model.enumtype.Permission.MEMBER_UPDATE;
import static com.advpro.pcm.model.enumtype.Permission.MEMBER_DELETE;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {

	VISITOR(Collections.emptySet()),
	ADMIN(
	Set.of(
		    PROJECT_READ,
		    PROJECT_CREATE,
		    PROJECT_UPDATE,
		    PROJECT_DELETE,

		    COST_CATEGORY_READ,
		    COST_CATEGORY_CREATE,
		    COST_CATEGORY_UPDATE,
		    COST_CATEGORY_DELETE,

		    COST_ITEM_READ,
		    COST_ITEM_CREATE,
		    COST_ITEM_UPDATE,
		    COST_ITEM_DELETE,

		    MEMBER_READ,
		    MEMBER_CREATE,
		    MEMBER_UPDATE,
		    MEMBER_DELETE
		)
	),
	MEMBER(
		Set.of(
			PROJECT_READ,
		    PROJECT_CREATE,
		    PROJECT_UPDATE,

		    COST_CATEGORY_READ,
		    COST_CATEGORY_CREATE,
		    COST_CATEGORY_UPDATE,

		    COST_ITEM_READ,
		    COST_ITEM_CREATE,
		    COST_ITEM_UPDATE,

		    MEMBER_READ,
		    MEMBER_CREATE,
		    MEMBER_UPDATE
		)
	);

	@Getter
	private final Set<Permission> permissions;

	public List<SimpleGrantedAuthority> getAuthorities() {
		var authorities = getPermissions()
			.stream()
			.map(permission->new SimpleGrantedAuthority(permission.getPermission()))
			.collect(Collectors.toList());

		authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		
		return authorities;
	}

}
