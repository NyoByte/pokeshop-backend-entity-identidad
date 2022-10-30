package com.pokeshop.ecommerce.utils;

import org.springframework.hateoas.Link;

public interface EntityDto<E, D> {

    D fromEntity(E entity);

    D fromEntity(D template, E entity);

    E toEntity();

    D add(Link link);

}