package com.woowa.photo.config;

import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/**
 * JinqSource 클래스
 *
 * @author 
 * @version 1.0
 * @since 2019.03.14
 */
@Component
public class JinqSource {
    private JinqJPAStreamProvider streams;

    @Autowired
    PhotoDataSourceConfig photoDataSourceConfig;
  


    public <U> JinqStream<U> streamAll(EntityManager em, Class<U> entity) {
        return streams.streamAll(em, entity);
    }

    public <U> JinqStream<U> streamAllPhoto(Class<U> entity) {
        streams = new JinqJPAStreamProvider(photoDataSourceConfig.photoEntityManager().getNativeEntityManagerFactory());
        EntityManager photoEm = photoDataSourceConfig.photoEntityManager().getNativeEntityManagerFactory().createEntityManager();
        return streams.streamAll(photoEm, entity);
    }

    
}
