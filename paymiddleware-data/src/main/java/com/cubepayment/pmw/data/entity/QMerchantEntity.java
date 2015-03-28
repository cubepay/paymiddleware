package com.cubepayment.pmw.data.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QMerchantEntity is a Querydsl query type for MerchantEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMerchantEntity extends EntityPathBase<MerchantEntity> {

    private static final long serialVersionUID = -1066128816L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMerchantEntity merchantEntity = new QMerchantEntity("merchantEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> creationDate = _super.creationDate;

    public final QCybersourceConfigurationEntity cybersourceConfigurationEntity;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdateDate = _super.lastUpdateDate;

    public final StringPath merchantName = createString("merchantName");

    public final StringPath merchantResponseURL = createString("merchantResponseURL");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QMerchantEntity(String variable) {
        this(MerchantEntity.class, forVariable(variable), INITS);
    }

    public QMerchantEntity(Path<? extends MerchantEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMerchantEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMerchantEntity(PathMetadata<?> metadata, PathInits inits) {
        this(MerchantEntity.class, metadata, inits);
    }

    public QMerchantEntity(Class<? extends MerchantEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cybersourceConfigurationEntity = inits.isInitialized("cybersourceConfigurationEntity") ? new QCybersourceConfigurationEntity(forProperty("cybersourceConfigurationEntity")) : null;
    }

}

