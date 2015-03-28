package com.cubepayment.pmw.data.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCybersourceTransactionLogEntity is a Querydsl query type for CybersourceTransactionLogEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCybersourceTransactionLogEntity extends EntityPathBase<CybersourceTransactionLogEntity> {

    private static final long serialVersionUID = -283397384L;

    public static final QCybersourceTransactionLogEntity cybersourceTransactionLogEntity = new QCybersourceTransactionLogEntity("cybersourceTransactionLogEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath authAmount = createString("authAmount");

    public final StringPath authAVSCode = createString("authAVSCode");

    public final StringPath authCode = createString("authCode");

    public final StringPath authCVResult = createString("authCVResult");

    public final StringPath authResponse = createString("authResponse");

    public final StringPath authTime = createString("authTime");

    public final StringPath authTransRefNo = createString("authTransRefNo");

    //inherited
    public final DateTimePath<java.util.Date> creationDate = _super.creationDate;

    public final StringPath decision = createString("decision");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> lastUpdateDate = _super.lastUpdateDate;

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final StringPath message = createString("message");

    public final StringPath reasonCode = createString("reasonCode");

    public final StringPath reqAccessKey = createString("reqAccessKey");

    public final StringPath reqAmount = createString("reqAmount");

    public final StringPath reqBillAddressCity = createString("reqBillAddressCity");

    public final StringPath reqBillAddressLine1 = createString("reqBillAddressLine1");

    public final StringPath reqBillToAddressCountry = createString("reqBillToAddressCountry");

    public final StringPath reqBillToEmail = createString("reqBillToEmail");

    public final StringPath reqBillToForename = createString("reqBillToForename");

    public final StringPath reqBillToSurname = createString("reqBillToSurname");

    public final StringPath reqCardExpiryDate = createString("reqCardExpiryDate");

    public final StringPath reqCardNumber = createString("reqCardNumber");

    public final StringPath reqCardType = createString("reqCardType");

    public final StringPath reqCurrency = createString("reqCurrency");

    public final StringPath reqLocale = createString("reqLocale");

    public final StringPath reqPaymentMethod = createString("reqPaymentMethod");

    public final StringPath reqProfileId = createString("reqProfileId");

    public final StringPath reqReferenceNumber = createString("reqReferenceNumber");

    public final StringPath reqTransactionType = createString("reqTransactionType");

    public final StringPath reqTransactionUUID = createString("reqTransactionUUID");

    public final StringPath signedDateTime = createString("signedDateTime");

    public final StringPath transactionId = createString("transactionId");

    public final EnumPath<TransactionStatus> transactionStatus = createEnum("transactionStatus", TransactionStatus.class);

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QCybersourceTransactionLogEntity(String variable) {
        super(CybersourceTransactionLogEntity.class, forVariable(variable));
    }

    public QCybersourceTransactionLogEntity(Path<? extends CybersourceTransactionLogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCybersourceTransactionLogEntity(PathMetadata<?> metadata) {
        super(CybersourceTransactionLogEntity.class, metadata);
    }

}

