package com.cubepayment.pmw.data.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QECommerceTransactionEntity is a Querydsl query type for ECommerceTransactionEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QECommerceTransactionEntity extends EntityPathBase<ECommerceTransactionEntity> {

    private static final long serialVersionUID = -2059012538L;

    public static final QECommerceTransactionEntity eCommerceTransactionEntity = new QECommerceTransactionEntity("eCommerceTransactionEntity");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final StringPath authResponseCode = createString("authResponseCode");

    public final StringPath authResponseTime = createString("authResponseTime");

    public final StringPath authTransRefNo = createString("authTransRefNo");

    public final EnumPath<Currency> currencySupported = createEnum("currencySupported", Currency.class);

    public final NumberPath<Integer> lineItemCount = createNumber("lineItemCount", Integer.class);

    public final StringPath merchantId = createString("merchantId");

    public final NumberPath<Long> quantity = createNumber("quantity", Long.class);

    public final EnumPath<TransactionStatus> transactionStatus = createEnum("transactionStatus", TransactionStatus.class);

    public final EnumPath<TransactionType> transactionType = createEnum("transactionType", TransactionType.class);

    public QECommerceTransactionEntity(String variable) {
        super(ECommerceTransactionEntity.class, forVariable(variable));
    }

    public QECommerceTransactionEntity(Path<? extends ECommerceTransactionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QECommerceTransactionEntity(PathMetadata<?> metadata) {
        super(ECommerceTransactionEntity.class, metadata);
    }

}

