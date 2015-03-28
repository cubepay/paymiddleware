package com.cubepayment.pmw.data.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCybersourceConfigurationEntity is a Querydsl query type for CybersourceConfigurationEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCybersourceConfigurationEntity extends EntityPathBase<CybersourceConfigurationEntity> {

    private static final long serialVersionUID = -1811325270L;

    public static final QCybersourceConfigurationEntity cybersourceConfigurationEntity = new QCybersourceConfigurationEntity("cybersourceConfigurationEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath accessKey = createString("accessKey");

    //inherited
    public final DateTimePath<java.util.Date> creationDate = _super.creationDate;

    public final StringPath endpointURL = createString("endpointURL");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdateDate = _super.lastUpdateDate;

    public final StringPath profileId = createString("profileId");

    public final StringPath secretKey = createString("secretKey");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QCybersourceConfigurationEntity(String variable) {
        super(CybersourceConfigurationEntity.class, forVariable(variable));
    }

    public QCybersourceConfigurationEntity(Path<? extends CybersourceConfigurationEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCybersourceConfigurationEntity(PathMetadata<?> metadata) {
        super(CybersourceConfigurationEntity.class, metadata);
    }

}

